package seller.web.mvc.reference;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import seller.domain.reference.Producer;
import seller.service.reference.ReferenceService;
import seller.web.mvc.AjaxController;

/**
 * Producer controller.
 *
 * @author Aleksei_Zabezhinsky
 */
@Controller
@RequestMapping("/reference/producer.html")
public class ProducerController extends AjaxController {

    @Autowired
    private ReferenceService referenceService;

    /**
     * Отображает страницу списка поставщиков.
     *
     * @return страница списка поставщиков
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(".reference.producer");
        List<Producer> list = referenceService.getProducers();
        modelAndView.addObject("producers", list);
        return modelAndView;
    }

    /**
     * Сохраняет поставщика.
     *
     * @param entity поставщик, которого необходимо сохранить
     * @return ID сохраненного поставщика
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Integer save(@RequestBody Producer entity) {
        referenceService.saveProducer(entity);
        return entity.getId();
    }

    /**
     * Удаляет поставщика.
     *
     * @param id ID поставщика, которого необходимо удалить
     */
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@RequestBody Integer id) {
        referenceService.deleteProducer(id);
    }

}
