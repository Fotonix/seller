package seller.exception;

import static javax.servlet.http.HttpServletResponse.SC_CONFLICT;

/**
 * Класс, описывающий ошибку удаления сущности.
 *
 * @author Aleksei_Zabezhinsky
 */
public class DeleteEntityException extends EntityException {

    /** Serial version. */
    private static final long serialVersionUID = -3219265873493907312L;

    {
        setErrorStatus(SC_CONFLICT);
    }

    /**
     * Дефолтный конструктор.
     */
    public DeleteEntityException() {
        super();
    }

    /**
     * Конструктор.
     *
     * @param message описание ошибки
     */
    public DeleteEntityException(String message) {
        super(message);
    }

    /**
     * Конструктор.
     *
     * @param exception исключение
     */
    public DeleteEntityException(Throwable exception) {
        super(exception);
    }

    /**
     * Конструктор.
     *
     * @param message описание ошибки
     * @param exception исключение
     */
    public DeleteEntityException(String message, Throwable exception) {
        super(message, exception);
    }

    /**
     * Конструктор.
     *
     * @param message описание ошибки
     * @param errorStatus код ошибки
     * @param exception исключение
     */
    public DeleteEntityException(String message, int errorStatus, Throwable exception) {
        super(message, exception);
        setErrorStatus(errorStatus);
    }

}
