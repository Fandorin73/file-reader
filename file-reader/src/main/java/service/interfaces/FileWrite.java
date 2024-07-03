package service.interfaces;

import dto.Point;
import java.io.File;
import java.util.ArrayList;
/**
 * Маркер для всех записей в файл.
 *
 * @author Andrey
 */
public interface FileWrite {
    void writeToFile(ArrayList<Point> points,File file,Boolean append);
}
