package seller.domain.reference;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Поставщик.
 *
 * @author Aleksei_Zabezhinsky
 */
@Entity
@Table(name = "producer", schema = "main")
public class Producer extends BaseReference {

    /** Serial version. */
    private static final long serialVersionUID = -1126340567906572016L;


    /**
     * Дефолтный конструктор.
     */
    public Producer() {
        super();
    }

    /**
     * Конструктор.
     *
     * @param id ID
     * @param name наименование
     */
    public Producer(Integer id, String name) {
        super(id, name);
    }

}
