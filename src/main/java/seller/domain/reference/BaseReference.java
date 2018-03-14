package seller.domain.reference;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Базовая сущность для справочников.
 *
 * @author Aleksei_Zabezhinsky
 */
@MappedSuperclass
public abstract class BaseReference implements Serializable {

    /** Serial version. */
    private static final long serialVersionUID = -3822556190482547459L;

    /** ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Наименование. */
    @Column(nullable = false, length = 64, unique = true)
    private String name;

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
     * Получает наименование.
     *
     * @return наименование
     */
    public String getName() {
        return name;
    }

    /**
     * Задает наименование.
     *
     * @param name наименование
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Дефолтный конструктор.
     */
    public BaseReference() {
        super();
    }

    /**
     * Конструктор.
     *
     * @param id ID
     * @param name наименование
     */
    public BaseReference(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
