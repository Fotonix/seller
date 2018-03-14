package seller.web.mvc.supply;

import static seller.util.UrlUtil.addFirstParameter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import seller.domain.supply.Invoice;
import seller.service.reference.ReferenceService;
import seller.service.supply.SupplyService;

/**
 * Invoice controller.
 *
 * @author Aleksei_Zabezhinsky
 */
@Controller
@RequestMapping("/supply")
public class InvoiceController {

    @Autowired
    private SupplyService supplyService;

    @Autowired
    private ReferenceService referenceService;

    /**
     * InitBinder.
     *
     * @param binder {@link WebDataBinder}
     */
    @InitBinder(value = "invoice")
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    /**
     * Отображает страницу накладной.
     *
     * @param model модель данных
     * @param id ID накладной
     * @return view страницы накладной
     */
    @RequestMapping(value = "/invoice.html", method = RequestMethod.GET)
    public String edit(Model model, @RequestParam(value = "id", required = false) Integer id) {
        initModel(model);
        Invoice invoice;
        if (id == null) {
            invoice = new Invoice();
        } else {
            invoice = supplyService.getInvoice(id);
        }
        model.addAttribute(invoice);
        return ".supply.invoice";
    }

    /**
     * Сохраняет накладную.
     *
     * @param invoice накладная
     * @param model модель данных
     * @param result результат валидации
     * @return страницу с сохраненной накладной
     */
    @RequestMapping(value = "/invoice.html", method = RequestMethod.POST)
    public String save(Invoice invoice, Model model, BindingResult result) {
        if (result.hasErrors()) {
            initModel(model);
            return ".supply.invoice";
        }
        supplyService.saveInvoice(invoice);
        return addFirstParameter("redirect:/supply/invoice.html", "id", invoice.getId());
    }

    /**
     * Отображает страницу со списком накладных.
     *
     * @param model модель данных
     * @return страницу со списком накладных
     */
    @RequestMapping(value = "/invoice/list.html", method = RequestMethod.GET)
    public String list(Model model) {
        List<Invoice> invoices = supplyService.getInvoices();
        model.addAttribute("invoices", invoices);
        return ".supply.invoice.list";
    }

    /**
     * Инициализация модели: получение необходимых справочников.
     *
     * @param model модель данных
     */
    private void initModel(Model model) {
        model.addAttribute("producers", referenceService.getProducers());
        model.addAttribute("products", referenceService.getProducts());
    }

}
