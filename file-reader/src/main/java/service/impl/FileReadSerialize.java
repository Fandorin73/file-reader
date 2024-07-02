package service.impl;

import constants.Message;
import dto.Point;
import service.interfaces.FileRead;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class FileReadSerialize implements FileRead {
    @Override
    public ArrayList<Point> readFromFile() {
        ArrayList<Point> points = new ArrayList<>();
        try {
            FileInputStream f = new FileInputStream(new File("Points.txt"));
            ObjectInputStream o = new ObjectInputStream(f);
            while (true) {
                try {
                    points.add((Point) o.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
            o.close();
            f.close();

        } catch (
                FileNotFoundException e) {
            System.out.println(Message.FILE_NOT_FOUND.format());
        } catch (
                IOException e) {
            System.out.println(Message.READING_FILE_ERROR.get());
        } catch (ClassNotFoundException e) {
            System.out.println(Message.READING_OBJECT_ERROR.get());

        }
        return points;
    }
}