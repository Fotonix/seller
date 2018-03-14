package seller.dao.jpa.reference;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import seller.dao.jpa.CrudJpaDao;
import seller.dao.reference.ProducerDao;
import seller.domain.reference.Producer;

/**
 * Реализация {@link ProducerDao}.
 *
 * @author Aleksei_Zabezhinsky
 */
@Repository
public class ProducerJpaDao extends CrudJpaDao<Integer, Producer> implements ProducerDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Producer> findAll() {
        Query query = getEntityManager().createQuery("SELECT e FROM Producer e ORDER BY e.name");
        return query.getResultList();
    }

}
