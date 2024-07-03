package service.interfaces;

import dto.Point;

import java.io.File;
import java.util.ArrayList;

public interface FileWrite {
    void writeToFile(ArrayList<Point> points,File file,Boolean append);
}
