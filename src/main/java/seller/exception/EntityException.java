package seller.exception;

import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * Базовый класс, описывающий ошибки, связвнные с сущностями.
 *
 * @author Aleksei_Zabezhinsky
 */
public class EntityException extends RuntimeException {

    /** Serial version. */
    private static final long serialVersionUID = -5379688866703073229L;

    /** Код ошибки. */
    private int errorStatus;

    {
        errorStatus = SC_INTERNAL_SERVER_ERROR;
    }

    /**
     * Дефолтный конструктор.
     */
    public EntityException() {
        super();
    }

    /**
     * Конструктор.
     *
     * @param message описание ошибки
     */
    public EntityException(String message) {
        super(message);
    }

    /**
     * Конструктор.
     *
     * @param exception исключение
     */
    public EntityException(Throwable exception) {
        super(exception);
    }

    /**
     * Конструктор.
     *
     * @param message описание ошибки
     * @param exception исключение
     */
    public EntityException(String message, Throwable exception) {
        super(message, exception);
    }

    /**
     * Конструктор.
     *
     * @param message описание ошибки
     * @param errorStatus код ошибки
     */
    public EntityException(String message, int errorStatus) {
        super(message);
        this.errorStatus = errorStatus;
    }

    /**
     * Конструктор.
     *
     * @param message описание ошибки
     * @param errorStatus код ошибки
     * @param exception исключение
     */
    public EntityException(String message, int errorStatus, Throwable exception) {
        super(message, exception);
        this.errorStatus = errorStatus;
    }

    /**
     * Получает код ошибки.
     *
     * @return код ошибки
     */
    public int getErrorStatus() {
        return errorStatus;
    }

    /**
     * Задает код ошибки.
     *
     * @param errorStatus код ошибки
     */
    public void setErrorStatus(int errorStatus) {
        this.errorStatus = errorStatus;
    }

    /**
     * Записывает текущую ошибку в <code>response</code>.
     *
     * @param response {@link HttpServletResponse}
     * @throws IOException exception
     */
    public void sendError(HttpServletResponse response) throws IOException {
        response.setStatus(errorStatus);
        response.getWriter().write(getMessage());
    }

}
