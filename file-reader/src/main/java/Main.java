import constants.Message;
import dto.Point;
import service.impl.FileReadSerialize;
import service.impl.FileWriteSerialize;
import service.interfaces.FileWrite;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point("First Point", 1, 2, 4);
        Point p2 = new Point("Second Point", 3, 6, 7);
        Point p3 = new Point("Third Point", 3, 6, 7);
        Point p4 = new Point("Fourth  Point", 3, 6, 7);
        Point p5 = new Point("Fifth  Point", 3, 6, 7);
        Point p6 = new Point("Sixth  Point", 3, 6, 7);
        Point p7 = new Point("Seventh  Point", 3, 6, 7);
        Point p8 = new Point("Eighth  Point", 3, 6, 7);
        Point p9 = new Point("Ninth  Point", 3, 6, 7);
        Point p10 = new Point("Tenth Point", 3, 6, 7);
        ArrayList<Point> points=new ArrayList<>();
        Collections.addAll(points,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);
       /* System.out.println(Message.READING_FILE_ERROR.format());
        System.out.println(Message.CONSTRAINT_VIOLATION_ERROR.format(p1));*/

        FileWriteSerialize fileWrite =new FileWriteSerialize();
        fileWrite.writeToFile(points);
        FileReadSerialize fileReadSerialize=new FileReadSerialize();
        System.out.println(fileReadSerialize.readFromFile());



    }

}
