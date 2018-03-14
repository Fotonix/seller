package seller.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Index controller.
 *
 * @author Aleksei_Zabezhinsky
 */
@Controller
public class IndexController {

    /**
     * Перенаправляет на главную страницу.
     *
     * @return view главной страницы
     */
    @RequestMapping("/index.html")
    public String index() {
        return "redirect:/main.html";
    }

}
