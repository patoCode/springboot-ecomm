package f5.software.ecomm.infraestructure.controllers;

import f5.software.ecomm.appication.service.ProductService;
import f5.software.ecomm.domain.Product;
import f5.software.ecomm.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductService service;

    public AdminController(ProductService service) {
        this.service = service;
    }
    @GetMapping
    public String home(Model model){
        User u = new User();
        u.setId(1);
        List<Product> list = service.getProductByUser(u);
        model.addAttribute("list", list);
        return "admin/home";
    }

}
