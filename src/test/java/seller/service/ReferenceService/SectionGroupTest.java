package seller.service.ReferenceService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import seller.domain.reference.Section;
import seller.exception.UniqueEntityException;
import seller.service.BaseServiceTest;
import seller.service.reference.ReferenceService;

/**
 * Тестирование функционала для сущности {@link Section}.
 *
 * @author Aleksei_Zabezhinsky
 */
public class SectionGroupTest extends BaseServiceTest {

    @Autowired
    private ReferenceService referenceService;

    /** Тестирование добавления сущности {@link Section}. */
    @Test
    public void testCreate() {
        assertNotNull("Save error Section", create().getId());
    }

    /** Тестирование чтения сущности {@link Section}. */
    @Test
    public void testRead() {
        Integer groupId = create().getId();
        Section group = referenceService.getSection(groupId);
        assertNotNull("Read error Section", group);
    }

    /** Тестирование чтения всех сущностей {@link Section}. */
    @Test
    public void testReadAll() {
        create();
        List<Section> list = referenceService.getSections();
        assertTrue("Read error all Sections", list.size() > 0);
    }

    /** Тестирование удаления сущности {@link Section}. */
    @Test
    public void testDelete() {
        Integer groupId = create().getId();
        referenceService.deleteSection(groupId);
        Section group = referenceService.getSection(groupId);
        assertNull("Delete error Section", group);
    }

    /**
     * Тестирование добавления двух одинаковых сущностей {@link Section}.
     *
     */
    @Test(expected = UniqueEntityException.class)
    public void testDublicateSave() {
        create();
        create();
    }

    /**
     * Добавление сущности {@link Section}.
     *
     * @return сохраненная сущность {@link Section}
     */
    private Section create() {
        Section section = new Section(null, "Test group");
        referenceService.saveSection(section);
        return section;
    }

}
