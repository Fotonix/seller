package seller.dao.reference;

import java.util.List;

import seller.dao.CrudDao;
import seller.domain.reference.Section;

/**
 * DAO для работы с {@link Section}.
 *
 * @author Aleksei_Zabezhinsky
 */
public interface SectionDao extends CrudDao<Integer, Section> {

    /**
     * Получает все сущности {@link Section}.
     *
     * @return коллекция сущностей {@link Section}
     */
    List<Section> findAll();

}
