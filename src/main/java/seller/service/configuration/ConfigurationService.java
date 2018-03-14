package seller.service.configuration;

import java.util.List;

import seller.domain.configuration.Configuration;

/**
 * Сервис работы c настройками.
 *
 * @author Andrey_Ponomarenko
 */
public interface ConfigurationService {

    /**
     * Получает сущность {@link Configuration} по <code>key</code>.
     *
     * @param key идентификатор сущности {@link Configuration}
     * @return сущность {@link Configuration}
     */
    Configuration getConfiguration(String key);

    /**
     * Сохраняет сущность {@link Configuration}.
     *
     * @param entity сущность {@link Configuration}
     */
    void saveConfiguration(Configuration entity);

    /**
     * Получает все сущности {@link Configuration}.
     *
     * @return коллекция сущностей {@link Configuration}
     */
    List<Configuration> getConfiguration();

}
