package seller.service.reference;

import java.util.List;

import seller.domain.reference.Producer;
import seller.domain.reference.Product;
import seller.domain.reference.ProductGroup;
import seller.domain.reference.Section;

/**
 * Сервис работы со справочниками.
 *
 * @author Aleksei_Zabezhinsky
 */
public interface ReferenceService {

    /**
     * Получает сущность {@link ProductGroup} по <code>id</code>.
     *
     * @param id идентификатор сущности {@link ProductGroup}
     * @return сущность {@link ProductGroup}
     */
    ProductGroup getProductGroup(Integer id);

    /**
     * Сохраняет сущность {@link ProductGroup}.
     *
     * @param entity сущность {@link ProductGroup}
     */
    void saveProductGroup(ProductGroup entity);

    /**
     * Удаляет сущность {@link ProductGroup}.
     *
     * @param id идентификатор сущности {@link ProductGroup}
     */
    void deleteProductGroup(Integer id);

    /**
     * Получает все сущности {@link ProductGroup}.
     *
     * @return коллекция сущностей {@link ProductGroup}
     */
    List<ProductGroup> getProductGroups();

    /**
     * Получает сущность {@link Product} по <code>id</code>.
     *
     * @param id идентификатор сущности {@link Product}
     * @return сущность {@link Product}
     */
    Product getProduct(Integer id);

    /**
     * Сохраняет сущность {@link Product}.
     *
     * @param entity сущность {@link Product}
     */
    void saveProduct(Product entity);

    /**
     * Удаляет сущность {@link Product}.
     *
     * @param id идентификатор сущности {@link Product}
     */
    void deleteProduct(Integer id);

    /**
     * Получает все сущности {@link Product}.
     *
     * @return коллекция сущностей {@link Product}
     */
    List<Product> getProducts();

    /**
     * Получает сущность {@link Section} по <code>id</code>.
     *
     * @param id идентификатор сущности {@link Section}
     * @return сущность {@link Section}
     */
    Section getSection(Integer id);

    /**
     * Сохраняет сущность {@link Section}.
     *
     * @param entity сущность {@link Section}
     */
    void saveSection(Section entity);

    /**
     * Удаляет сущность {@link Section}.
     *
     * @param id идентификатор сущности {@link Section}
     */
    void deleteSection(Integer id);

    /**
     * Получает все сущности {@link Section}.
     *
     * @return коллекция сущностей {@link Section}
     */
    List<Section> getSections();

    /**
     * Получает сущность {@link Producer} по <code>id</code>.
     *
     * @param id идентификатор сущности {@link Producer}
     * @return сущность {@link Producer}
     */
    Producer getProducer(Integer id);

    /**
     * Сохраняет сущность {@link Producer}.
     *
     * @param entity сущность {@link Producer}
     */
    void saveProducer(Producer entity);

    /**
     * Удаляет сущность {@link Producer}.
     *
     * @param id идентификатор сущности {@link Producer}
     */
    void deleteProducer(Integer id);

    /**
     * Получает все сущности {@link Producer}.
     *
     * @return коллекция сущностей {@link Producer}
     */
    List<Producer> getProducers();

}
