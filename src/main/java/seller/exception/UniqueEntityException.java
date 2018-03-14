package seller.exception;

import static javax.servlet.http.HttpServletResponse.SC_CONFLICT;

/**
 * Класс, описывающий ошибку нарушения уникальности.
 *
 * @author Aleksei_Zabezhinsky
 */
public class UniqueEntityException extends EntityException {

    /** Serial version. */
    private static final long serialVersionUID = -5815935985470486672L;

    {
        setErrorStatus(SC_CONFLICT);
    }

    /**
     * Дефолтный конструктор.
     */
    public UniqueEntityException() {
        super();
    }

    /**
     * Конструктор.
     *
     * @param message описание ошибки
     */
    public UniqueEntityException(String message) {
        super(message);
    }

    /**
     * Конструктор.
     *
     * @param exception исключение
     */
    public UniqueEntityException(Throwable exception) {
        super(exception);
    }

    /**
     * Конструктор.
     *
     * @param message описание ошибки
     * @param exception исключение
     */
    public UniqueEntityException(String message, Throwable exception) {
        super(message, exception);
    }

    /**
     * Конструктор.
     *
     * @param message описание ошибки
     * @param errorStatus код ошибки
     * @param exception исключение
     */
    public UniqueEntityException(String message, int errorStatus, Throwable exception) {
        super(message, exception);
        setErrorStatus(errorStatus);
    }
}
