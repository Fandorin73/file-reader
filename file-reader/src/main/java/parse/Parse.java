package parse;

/**
 * Маркер для всех парсеров из строки в объект.
 *
 * @author Andrey
 */
public interface Parse <T> {
    T parseToObj(StringBuilder stringBuilder);
}
