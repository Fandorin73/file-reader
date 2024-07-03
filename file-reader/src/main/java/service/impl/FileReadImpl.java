package service.impl;

import constants.Message;
import dto.Point;
import exception.FileEmptyException;
import service.interfaces.FileRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Optional;

public class FileReadImpl implements FileRead {
    @Override
    public ArrayList<Point> readFromFile(File file) {
        try {
            if (file.length() < 1) {
                throw new FileEmptyException("Ошибка чтения файла");

            } else {
                FileInputStream f = new FileInputStream(file);







            }


        } catch (FileNotFoundException e) {
            System.out.println(Message.FILE_NOT_FOUND.format());
        }catch (FileEmptyException e) {
            System.out.println(e.getMessage()+"\n"+Message.FILE_EMPTY_ERROR.format(file));
        }
        return null;
    }
}
