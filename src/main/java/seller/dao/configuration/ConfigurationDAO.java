package seller.dao.configuration;

import java.util.List;

import seller.domain.configuration.Configuration;

/**
 * DAO для работы с {@link Configuration}.
 * @author Andrey_Ponomarenko
 */
public interface ConfigurationDAO {

    /**
     * Чтение объекта из хранилища.
     *
     * @param key
     *            ID объекта в хранилище
     * @return entity
     */
    Configuration read(String key);

    /**
     * Обновляет объект в хранилище.
     *
     * @param entity
     *            объект
     * @return
     */
    void update(Configuration entity);

    /**
     * Получает все сущности {@link Configuration}.
     * @return коллекция сущностей {@link Configuration}
     */
    List<Configuration> findAll();

}
