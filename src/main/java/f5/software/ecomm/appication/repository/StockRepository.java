package f5.software.ecomm.appication.repository;


import f5.software.ecomm.domain.Product;
import f5.software.ecomm.domain.Stock;

import java.util.List;


public interface StockRepository {

    Stock save(Stock stock);
    List<Stock> getStockByProduct(Product product);

}
