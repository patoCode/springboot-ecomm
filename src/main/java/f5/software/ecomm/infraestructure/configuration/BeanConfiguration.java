package f5.software.ecomm.infraestructure.configuration;

import f5.software.ecomm.appication.repository.ProductRepository;
import f5.software.ecomm.appication.repository.StockRepository;
import f5.software.ecomm.appication.service.ProductService;
import f5.software.ecomm.appication.service.StockService;
import f5.software.ecomm.appication.service.UploadFile;
import f5.software.ecomm.appication.service.ValidateStock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

}
