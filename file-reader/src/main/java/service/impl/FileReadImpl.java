package service.impl;

import constants.Message;
import exception.FileEmptyException;
import service.interfaces.FileRead;
import java.io.*;

/**
 * Чтение строки из файла без сериализации.
 *
 * @author Andrey
 */
public class FileReadImpl implements FileRead {
    @Override
    public StringBuilder readFromFile(File file) {
        var stringBuilder = new StringBuilder();
        try(FileReader f = new FileReader(file);BufferedReader reader = new BufferedReader(f)) {
            if (file.length() < 1) {
                throw new FileEmptyException("Ошибка чтения файла");
            } else {

                String line = null;
                String ls = System.getProperty("line.separator");
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                }

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
