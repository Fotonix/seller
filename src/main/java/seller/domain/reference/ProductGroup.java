package seller.domain.reference;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Группа товаров.
 *
 * @author Aleksei_Zabezhinsky
 */
@Entity
@Table(name = "product_group", schema = "main")
public class ProductGroup extends BaseReference {

    /** Serial version. */
    private static final long serialVersionUID = -3652162601605637822L;

    /**
     * Дефолтный конструктор.
     */
    public ProductGroup() {
        super();
    }

    /**
     * Конструктор.
     *
     * @param id ID
     * @param name наименование
     */
    public ProductGroup(Integer id, String name) {
        super(id, name);
    }

}
