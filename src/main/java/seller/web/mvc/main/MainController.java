package seller.web.mvc.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Main controller.
 *
 * @author Aleksei_Zabezhinsky
 */
@Controller
public class MainController {

    /**
     * Перенаправляет на главную страницу.
     *
     * @return view главной страницы
     */
    @RequestMapping("/main.html")
    public String index() {
        return ".main";
    }

}
