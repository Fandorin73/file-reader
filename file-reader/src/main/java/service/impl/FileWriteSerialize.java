package service.impl;

import constants.Message;
import dto.Point;
import service.interfaces.FileWrite;

import java.io.*;
import java.util.ArrayList;

/**
 * Запись в файл с сериализацией.
 *
 * @author Andrey
 */
public class FileWriteSerialize implements FileWrite {
    @Override
    public void writeToFile(ArrayList<Point> points, File file, Boolean append) {
        try (var f = new FileOutputStream(file, append); var o = new ObjectOutputStream(f)) {
            if (file.length() < 1) {
                for (Point point : points) {
                    o.writeObject(point);
                }
            } else {
                for (Point point : points) {
                    o.writeObject(point);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(Message.FILE_NOT_FOUND.format());
        } catch (IOException e) {
            System.out.println(Message.READING_FILE_ERROR.get());
        }
    }

    /**
     * Статический вложенный класс для корректной записи в файл с сериализацией.
     *
     * @author Andrey
     */
    static class MyObjectOutputStream extends ObjectOutputStream {
        public MyObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        public void writeStreamHeader() throws IOException {
            return;
        }
    }
}
