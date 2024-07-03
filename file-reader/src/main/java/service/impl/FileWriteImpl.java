package service.impl;

import constants.ConstForLine;
import constants.Message;
import dto.Point;
import service.interfaces.FileWrite;

import java.io.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileWriteImpl implements FileWrite {

    @Override
    // TODO: Сделать метод для перезаписи
    public void writeToFile(ArrayList<Point> points,File file,Boolean append) {
        try {
            FileOutputStream f = new FileOutputStream(file,append);

            for (Point point : points) {
                f.write((ConstForLine.LINE_NAME + point.getName() + ConstForLine.SKIP_LINE).getBytes(StandardCharsets.UTF_8));
                f.write((ConstForLine.LINE_X + point.getX() + ConstForLine.SKIP_LINE).getBytes(StandardCharsets.UTF_8));
                f.write((ConstForLine.LINE_Y + point.getY() + ConstForLine.SKIP_LINE).getBytes(StandardCharsets.UTF_8));
            }
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println(Message.FILE_NOT_FOUND.format());
        } catch (IOException e) {
            System.out.println(Message.READING_FILE_ERROR.get());
        }
    }

}
