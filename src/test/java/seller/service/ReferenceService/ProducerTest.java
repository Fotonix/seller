package seller.service.ReferenceService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import seller.domain.reference.Producer;
import seller.exception.UniqueEntityException;
import seller.service.BaseServiceTest;
import seller.service.reference.ReferenceService;

/**
 * Тестирование функционала для сущности {@link Producer}.
 *
 * @author Aleksei_Zabezhinsky
 */
public class ProducerTest extends BaseServiceTest {

    @Autowired
    private ReferenceService referenceService;

    /** Тестирование добавления сущности {@link Producer}. */
    @Test
    public void testCreate() {
        assertNotNull("Save error Producer", create().getId());
    }

    /** Тестирование чтения сущности {@link Producer}. */
    @Test
    public void testRead() {
        Integer groupId = create().getId();
        Producer group = referenceService.getProducer(groupId);
        assertNotNull("Read error Producer", group);
    }

    /** Тестирование чтения всех сущностей {@link Producer}. */
    @Test
    public void testReadAll() {
        create();
        List<Producer> list = referenceService.getProducers();
        assertTrue("Read error all Producers", list.size() > 0);
    }

    /** Тестирование удаления сущности {@link Producer}. */
    @Test
    public void testDelete() {
        Integer groupId = create().getId();
        referenceService.deleteProducer(groupId);
        Producer group = referenceService.getProducer(groupId);
        assertNull("Delete error Producer", group);
    }

    /**
     * Тестирование добавления двух одинаковых сущностей {@link Producer}.
     *
     */
    @Test(expected = UniqueEntityException.class)
    public void testDublicateSave() {
        create();
        create();
    }

    /**
     * Добавление сущности {@link Producer}.
     *
     * @return сохраненная сущность {@link Producer}
     */
    private Producer create() {
        Producer producer = new Producer(null, "Test group");
        referenceService.saveProducer(producer);
        return producer;
    }

}
