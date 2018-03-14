package seller.util;

/**
 * Утилитный класс для работы со строками.
 *
 * @author Aleksei_Zabezhinsky
 */
public final class StringUtil {

    /**
     * Приватный конструктор.
     */
    private StringUtil() {
    }

    /**
     * Нормализует html-строку, удаляет пробелы.
     *
     * @param str строка для нормализации
     * @return нормализованная строка
     */
    public static String normalize(String str) {
        if (str == null) {
            return null;
        }
        str = str.trim();
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }
}
