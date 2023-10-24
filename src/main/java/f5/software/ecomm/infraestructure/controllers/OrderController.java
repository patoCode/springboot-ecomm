package f5.software.ecomm.infraestructure.controllers;


import f5.software.ecomm.appication.service.*;
import f5.software.ecomm.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user/sumary")
@Slf4j
public class OrderController {

    private final CarService cartService;
    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderProductService orderProductService;
    private final StockService stockService;
    private final ValidateStock validator;

    public OrderController(CarService cartService, UserService userService, ProductService productService, OrderService orderService, OrderProductService orderProductService, StockService stockService, ValidateStock validator) {
        this.cartService = cartService;
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
        this.stockService = stockService;
        this.validator = validator;
    }

    @GetMapping("/show")
    public String showSummary(Model model){
        User u = userService.findById(1);
        model.addAttribute("cart", cartService.list());
        model.addAttribute("total", cartService.getTotalCar());
        model.addAttribute("user", u);
        return "user/cart/sumary";
    }

    @GetMapping("/save")
    public String createOrder(){
        log.info("Creando orden");

        // User
        User u = userService.findById(1);

        // ORDER
        Order o = new Order();
        o.setDateCreated(LocalDateTime.now());
        o.setUser(u);

        Order orderSaved = orderService.create(o);
        log.info("ORDEN "+orderSaved.toString());

        // Order Product
        List<OrderProduct> list = new ArrayList<>();

        for(ItemCar item : cartService.list()){
            Product p = new Product();
            p.setId(item.getIdProduct());
            list.add(new OrderProduct(productService.findById(p), orderSaved,item.getQty()));
        }
        // GUARDAR
        list.forEach(
                op->{
                    orderProductService.create(op);
                    Stock stk = new Stock();
                    stk.setDateRegister(LocalDateTime.now());
                    stk.setProduct(op.getProducto());
                    stk.setDescription("VENTA");
                    stk.setUnitOut(op.getQty());
                    stockService.save(validator.calculateBalance(stk));
                }
        );

        // VACIAMOS EL CARRITO
        cartService.removeAllItemCar();

        return "redirect:/home";
    }

}
