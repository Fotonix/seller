package seller.dao.jpa.supply;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import seller.dao.jpa.CrudJpaDao;
import seller.dao.supply.InvoiceDao;
import seller.domain.supply.Invoice;

/**
 * Реализация {@link InvoiceDao}.
 *
 * @author Aleksei_Zabezhinsky
 */
@Repository
public class InvoiceJpaDao extends CrudJpaDao<Integer, Invoice> implements InvoiceDao {

    @Override
    public Invoice read(Integer key) {
        Query query = getEntityManager().createNamedQuery(Invoice.INVOICE_QUERY).setParameter("id", key);
        return (Invoice) query.getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Invoice> findAll() {
        Query query = getEntityManager().createNamedQuery(Invoice.ALL_INVOICE_QUERY);
        return query.getResultList();
    }

}
