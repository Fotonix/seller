package seller.web.mvc.supply;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Supply controller.
 *
 * @author Aleksei_Zabezhinsky
 */
@Controller
public class SupplyController {

    /**
     * Перенаправляет на страницу создания накладной.
     *
     * @return view страницы накладной
     */
    @RequestMapping("/supply.html")
    public String index() {
        return "redirect:/supply/invoice.html";
    }

}
