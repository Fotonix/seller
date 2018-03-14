package seller.web.mvc.config;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import seller.domain.configuration.Configuration;
import seller.exception.InvalidFormatEntityException;
import seller.service.BaseService;

/**
 * Валидатор настроек
 *
 * @author Andrey_Ponomarenko
 */
@Component
public class ConfigurationValidator extends BaseService implements Validator {

    @SuppressWarnings("rawtypes")
    @Override
    public boolean supports(Class c) {
        return Configuration.class.isAssignableFrom(c);
    }

    @Override
    public void validate(Object command, Errors errors) {
        Configuration configuration = (Configuration) command;
        String value = configuration.getValue();
        if (value == null || !value.matches(configuration.getRegexp())) {
            throw new InvalidFormatEntityException(getMessage("error.entity.illegal.regexp"));
        }
    }
}
