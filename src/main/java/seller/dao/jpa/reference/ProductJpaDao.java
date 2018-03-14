package seller.dao.jpa.reference;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import seller.dao.jpa.CrudJpaDao;
import seller.dao.reference.ProductDao;
import seller.domain.reference.Product;

/**
 * Реализация {@link ProductDao}.
 *
 * @author Aleksei_Zabezhinsky
 */
@Repository
public class ProductJpaDao extends CrudJpaDao<Integer, Product> implements ProductDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> findAll() {
        Query query = getEntityManager().createQuery("SELECT e FROM Product e ORDER BY e.name");
        return query.getResultList();
    }
}
