package seller.service.ReferenceService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import seller.domain.reference.ProductGroup;
import seller.exception.UniqueEntityException;
import seller.service.BaseServiceTest;
import seller.service.reference.ReferenceService;

/**
 * Тестирование функционала для сущности {@link ProductGroup}.
 *
 * @author Aleksei_Zabezhinsky
 */
public class ProductGroupTest extends BaseServiceTest {

    @Autowired
    private ReferenceService referenceService;

    /** Тестирование добавления сущности {@link ProductGroup}. */
    @Test
    public void testCreate() {
        assertNotNull("Save error ProductGroup", create().getId());
    }

    /** Тестирование чтения сущности {@link ProductGroup}. */
    @Test
    public void testRead() {
        Integer groupId = create().getId();
        ProductGroup group = referenceService.getProductGroup(groupId);
        assertNotNull("Read error ProductGroup", group);
    }

    /** Тестирование чтения всех сущностей {@link ProductGroup}. */
    @Test
    public void testReadAll() {
        create();
        List<ProductGroup> list = referenceService.getProductGroups();
        assertTrue("Read error all ProductGroups", list.size() > 0);
    }

    /** Тестирование удаления сущности {@link ProductGroup}. */
    @Test
    public void testDelete() {
        Integer groupId = create().getId();
        referenceService.deleteProductGroup(groupId);
        ProductGroup group = referenceService.getProductGroup(groupId);
        assertNull("Delete error ProductGroup", group);
    }

    /**
     * Тестирование добавления двух одинаковых сущностей {@link ProductGroup}.
     *
     */
    @Test(expected = UniqueEntityException.class)
    public void testDublicateSave() {
        create();
        create();
    }

    /**
     * Добавление сущности {@link ProductGroup}.
     *
     * @return сохраненная сущность {@link ProductGroup}
     */
    private ProductGroup create() {
        ProductGroup group = new ProductGroup(null, "Test group");
        referenceService.saveProductGroup(group);
        return group;
    }

}
