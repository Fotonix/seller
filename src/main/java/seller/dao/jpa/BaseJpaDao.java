package seller.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * Класс, являющейся базовым для всех <code>JpaDao</code>.
 *
 * @author Aleksei_Zabezhinsky
 */
public abstract class BaseJpaDao {

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private EntityManager entityManager;

    @Autowired
    private MessageSource messageSource;

    /**
     * Задает {@link EntityManager}.
     *
     * @param entityManager {@link EntityManager}
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Получает {@link EntityManager}.
     *
     * @return {@link EntityManager}
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

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
