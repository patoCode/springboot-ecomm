package f5.software.ecomm.infraestructure.controllers;

import f5.software.ecomm.appication.service.ProductService;
import f5.software.ecomm.appication.service.StockService;
import f5.software.ecomm.domain.Product;
import f5.software.ecomm.domain.Stock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final ProductService service;
    private final StockService stkService;

    public HomeController(ProductService service, StockService stkService) {
        this.service = service;
        this.stkService = stkService;
    }

    @GetMapping
    public String home(Model model){
        model.addAttribute("list", service.list());
        return "home";
    }

    @GetMapping("/detalle/{id}")
    public String detail(@PathVariable Integer id, Model model){
        Product _param = new Product();
        _param.setId(id);
        Product p = service.findById(_param);
        if(_param != null){

            List<Stock> stocks = stkService.getStockByProduct(p);
            Integer lastBalance = stocks.get(stocks.size() -1).getBalance();
            model.addAttribute("producto", p);
            model.addAttribute("stock", lastBalance);
            return "user/detalle";
        }
        return "redirect:/home";
    }

}
