package seller.web.mvc.config;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import seller.domain.configuration.Configuration;
import seller.service.configuration.ConfigurationService;
import seller.web.mvc.AjaxController;

/**
 * Configuration controller.
 *
 * @author Aleksei_Zabezhinsky
 * @author Andrey_Ponomarenko
 */
@Controller
@RequestMapping("/config.html")
public class ConfigController extends AjaxController {

    @Autowired
    private ConfigurationService configurationService;

    @Autowired
    private ConfigurationValidator validator;

    /**
     * Инициализация валидатора.
     *
     * @param binder {@link WebDataBinder}
     */
    @SuppressWarnings("unused")
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    /**
     * Инициализирует страницу конфигурации.
     *
     * @return view страницы конфигурации
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(".config");
        List<Configuration> list = configurationService.getConfiguration();
        modelAndView.addObject("configurations", list);
        return modelAndView;
    }

    /**
     * Сохраняет значение настройки.
     *
     * @param entity настройка, которую нужно сохранить
     * @return Key сохраненной настройки
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public boolean save(@Valid @RequestBody Configuration entity) {
            configurationService.saveConfiguration(entity);
            return true;
    }
}
