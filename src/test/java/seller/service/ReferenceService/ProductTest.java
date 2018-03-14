package seller.service.ReferenceService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import seller.domain.reference.Product;
import seller.domain.reference.ProductGroup;
import seller.exception.UniqueEntityException;
import seller.service.BaseServiceTest;
import seller.service.reference.ReferenceService;

/**
 * Тестирование функционала для сущности {@link Product}.
 *
 * @author Aleksei_Zabezhinsky
 */
public class ProductTest extends BaseServiceTest {

    @Autowired
    private ReferenceService referenceService;

    /** Тестирование добавления сущности {@link Product}. */
    @Test
    public void testCreate() {
        assertNotNull("Save error Product", create(true).getId());
    }

    /** Тестирование чтения сущности {@link Product}. */
    @Test
    public void testRead() {
        Integer groupId = create(true).getId();
        Product group = referenceService.getProduct(groupId);
        assertNotNull("Read error Product", group);
    }

    /** Тестирование чтения всех сущностей {@link Product}. */
    @Test
    public void testReadAll() {
        create(true);
        List<Product> list = referenceService.getProducts();
        assertTrue("Read error all Products", list.size() > 0);
    }

    /** Тестирование удаления сущности {@link Product}. */
    @Test
    public void testDelete() {
        Integer groupId = create(true).getId();
        referenceService.deleteProduct(groupId);
        Product group = referenceService.getProduct(groupId);
        assertNull("Delete error Product", group);
    }

    /**
     * Тестирование добавления двух одинаковых сущностей {@link Product}.
     *
     */
    @Test(expected = UniqueEntityException.class)
    public void testDublicateSave() {
        create(true);
        create(false);
    }

    /**
     * Добавление сущности {@link Product}.
     *
     * @param firstSave признак, первый ли раз сохраняется сущность
     * @return сохраненная сущность {@link Product}
     */
    private Product create(boolean firstSave) {
        String postfix = firstSave ? "1" : "2";
        ProductGroup group = new ProductGroup(null, "Test group" + postfix);
        referenceService.saveProductGroup(group);
        Product product = new Product(null, "Test product", group.getId());
        referenceService.saveProduct(product);
        return product;
    }

}
