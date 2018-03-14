package seller.service.supply;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seller.dao.supply.InvoiceDao;
import seller.domain.supply.Invoice;
import seller.service.BaseService;

/**
 * Реализация интерфейса {@link SupplyService}
 *
 * @author Aleksei_Zabezhinsky
 */
@Service
public class SupplyServiceImpl extends BaseService implements SupplyService {

    @SuppressWarnings("unused")
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private InvoiceDao invoiceDao;

    @Override
    public Invoice getInvoice(Integer id) {
        return invoiceDao.read(id);
    }

    @Override
    public void saveInvoice(Invoice entity) {
        if (entity.getId() == null) {
            invoiceDao.create(entity);
        } else {
            invoiceDao.update(entity);
        }
    }

    @Override
    public void deleteInvoice(Integer id) {
        invoiceDao.delete(id);
    }

    @Override
    public List<Invoice> getInvoices() {
        return invoiceDao.findAll();
    }

}
