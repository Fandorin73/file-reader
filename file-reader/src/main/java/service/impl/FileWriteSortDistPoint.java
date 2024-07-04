package service.impl;

import constants.ConstForPoint;
import constants.Message;
import dto.Point;
import dto.comparator.PointDistanceFromOriginComparator;
import parse.PointParse;
import service.interfaces.FileRead;
import service.interfaces.FileWrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Добавление массива отсортированных точек по расстояниюо от (0)(0) в файл.
 *
 * @author Andrey
 */
public class FileWriteSortDistPoint implements FileWrite {

    @Override
    public void writeToFile(ArrayList<Point> points, File file, Boolean append) {
        try {
            FileOutputStream f = new FileOutputStream(file, append);
            points.stream()
                    .sorted(new PointDistanceFromOriginComparator())
                    .forEach(System.out::println);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String currentDate = LocalDateTime.now().format(formatter);
            f.write(("Количество точек: "+ points.size()+" Дата сортировки: "+currentDate+"\n").getBytes(StandardCharsets.UTF_8));
            for (Point point : points) {
                f.write((ConstForPoint.LINE_NAME + point.getName() + ConstForPoint.SKIP_LINE)
                        .getBytes(StandardCharsets.UTF_8));
                f.write((ConstForPoint.LINE_X + point.getX() + ConstForPoint.SKIP_LINE)
                        .getBytes(StandardCharsets.UTF_8));
                f.write((ConstForPoint.LINE_Y + point.getY() + ConstForPoint.SKIP_LINE)
                        .getBytes(StandardCharsets.UTF_8));
            }
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println(Message.FILE_NOT_FOUND.format());
        } catch (IOException e) {
            System.out.println(Message.READING_FILE_ERROR.get());
        }
    }
}
