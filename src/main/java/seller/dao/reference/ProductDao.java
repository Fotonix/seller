package seller.dao.reference;

import java.util.List;

import seller.dao.CrudDao;
import seller.domain.reference.Product;

/**
 * DAO для работы с {@link Product}.
 *
 * @author Aleksei_Zabezhinsky
 */
public interface ProductDao extends CrudDao<Integer, Product> {

    /**
     * Получает все сущности {@link Product}.
     *
     * @return коллекция сущностей {@link Product}
     */
    List<Product> findAll();

}
