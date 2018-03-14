package seller.dao.reference;

import java.util.List;

import seller.dao.CrudDao;
import seller.domain.reference.Producer;

/**
 * DAO для работы с {@link Producer}.
 *
 * @author Aleksei_Zabezhinsky
 */
public interface ProducerDao extends CrudDao<Integer, Producer> {

    /**
     * Получает все сущности {@link Producer}.
     *
     * @return коллекция сущностей {@link Producer}
     */
    List<Producer> findAll();

}
