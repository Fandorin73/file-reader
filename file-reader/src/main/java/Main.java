import constants.ConstForPoint;
import dto.Point;
import dto.comparator.PointDistanceFromOriginComparator;
import parse.Parse;
import parse.PointParse;
import service.impl.FileReadImpl;
import service.impl.FileWritePointImpl;
import service.impl.FileWriteSerialize;
import service.impl.FileWriteSortDistPoint;
import service.interfaces.FileRead;
import service.interfaces.FileWrite;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

//TODO: Написание тестов
public class Main {
    public static void main(String[] args) {

        Point p1 = new Point("First Point", 1, 2);
        Point p2 = new Point("Second Point", 12, 5);
        Point p3 = new Point("Third Point", 3, 77);
        Point p4 = new Point("Fourth Point", -3, 6);
        Point p5 = new Point("Fifth Point", 11, -9);
        Point p6 = new Point("Sixth Point", 0, 0);
        Point p7 = new Point("Seventh Point", -3, 0);
        Point p8 = new Point("Eighth Point", 3, 6);
        Point p9 = new Point("Ninth Point", 33, 97);
        Point p10 = new Point("Tenth Point", -20, 99);
        ArrayList<Point> points = new ArrayList<>();
        Collections.addAll(points, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
        //Тест для сериализации
        /* FileWrite fileWrite =new FileWriteSerialize();
        fileWrite.writeToFile(points,new File("Points.txt"), false);
        FileRead fileReadSerialize=new FileReadSerialize();
        System.out.println(fileReadSerialize.readFromFile(new File("Points.txt")));*/

        //Тест для записи в файл
        FileWrite fileWrite = new FileWritePointImpl();
        fileWrite.writeToFile(points, new File("Points.txt"), false);

        //Тест чтения из файла
        FileRead fileRead = new FileReadImpl();
        PointParse parsePoint = new PointParse();
        ArrayList<Point> arrayResult = new ArrayList<>();
        arrayResult = parsePoint
                .parseToObj((StringBuilder) fileRead
                        .readFromFile(new File("Points.txt")));
        for (Point point : arrayResult) {
            System.out.println(point);
        }
        System.out.println();

       /* arrayResult.stream()
                .sorted(new PointDistanceFromOriginComparator())
                .forEach(System.out::println);*/

        FileWrite fileWrite1=new FileWriteSortDistPoint();
        fileWrite1.writeToFile(arrayResult,new File(ConstForPoint.FILE_STATISTICS_POINT),false);


    }

}
