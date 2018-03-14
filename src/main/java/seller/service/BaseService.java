package seller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * Базовый класс для всех сервисов.
 *
 * @author Aleksei_Zabezhinsky
 */
public abstract class BaseService {

    @Autowired
    private MessageSource messageSource;

    /**
     * Получает локализованное сообщение по ключу.
     *
     * @param key ключ
     * @param args параметры для заполнения сообщения
     * @return локализованное сообщение
     */
    public String getMessage(String key, Object... args) {
        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    }

}
