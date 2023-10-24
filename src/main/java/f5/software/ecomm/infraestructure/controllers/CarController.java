package f5.software.ecomm.infraestructure.controllers;

import f5.software.ecomm.appication.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/cart")
@Slf4j
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @PostMapping("/add-item")
    public String addProduct(@RequestParam Integer qty,
                             @RequestParam Integer idProduct,
                             @RequestParam String nameProduct,
                             @RequestParam BigDecimal price){
        service.addItemCar(qty,idProduct,nameProduct,price);
        showCart();
        return "redirect:/home";
    }

    private void showCart() {
        service.list().forEach(itemCar -> log.info("Item "+itemCar.toString()));
    }

    @GetMapping
    public String getCart(Model model){
        showCart();
        model.addAttribute("cart", service.list());
        model.addAttribute("total", service.getTotalCar());
        return "user/cart/cart";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        log.info("PRUEBA DE DELETE " + id);
        service.removeItemCar(id);
        return "redirect:/cart";
    }

}
