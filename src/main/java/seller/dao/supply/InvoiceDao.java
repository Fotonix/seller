package seller.dao.supply;

import java.util.List;

import seller.dao.CrudDao;
import seller.domain.supply.Invoice;

/**
 * DAO для работы с {@link Invoice}.
 *
 * @author Aleksei_Zabezhinsky
 */
public interface InvoiceDao extends CrudDao<Integer, Invoice> {

    /**
     * Получает все сущности {@link Invoice}.
     *
     * @return коллекция сущностей {@link Invoice}
     */
    List<Invoice> findAll();

}
