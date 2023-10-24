package f5.software.ecomm.appication.service;

import f5.software.ecomm.appication.repository.OrderProductRepository;
import f5.software.ecomm.domain.Order;
import f5.software.ecomm.domain.OrderProduct;

import java.util.List;

public class OrderProductService {
    private final OrderProductRepository repository;

    public OrderProductService(OrderProductRepository repository) {
        this.repository = repository;
    }

    public OrderProduct create(OrderProduct orderProduct){
        return repository.create(orderProduct);
    }

    public Iterable<OrderProduct> getOrderProducts(){
        return repository.getOrderProducts();
    }

    public List<OrderProduct> getOrderProductsByOrder(Order o){
        return repository.getOrderProductByOrder(o);
    }

}
