package seller.domain.supply;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Позиция накладной.
 *
 * @author Aleksei_Zabezhinsky
 */
@Entity
@Table(name = "invoice_item", schema = "main")
public class InvoiceItem implements Serializable {

    /** Serial version. */
    private static final long serialVersionUID = 6464636002695962711L;

    /** ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** ID накладной. */
    @Column(name = "invoice_id", nullable = false)
    private Integer invoiceId;

    /** ID товара. */
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    /** Количество. */
    @Column(nullable = false)
    private Integer quantity;

    /** Стоимость единицы. */
    @Column(nullable = false)
    private BigDecimal cost;

    /**
     * Получает ID.
     *
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Задает ID.
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Получает ID накладной.
     *
     * @return ID накладной
     */
    public Integer getInvoiceId() {
        return invoiceId;
    }

    /**
     * Задает ID накладной.
     *
     * @param invoiceId ID накладной
     */
    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * Получает ID товара.
     *
     * @return ID товара
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * Задает ID товара.
     *
     * @param productId ID товара
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * Получает количество.
     *
     * @return количество
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Задает количество.
     *
     * @param quantity количество
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Получает стоимость единицы.
     *
     * @return стоимость единицы
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * Задает стоимость единицы.
     *
     * @param cost стоимость единицы
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "InvoiceItem [id=" + id + ", invoiceId=" + invoiceId + ", productId=" + productId
                + ", quantity=" + quantity + ", cost=" + cost + "]";
    }

}
