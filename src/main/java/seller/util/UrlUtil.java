package seller.util;

/**
 * Утилитный класс для работы с url'ами.
 *
 * @author Aleksei_Zabezhinsky
 */
public final class UrlUtil {

    private static final String FIRST_DELIMITER = "?";

    private static final String DELIMITER = "&";

    /**
     * Приватный конструктор.
     */
    private UrlUtil() {
    }

    /**
     * Добавляет к адресу первый параметр.
     *
     * @param baseUrl базовый адрес
     * @param paramName имя параметра
     * @param paramValue значение параметра
     * @return адрес с параметрами
     */
    public static String addFirstParameter(String baseUrl, String paramName, Object paramValue) {
        return addParameter(baseUrl, paramName, paramValue, FIRST_DELIMITER);
    }

    /**
     * Добавляет к адресу дополнительный параметр
     * (для добавления первого параметра используется метод
     * {@link #addFirstParameter(String, String, Object)}).
     *
     * @param baseUrl базовый адрес
     * @param paramName имя параметра
     * @param paramValue значение параметра
     * @return адрес с параметрами
     */
    public static String addParameter(String baseUrl, String paramName, Object paramValue) {
        return addParameter(baseUrl, paramName, paramValue, DELIMITER);
    }

    /**
     * Добавляет к адресу параметр.
     *
     * @param baseUrl адрес
     * @param paramName имя параметра
     * @param paramValue значение параметра
     * @param delim разделитель адреса и параметра
     * @return адрес с параметрами
     */
    private static String addParameter(String baseUrl, String paramName, Object paramValue, String delim) {
        StringBuilder result = new StringBuilder(baseUrl);
        result.append(delim).append(paramName).append('=').append(paramValue);
        return result.toString();
    }

}
