package service.impl;

import constants.ConstForPoint;
import constants.Message;
import dto.Point;
import service.interfaces.FileWrite;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Запись массива точек в файл.
 *
 * @author Andrey
 */
public class FileWritePointImpl implements FileWrite {
    @Override
    public void writeToFile(ArrayList<Point> points, File file, Boolean append) {
        try (var f = new FileOutputStream(file, append);) {
            for (Point point : points) {
                f.write((ConstForPoint.LINE_NAME + point.getName() + ConstForPoint.SKIP_LINE)
                        .getBytes(StandardCharsets.UTF_8));
                f.write((ConstForPoint.LINE_X + point.getX() + ConstForPoint.SKIP_LINE)
                        .getBytes(StandardCharsets.UTF_8));
                f.write((ConstForPoint.LINE_Y + point.getY() + ConstForPoint.SKIP_LINE)
                        .getBytes(StandardCharsets.UTF_8));
            }
        } catch (FileNotFoundException e) {
            System.out.println(Message.FILE_NOT_FOUND.format());
        } catch (IOException e) {
            System.out.println(Message.READING_FILE_ERROR.get());
        }
    }

}
