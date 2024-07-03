package service.interfaces;

import java.io.File;
/**
 * Маркер для всех чтений из файла.
 *
 * @author Andrey
 */
public interface FileRead <T>{
    T readFromFile(File file);
}
