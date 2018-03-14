package seller.dao.jpa.reference;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import seller.dao.jpa.CrudJpaDao;
import seller.dao.reference.ProductGroupDao;
import seller.domain.reference.ProductGroup;

/**
 * Реализация {@link ProductGroupDao}.
 *
 * @author Aleksei_Zabezhinsky
 */
@Repository
public class ProductGroupJpaDao extends CrudJpaDao<Integer, ProductGroup> implements ProductGroupDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<ProductGroup> findAll() {
        Query query = getEntityManager().createQuery("SELECT e FROM ProductGroup e ORDER BY e.name");
        return query.getResultList();
    }
}
