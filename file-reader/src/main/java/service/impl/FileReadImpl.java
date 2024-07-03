package service.impl;

import constants.Message;
import dto.Point;
import exception.FileEmptyException;
import service.interfaces.FileRead;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
/**
 * Чтение строки из файла без сериализации.
 *
 * @author Andrey
 */
public class FileReadImpl implements FileRead {
    @Override
    public StringBuilder readFromFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (file.length() < 1) {
                throw new FileEmptyException("Ошибка чтения файла");
            } else {
                FileReader f = new FileReader(file);
                BufferedReader reader = new BufferedReader(f);
                String line = null;
                String ls = System.getProperty("line.separator");
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                }
                reader.close();
                f.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(Message.FILE_NOT_FOUND.format());
        } catch (FileEmptyException e) {
            System.out.println(Message.FILE_EMPTY_ERROR.format(file));
        } catch (IOException e) {
            System.out.println(Message.FILE_DATA_ERROR.format(file));
        }
        return stringBuilder;
    }
}
