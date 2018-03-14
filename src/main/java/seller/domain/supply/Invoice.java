package seller.domain.supply;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import seller.domain.reference.Producer;

/**
 * Накладная.
 *
 * @author Aleksei_Zabezhinsky
 */
@NamedQueries({
    @NamedQuery(name = Invoice.ALL_INVOICE_QUERY,
                query = "SELECT e FROM Invoice e JOIN FETCH e.producer ORDER BY e.date, e.series"),
    @NamedQuery(name = Invoice.INVOICE_QUERY,
                query = "SELECT e FROM Invoice e JOIN FETCH e.items WHERE e.id = :id")
})
@Entity
@Table(name = "invoice", schema = "main")
public class Invoice implements Serializable {

    /** Serial version. */
    private static final long serialVersionUID = -7664777627623571773L;

    /** Запрос получения накладной. */
    public static final String INVOICE_QUERY = "Invoice.getInvoice";

    /** Запрос получения всех накладных. */
    public static final String ALL_INVOICE_QUERY = "Invoice.getAllInvoices";

    /** ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Серия накладной. */
    @Column(nullable = true, unique = true, length = 10)
    private String series;

    /** Дата накладной. */
    @Column(nullable = false)
    private Date date;

    /** ID поставщика. */
    @Column(name = "producer_id", nullable = false)
    private Integer producerId;

    /** Поставщик. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producer_id", insertable = false, updatable = false)
    private Producer producer;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private List<InvoiceItem> items;

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
     * Получает дату накладной.
     *
     * @return дата накладной
     */
    public Date getDate() {
        return date;
    }

    /**
     * Задает дату накладной.
     *
     * @param date дата накладной
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Получает серию накладной.
     *
     * @return серия накладной
     */
    public String getSeries() {
        return series;
    }

    /**
     * Задает серию накладной.
     *
     * @param series серия накладной
     */
    public void setSeries(String series) {
        this.series = series;
    }

    /**
     * Получает ID поставщика.
     *
     * @return ID поставщика
     */
    public Integer getProducerId() {
        return producerId;
    }

    /**
     * Задает ID поставщика.
     *
     * @param producerId ID поставщика
     */
    public void setProducerId(Integer producerId) {
        this.producerId = producerId;
    }

    /**
     * Получает {@link Producer}.
     *
     * @return поставщик
     */
    public Producer getProducer() {
        return producer;
    }

    /**
     * Задает {@link Producer}.
     *
     * @param producer поставщик
     */
    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    /**
     * Получает коллекцию {@link InvoiceItem}.
     *
     * @return коллекция {@link InvoiceItem}
     */
    public List<InvoiceItem> getItems() {
        return items;
    }

    /**
     * Задает коллекцию {@link InvoiceItem}.
     *
     * @param items коллекция {@link InvoiceItem}
     */
    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Invoice [id=" + id + ", series=" + series + ", date=" + date + ", producerId=" + producerId
                + "]";
    }

}
