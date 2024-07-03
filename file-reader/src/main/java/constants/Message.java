package constants;

/**
 * Мессаги для логов.
 *
 * @author Andrey
 */
public enum Message {
    // TODO: 02.07.2024  Ошибки отредактировать
    FILE_NOT_FOUND("File not found"),
    READING_FILE_ERROR("Reading file error"),
    READING_OBJECT_ERROR("Reading object from file error"),
    FILE_EMPTY_ERROR("File is empty"),
    FILE_DATA_ERROR("File data is corrupted"),
    ;

    private final String msg;
    private final String prefix = "[ASTON-FILE-" + ordinal() + "] ";

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String get() {
        return prefix.concat(msg);
    }

    public String format(Object... args) {
        return String.format(get(), args);
    }
}
