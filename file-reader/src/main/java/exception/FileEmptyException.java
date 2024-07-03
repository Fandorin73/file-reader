package exception;

import constants.ConstForLine;
import constants.Message;

import java.io.IOException;

public class FileEmptyException extends IOException {
    public FileEmptyException(String message) {
        super(message);
    }
}
