package service.interfaces;

import dto.Point;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

public interface FileRead {
    ArrayList<Point> readFromFile(File file);
}
