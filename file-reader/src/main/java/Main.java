import constants.ConstForPoint;
import dto.Point;
import parse.PointParse;
import service.impl.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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

        //Тест сортировки точек и запись в файла
        var fileRead = new FileReadImpl();
        var parsePoint = new PointParse();
        var arrayResult = new ArrayList<Point>();
        var fileWrite1 = new FileWriteSortDistPoint();

        arrayResult = parsePoint
                .parseToObj((StringBuilder) fileRead
                        .readFromFile(new File("Points.txt")));

        fileWrite1.writeToFile(arrayResult, new File(ConstForPoint.FILE_STATISTICS_POINT), true);

    }

}



    /*   //Тест для сериализации
        var fileWrite =new FileWriteSerialize();
        fileWrite.writeToFile(points,new File("Points.txt"), false);
        var fileReadSerialize=new FileReadSerialize();
        System.out.println(fileReadSerialize.readFromFile(new File("Points.txt")));*/




/* //Тест для записи в файл
        System.out.println("Введите полный путь файла");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Введите 'yes', если хотите перезаписать файл\nВведите 'no', eсли хотите добавить данные в файл ");
        String strAppend = scanner.nextLine();
        var fileWrite = new FileWritePointImpl();
        if (strAppend.equalsIgnoreCase("yes")) {
            fileWrite.writeToFile(points, new File(str), false);
        } else {
            fileWrite.writeToFile(points, new File(str), true);
        }
*/


/*      //Тест чтения из файла
        var fileRead = new FileReadImpl();
        var parsePoint = new PointParse();
        var arrayResult = new ArrayList<Point>();

        arrayResult = parsePoint
                .parseToObj((StringBuilder) fileRead
                        .readFromFile(new File("Points.txt")));

        for (Point point : arrayResult) {
            System.out.println(point);
        }
        System.out.println();*/


