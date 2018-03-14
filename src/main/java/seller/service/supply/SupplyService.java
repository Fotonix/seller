package seller.service.supply;

import java.util.List;

import seller.domain.supply.Invoice;

/**
 * Сервис работы с приходом продукции.
 *
 * @author Aleksei_Zabezhinsky
 */
public interface SupplyService {

    /**
     * Получает сущность {@link Invoice} по <code>id</code>.
     *
     * @param id идентификатор сущности {@link Invoice}
     * @return сущность {@link Invoice}
     */
    Invoice getInvoice(Integer id);

    /**
     * Сохраняет сущность {@link Invoice}.
     *
     * @param entity сущность {@link Invoice}
     */
    void saveInvoice(Invoice entity);

    /**
     * Удаляет сущность {@link Invoice}.
     *
     * @param id идентификатор сущности {@link Invoice}
     */
    void deleteInvoice(Integer id);

    /**
     * Получает все сущности {@link Invoice}.
     *
     * @return коллекция сущностей {@link Invoice}
     */
    List<Invoice> getInvoices();

}
