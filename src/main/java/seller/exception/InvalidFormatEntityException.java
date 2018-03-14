package seller.exception;

import static javax.servlet.http.HttpServletResponse.SC_CONFLICT;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * Класс, описывающий ошибку формата сущности.
 *
 * @author Andrey_Ponomarenko
 */
public class InvalidFormatEntityException extends EntityException {

    /** Serial version. */
    private static final long serialVersionUID = 2453849016372166096L;

    /** Код ошибки. */
    private int errorStatus;

    {
        errorStatus = SC_CONFLICT;
    }

    /**
     * Дефолтный конструктор.
     */
    public InvalidFormatEntityException() {
        super();
    }

    /**
     * Конструктор.
     *
     * @param message описание ошибки
     */
    public InvalidFormatEntityException(String message) {
        super(message);
    }

    /**
     * Конструктор.
     *
     * @param exception исключение
     */
    public InvalidFormatEntityException(Throwable exception) {
        super(exception);
    }

    /**
     * Конструктор.
     *
     * @param message описание ошибки
     * @param exception исключение
     */
    public InvalidFormatEntityException(String message, Throwable exception) {
        super(message, exception);
    }

    /**
     * Конструктор.
     *
     * @param message описание ошибки
     * @param errorStatus код ошибки
     */
    public InvalidFormatEntityException(String message, int errorStatus) {
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
    public InvalidFormatEntityException(String message, int errorStatus, Throwable exception) {
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
