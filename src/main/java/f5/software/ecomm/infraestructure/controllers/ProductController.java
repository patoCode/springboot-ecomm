package f5.software.ecomm.infraestructure.controllers;

import f5.software.ecomm.appication.service.ProductService;
import f5.software.ecomm.domain.Product;
import f5.software.ecomm.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/product")
@Slf4j
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public String show(Model model){
        User u = new User();
        u.setId(1);
        List<Product> list = service.getProductByUser(u);
        model.addAttribute("list", list);
        return "admin/products/show";
    }

    @GetMapping("/create")
    public String create(){
        return "admin/products/create";
    }

    @PostMapping("/save")
    public String save(Product p, @RequestParam("img") MultipartFile file) throws IOException {
        Product res = service.save(p, file);
        return "redirect:/admin/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model m){
        Product parameter = new Product();
        parameter.setId(id);
        m.addAttribute("product", service.findById(parameter));
        return "admin/products/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model m){
        service.delete(id);
        return "redirect:/admin/product";
    }


}
