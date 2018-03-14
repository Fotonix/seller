package seller.service.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seller.dao.configuration.ConfigurationDAO;
import seller.domain.configuration.Configuration;
import seller.service.BaseService;
import seller.util.StringUtil;

/**
 * Реализация интерфейса {@link ConfigurationService}
 *
 * @author Andrey_Ponomarenko
 */
@Service
public class ConfigurationServiceImpl extends BaseService implements ConfigurationService {

    @Autowired
    private ConfigurationDAO configurationDAO;

    @Override
    public Configuration getConfiguration(String key) {
        return configurationDAO.read(key);
    }

    @Override
    public void saveConfiguration(Configuration entity) {
        entity.setValue(StringUtil.normalize(entity.getValue()));
        configurationDAO.update(entity);
    }

    @Override
    public List<Configuration> getConfiguration() {
        return configurationDAO.findAll();
    }

}
