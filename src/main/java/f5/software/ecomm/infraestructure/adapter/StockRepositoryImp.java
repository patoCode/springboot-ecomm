package f5.software.ecomm.infraestructure.adapter;

import f5.software.ecomm.appication.repository.StockRepository;
import f5.software.ecomm.domain.Product;
import f5.software.ecomm.domain.Stock;
import f5.software.ecomm.infraestructure.mapper.ProductMapper;
import f5.software.ecomm.infraestructure.mapper.StockMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class StockRepositoryImp implements StockRepository {

    private final StockCRUDRepository repository;
    private final StockMapper mapper;
    private final ProductMapper productMapper;

    public StockRepositoryImp(StockCRUDRepository repository, StockMapper mapper, ProductMapper productMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.productMapper = productMapper;
    }

    @Override
    public Stock save(Stock stock) {
        return mapper.toStock(repository.save(mapper.toEntity(stock)));
    }

    @Override
    public List<Stock> getStockByProduct(Product product) {
        return mapper.toStock(repository.findByProduct(productMapper.toProductEntity(product)));
    }
}
