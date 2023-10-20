package f5.software.ecomm.infraestructure.controllers;


import f5.software.ecomm.appication.service.StockService;
import f5.software.ecomm.appication.service.ValidateStock;
import f5.software.ecomm.domain.Product;
import f5.software.ecomm.domain.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/admin/product/stock")
@Slf4j
public class StockController {

    private final StockService service;
    private final ValidateStock validate;

    public StockController(StockService service, ValidateStock validate) {
        this.service = service;
        this.validate = validate;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model){
        Product p = new Product();
        p.setId(id);
        model.addAttribute("list", service.getStockByProduct(p));
        model.addAttribute("idProducto", id);
        return "/admin/stock/show";
    }

    @GetMapping("/create/{id}")
    public String create(@PathVariable Integer id, Model model){
        model.addAttribute("idProducto", id);
        return "/admin/stock/create";
    }

    @PostMapping("/save")
    public String save(Stock stock, @RequestParam("id") Integer id){
        stock.setDateRegister(LocalDateTime.now());
        stock.setDescription("TO-INVENTORY");
        Product p = new Product();
        p.setId(id);
        stock.setProduct(p);
        service.save(validate.calculateBalance(stock));
        return "redirect:/admin/product";
    }

}
