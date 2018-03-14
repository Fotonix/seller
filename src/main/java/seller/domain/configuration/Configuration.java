package seller.domain.configuration;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Конфигурационные настройки
 *
 * @author Andrey_Ponomarenko
 * @author Aleksei_Zabezhinsky
 */
@NamedQuery(name = Configuration.CONFIG_BY_TYPE_QUERY,
            query = "SELECT e FROM Configuration e WHERE e.type = :type ORDER BY e.description")
@Entity
@Table(name = "configuration", schema = "main")
public class Configuration implements Serializable {

    /** Serial version. */
    private static final long serialVersionUID = -8164891475312273658L;

    /** Запрос получения свойств по типу. */
    public static final String CONFIG_BY_TYPE_QUERY = "Configuration.getConfigByType";

    /** Ключ свойства. */
    @Id
    @Column(nullable = false, length = 64, unique = true, insertable = false, updatable = false)
    private String key;

    /** Тип свойства. */
    @Column(name = "type_id", nullable = false, insertable = false, updatable = false)
    @Enumerated(EnumType.ORDINAL)
    private ConfigurationType type;

    /** Значение свойства. */
    @Column(nullable = false, length = 64, insertable = false)
    private String value;

    /** Регулярное выражение. */
    @Column(nullable = false, length = 64, insertable = false, updatable = false)
    private String regexp;

    /** Описание. */
    @Column(nullable = false, length = 64, insertable = false, updatable = false)
    private String description;

    /**
     * Получает ключ свойства.
     *
     * @return ключ свойства
     */
    public String getKey() {
        return key;
    }

    /**
     * Задает ключ свойства.
     *
     * @param key
     *            ключ свойства
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Получает тип свойства.
     *
     * @return тип свойства
     */
    public ConfigurationType getType() {
        return type;
    }

    /**
     * Задает тип свойства.
     *
     * @param type
     *            тип свойства
     */
    public void setType(ConfigurationType type) {
        this.type = type;
    }

    /**
     * Получает значение свойства.
     *
     * @return значение свойства
     */
    public String getValue() {
        return value;
    }

    /**
     * Задает значение свойства.
     *
     * @param value
     *            значение свойства
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Получает регулярное выражение.
     *
     * @return регулярное выражение
     */
    public String getRegexp() {
        return regexp;
    }

    /**
     * Задает регулярное выражение.
     *
     * @param regexp
     *            регулярное выражение
     */
    public void setRegexp(String regexp) {
        this.regexp = regexp;
    }

    /**
     * Получает описание.
     *
     * @return описание
     */
    public String getDescription() {
        return description;
    }

    /**
     * Задает описание.
     *
     * @param description
     *            описание
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Дефолтный конструктор.
     */
    public Configuration() {
        super();
    }

    /**
     * Конструктор.
     *
     * @param key Ключ свойства
     * @param type Тип свойства
     * @param value Значение свойства
     * @param regexp Регулярное выражение
     * @param description Описание
     */
    public Configuration(String key, ConfigurationType type, String value, String regexp, String description)
    {
        super();
        this.key = key;
        this.type = type;
        this.value = value;
        this.regexp = regexp;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Configuration [key=" + key + ", type=" + type + ", value=" + value + ", regexp=" + regexp
                + "," + "description=" + description + "]";
    }
}
