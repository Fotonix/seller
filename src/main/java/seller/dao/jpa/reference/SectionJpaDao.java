package seller.dao.jpa.reference;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import seller.dao.jpa.CrudJpaDao;
import seller.dao.reference.SectionDao;
import seller.domain.reference.Section;

/**
 * Реализация {@link SectionDao}.
 *
 * @author Aleksei_Zabezhinsky
 */
@Repository
public class SectionJpaDao extends CrudJpaDao<Integer, Section> implements SectionDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Section> findAll() {
        Query query = getEntityManager().createQuery("SELECT e FROM Section e ORDER BY e.name");
        return query.getResultList();
    }

}
