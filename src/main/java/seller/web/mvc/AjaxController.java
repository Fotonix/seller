package seller.web.mvc;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import seller.exception.EntityException;

/**
 * Базовый класс для контроллеров, осуществляющих операции через Ajax.
 *
 * @author Aleksei_Zabezhinsky
 */
public abstract class AjaxController {

    /**
     * Перехватывает {@link EntityException} и кидает ее в <code>response</code>.
     *
     * @param e {@link EntityException}
     * @param resp {@link HttpServletResponse}
     * @throws IOException ошибка ввода/вывода
     */
    @ExceptionHandler(EntityException.class)
    @ResponseBody
    public void handleException(EntityException e, HttpServletResponse resp) throws IOException {
        e.sendError(resp);
    }

}
