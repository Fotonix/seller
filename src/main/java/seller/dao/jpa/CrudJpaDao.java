package seller.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import seller.dao.CrudDao;
import seller.exception.DeleteEntityException;
import seller.exception.EntityException;
import seller.exception.NotFoundEntityException;
import seller.exception.UniqueEntityException;

/**
 * Базовый класс для <code>DAO</code>, реализующих шаблон <code>CRUD</code>
 *
 * @author Aleksei_Zabezhinsky
 */
public abstract class CrudJpaDao<K extends Number, E extends Serializable> extends BaseJpaDao implements
        CrudDao<K, E> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private Class<E> entityClass;

    private enum Operation {
        SAVE, READ, DELETE
    };

    /**
     * Считывание аннотации, определяющей класс сущности.
     */
    @PostConstruct
    @SuppressWarnings({ "unchecked", "unused" })
    private void initEntityClass() {
        entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[1];
    }

    @Override
    public void create(E entity) {
        logger.debug("Start creating entity: \"{}\"...", entity);
        try {
            getEntityManager().persist(entity);
        } catch (RuntimeException e) {
            logger.error("Error creating entity : {}", entity, e);
            parseException(Operation.SAVE, e);
        }
        logger.debug("Entity: \"{}\" created", entity);
    }

    @Override
    public E read(K key) {
        logger.debug("Start reading entity by key \"{}\"...", key);
        E entity = null;
        try {
            entity = getEntityManager().find(entityClass, key);
        } catch (RuntimeException e) {
            logger.error("Error reading entity by key: {}", key, e);
            parseException(Operation.READ, e);
        }
        logger.debug("Entity: \"{}\" read", entity);
        return entity;
    }

    @Override
    public void update(E entity) {
        logger.debug("Start updating entity: \"{}\"...", entity);
        try {
            getEntityManager().merge(entity);
            getEntityManager().flush();
        } catch (RuntimeException e) {
            logger.error("Error updating entity : {}", entity, e);
            parseException(Operation.SAVE, e);
        }
        logger.debug("Entity: \"{}\" updated", entity);
    }

    @Override
    public void delete(K key) {
        logger.debug("Start deleting entity by key \"{}\"...", key);
        E entity = read(key);
        try {
            getEntityManager().remove(entity);
            getEntityManager().flush();
        } catch (RuntimeException e) {
            logger.error("Error deleting entity : {}", entity, e);
            parseException(Operation.DELETE, e);
        }
        logger.debug("Entity: \"{}\" deleted", entity);
    }

    /**
     * Генерирует и выбрасывает исключение (наследника {@link EntityException}),
     * в зависимости от типа операции.
     *
     * @param operation тип операции
     * @param e выброшенное исключение
     */
    private void parseException(Operation operation, RuntimeException e) {
        // Если ошибка, связанная с констрэитном, то выбрасываем свое исключение
        if (e.getCause() instanceof ConstraintViolationException) {
            switch (operation) {
                case SAVE:
                    throw new UniqueEntityException(getMessage("error.entity.unique"), e);
                case READ:
                    throw new NotFoundEntityException(getMessage("error.entity.not.found"), e);
                case DELETE:
                    throw new DeleteEntityException(getMessage("error.entity.is.used"), e);
                default:
            }
        } else {
            // Иначе пробрасываем перехваченное исключение
            throw new EntityException(getMessage("error.entity.unknown"), e);
        }
    }

}
