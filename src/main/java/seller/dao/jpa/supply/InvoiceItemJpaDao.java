package seller.dao.jpa.supply;

import org.springframework.stereotype.Repository;

import seller.dao.jpa.CrudJpaDao;
import seller.dao.supply.InvoiceItemDao;
import seller.domain.supply.InvoiceItem;

/**
 * Реализация {@link InvoiceItemDao}.
 *
 * @author Aleksei_Zabezhinsky
 */
@Repository
public class InvoiceItemJpaDao extends CrudJpaDao<Integer, InvoiceItem> implements InvoiceItemDao {

}
