package seller.dao.reference;

import java.util.List;

import seller.dao.CrudDao;
import seller.domain.reference.ProductGroup;

/**
 * DAO для работы с {@link ProductGroup}.
 *
 * @author Aleksei_Zabezhinsky
 */
public interface ProductGroupDao extends CrudDao<Integer, ProductGroup> {

    /**
     * Получает все сущности {@link ProductGroup}.
     *
     * @return коллекция сущностей {@link ProductGroup}
     */
    List<ProductGroup> findAll();

}
