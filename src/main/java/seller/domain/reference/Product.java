package seller.domain.reference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Товар.
 *
 * @author Aleksei_Zabezhinsky
 */
@Entity
@Table(name = "product", schema = "main")
public class Product extends BaseReference {

    /** Serial version. */
    private static final long serialVersionUID = -600562884013625569L;

    /** ID группы товаров. */
    @Column(name = "product_group_id", nullable = false)
    private Integer productGroupId;

    /**
     * Получает ID группы товаров.
     *
     * @return ID группы товаров
     */
    public Integer getProductGroupId() {
        return productGroupId;
    }

    /**
     * Задает ID группы товаров.
     *
     * @param productGroupId ID группы товаров
     */
    public void setProductGroupId(Integer productGroupId) {
        this.productGroupId = productGroupId;
    }

    /**
     * Дефолтный конструктор.
     */
    public Product() {
        super();
    }

    /**
     * Конструктор.
     *
     * @param id ID
     * @param name наименование
     * @param productGroupId группа товаров
     */
    public Product(Integer id, String name, Integer productGroupId) {
        super(id, name);
        this.productGroupId = productGroupId;
    }

}
