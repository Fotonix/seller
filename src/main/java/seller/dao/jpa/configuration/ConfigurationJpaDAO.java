package seller.dao.jpa.configuration;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import seller.dao.configuration.ConfigurationDAO;
import seller.dao.jpa.BaseJpaDao;
import seller.domain.configuration.Configuration;
import seller.domain.configuration.ConfigurationType;
import seller.exception.EntityException;
import seller.exception.NotFoundEntityException;
import seller.exception.UniqueEntityException;

/**
 * Базовый класс для <code>DAO</code>, реализующих {@link Configuration}.
 *
 * @author Andrey_Ponomarenko
 */
@Repository
public class ConfigurationJpaDAO extends BaseJpaDao implements ConfigurationDAO {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private enum Operation {
        SAVE, READ
    };

    @Override
    public Configuration read(String key) {
        logger.debug("Start reading entity by key \"{}\"...", key);
        Configuration entity = null;
        try {
            entity = getEntityManager().find(Configuration.class, key);
        } catch (RuntimeException e) {
            logger.error("Error reading entity by key: {}", key, e);
            parseException(Operation.READ, e);
        }
        logger.debug("Entity: \"{}\" read", entity);
        return entity;
    }

    @Override
    public void update(Configuration entity) {
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
    @SuppressWarnings("unchecked")
    public List<Configuration> findAll() {
        Query query = getEntityManager().createNamedQuery(Configuration.CONFIG_BY_TYPE_QUERY)
                .setParameter("type", ConfigurationType.USER);
        return (List<Configuration>) query.getResultList();
    }

    /**
     * Генерирует и выбрасывает исключение (наследника {@link EntityException}),
     * в зависимости от типа операции.
     *
     * @param operation тип операции
     * @param e выброшенное исключение
     */
    private void parseException(Operation operation, RuntimeException e) {
        // Если ошибка, связанная с констрэитном, то выбрасываем свое исключение.
        if (e.getCause() instanceof ConstraintViolationException) {
            switch (operation) {
            case SAVE:
                throw new UniqueEntityException(getMessage("error.entity.unique"), e);
            case READ:
                throw new NotFoundEntityException(getMessage("error.entity.not.found"), e);
            default:
                break;
            }
        }
        // Иначе пробрасываем перехваченное исключение
        throw new EntityException(getMessage("error.entity.unknown"), e);
    }

}
