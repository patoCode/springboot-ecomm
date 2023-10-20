package f5.software.ecomm.appication.service;

import f5.software.ecomm.appication.repository.StockRepository;
import f5.software.ecomm.domain.Product;
import f5.software.ecomm.domain.Stock;

import java.util.List;

public class StockService {

    private final StockRepository repository;

    public StockService(StockRepository repository) {
        this.repository = repository;
    }

    public Stock save(Stock stock){
        return repository.save(stock);
    }

    public List<Stock> getStockByProduct(Product p){
        return repository.getStockByProduct(p);
    }

}
