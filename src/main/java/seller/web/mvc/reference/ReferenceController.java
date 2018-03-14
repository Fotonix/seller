package seller.web.mvc.reference;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Reference controller.
 *
 * @author Aleksei_Zabezhinsky
 */
@Controller
public class ReferenceController {

    /**
     * Перенаправляет на страницу группы товаров.
     *
     * @return view страницы группы товаров
     */
    @RequestMapping("/reference.html")
    public String index() {
        return "redirect:/reference/productGroup.html";
    }

}
