package exception;

import java.io.IOException;
/**
 * Exception при обращении к пустому файлу.
 *
 * @author Andrey
 */
public class FileEmptyException extends IOException {
    public FileEmptyException(String message) {
        super(message);
    }
}
