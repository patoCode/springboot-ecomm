package f5.software.ecomm.appication.service;

import f5.software.ecomm.domain.Product;
import f5.software.ecomm.domain.Stock;

import java.util.List;

public class ValidateStock {

    private final StockService service;

    public ValidateStock(StockService service) {
        this.service = service;
    }

    private boolean existsBalance(Product p){
        List<Stock> list = service.getStockByProduct(p);
        return list.isEmpty();
    }

    public Stock calculateBalance(Stock stock){
        if(stock.getUnitIn() > 0){
            if(existsBalance(stock.getProduct())){
                List<Stock> list = service.getStockByProduct(stock.getProduct());
                if(!list.isEmpty()){
                    Integer _balance = list.get(list.size() - 1).getBalance();
                    stock.setBalance(_balance + stock.getUnitIn());
                }
            } else {
                stock.setBalance(stock.getUnitIn());
            }
        } else{
            List<Stock> list = service.getStockByProduct(stock.getProduct());
            Integer _balance = list.get(list.size() - 1).getBalance();
            stock.setBalance(_balance - stock.getUnitOut());
        }
        return stock;
    }
}
