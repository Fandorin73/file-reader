package service.impl;

import constants.Message;
import dto.Point;
import service.interfaces.FileRead;
import java.io.*;
import java.util.ArrayList;
/**
 * Чтение из файла с сериализацией.
 *
 * @author Andrey
 */
public class FileReadSerialize implements FileRead {
    @Override
    public ArrayList<Point> readFromFile(File file) {
        var points = new ArrayList<Point>();
        try( var f = new FileInputStream(file);var o = new ObjectInputStream(f)) {
            while (true) {
                try {
                    points.add((Point) o.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(Message.FILE_NOT_FOUND.format());
        } catch (IOException e) {
            System.out.println(Message.READING_FILE_ERROR.get());
        } catch (ClassNotFoundException e) {
            System.out.println(Message.READING_OBJECT_ERROR.get());

        }
        return points;
    }
}
