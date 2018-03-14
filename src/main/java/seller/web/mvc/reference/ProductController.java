package seller.web.mvc.reference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import seller.domain.reference.Product;
import seller.service.reference.ReferenceService;
import seller.web.mvc.AjaxController;

/**
 * Product controller.
 *
 * @author Aleksei_Zabezhinsky
 */
@Controller
@RequestMapping("/reference/product.html")
public class ProductController extends AjaxController {

    @Autowired
    private ReferenceService referenceService;

    /**
     * Отображает страницу списка продукции.
     *
     * @param model модель данных
     * @return страница списка продукции
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("productGroups", referenceService.getProductGroups());
        model.addAttribute("products", referenceService.getProducts());
        return ".reference.product";
    }

    /**
     * Сохраняет товар.
     *
     * @param entity товар, который необходимо сохранить
     * @return ID сохраненного товара
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Integer save(@RequestBody Product entity) {
        referenceService.saveProduct(entity);
        return entity.getId();
    }

    /**
     * Удаляет товар.
     *
     * @param id ID товара, который необходимо удалить
     */
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@RequestBody Integer id) {
        referenceService.deleteProduct(id);
    }

}
