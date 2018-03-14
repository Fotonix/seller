package seller.exception;

import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;

/**
 * Класс, описывающий ошибку считывания сущности.
 *
 * @author Aleksei_Zabezhinsky
 */
public class NotFoundEntityException extends EntityException {

    /** Serial version. */
    private static final long serialVersionUID = -1822128873491333511L;

    {
        setErrorStatus(SC_NOT_FOUND);
    }

    /**
     * Дефолтный конструктор.
     */
    public NotFoundEntityException() {
        super();
    }

    /**
     * Конструктор.
     *
     * @param message описание ошибки
     */
    public NotFoundEntityException(String message) {
        super(message);
    }

    /**
     * Конструктор.
     *
     * @param exception исключение
     */
    public NotFoundEntityException(Throwable exception) {
        super(exception);
    }

    /**
     * Конструктор.
     *
     * @param message описание ошибки
     * @param exception исключение
     */
    public NotFoundEntityException(String message, Throwable exception) {
        super(message, exception);
    }

    /**
     * Конструктор.
     *
     * @param message описание ошибки
     * @param errorStatus код ошибки
     * @param exception исключение
     */
    public NotFoundEntityException(String message, int errorStatus, Throwable exception) {
        super(message, exception);
        setErrorStatus(errorStatus);
    }
}
