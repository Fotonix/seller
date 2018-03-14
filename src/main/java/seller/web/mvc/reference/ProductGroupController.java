package seller.web.mvc.reference;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import seller.domain.reference.ProductGroup;
import seller.service.reference.ReferenceService;
import seller.web.mvc.AjaxController;

/**
 * ProductGroup controller.
 *
 * @author Aleksei_Zabezhinsky
 */
@Controller
@RequestMapping("/reference/productGroup.html")
public class ProductGroupController extends AjaxController {

    @Autowired
    private ReferenceService referenceService;

    /**
     * Отображает страницу списка групп товаров.
     *
     * @return страница списка групп товаров
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView(".reference.productGroup");
        List<ProductGroup> list = referenceService.getProductGroups();
        modelAndView.addObject("productGroups", list);
        return modelAndView;
    }

    /**
     * Сохраняет группу товара.
     *
     * @param entity группа товара, которую необходимо сохранить
     * @return ID сохраненной группы товаров
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Integer save(@RequestBody ProductGroup entity) {
        referenceService.saveProductGroup(entity);
        return entity.getId();
    }

    /**
     * Удаляет группу товара.
     *
     * @param id ID группы товара, которую необходимо удалить
     */
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@RequestBody Integer id) {
        referenceService.deleteProductGroup(id);
    }

}
