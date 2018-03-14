package seller.web.mvc.reference;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import seller.domain.reference.Section;
import seller.service.reference.ReferenceService;
import seller.web.mvc.AjaxController;

/**
 * Section controller.
 *
 * @author Aleksei_Zabezhinsky
 */
@Controller
@RequestMapping("/reference/section.html")
public class SectionController extends AjaxController {

    @Autowired
    private ReferenceService referenceService;

    /**
     * Отображает страницу списка отделов.
     *
     * @return страница списка отделов
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(".reference.section");
        List<Section> list = referenceService.getSections();
        modelAndView.addObject("sections", list);
        return modelAndView;
    }

    /**
     * Сохраняет отдел.
     *
     * @param entity отдел, который необходимо сохранить
     * @return ID сохраненного отдела
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Integer save(@RequestBody Section entity) {
        referenceService.saveSection(entity);
        return entity.getId();
    }

    /**
     * Удаляет отдел.
     *
     * @param id ID отдела, который необходимо удалить
     */
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@RequestBody Integer id) {
        referenceService.deleteSection(id);
    }

}
