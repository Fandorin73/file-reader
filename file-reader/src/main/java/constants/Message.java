package constants;

public enum Message {
    // TODO: 02.07.2024  Ошибки отредактировать

    FILE_NOT_FOUND("File not found"),
    READING_FILE_ERROR("Reading file error"),
    READING_OBJECT_ERROR("Reading object from file error"),

    FILE_EMPTY_ERROR("File is empty"),
    TOKEN_NOT_FOUND_BY_KEYCLOAK_ID("Token not found by keycloak %s"),
    SBBOL_API_REQUEST_ERROR("General request API exception: %s"),
    CONSTRAINT_VIOLATION_ERROR("Constraint violation error: %s")
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
