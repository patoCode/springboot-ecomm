package f5.software.ecomm.infraestructure.configuration;

import f5.software.ecomm.appication.repository.*;
import f5.software.ecomm.appication.service.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productService(ProductRepository repository, UploadFile upload){
        return new ProductService(repository, upload);
    };

    @Bean
    public UploadFile upload(){
        return new UploadFile();
    }

    @Bean
    public StockService stockService(StockRepository repository){
        return new StockService(repository);
    };

    @Bean
    public ValidateStock validator(StockService service){
        return new ValidateStock(service);
    }

    @Bean
    public OrderService orderService(OrderRepository repository){
        return new OrderService(repository);
    };

    @Bean
    public OrderProductService opService(OrderProductRepository repository){
        return new OrderProductService(repository);
    }

    @Bean
    @Scope(
            value = WebApplicationContext.SCOPE_SESSION,
            proxyMode = ScopedProxyMode.TARGET_CLASS
    )
    public CarService carService(){
        return new CarService();
    }

    @Bean
    public UserService userService(UserRepository repository){
        return new UserService(repository);
    }

}
