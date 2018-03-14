package seller.domain.reference;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Секция.
 *
 * @author Aleksei_Zabezhinsky
 */
@Entity
@Table(name = "section", schema = "main")
public class Section extends BaseReference {

    /** Serial version. */
    private static final long serialVersionUID = 295596592495480623L;

    /**
     * Дефолтный конструктор.
     */
    public Section() {
        super();
    }

    /**
     * Конструктор.
     *
     * @param id ID
     * @param name наименование
     */
    public Section(Integer id, String name) {
        super(id, name);
    }

}
