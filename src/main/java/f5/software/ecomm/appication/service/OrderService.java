package f5.software.ecomm.appication.service;

import f5.software.ecomm.appication.repository.OrderRepository;
import f5.software.ecomm.domain.Order;

public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order create(Order order){
        return repository.createOrder(order);
    }

    public Iterable<Order> getOrders(){
        return repository.getOrders();
    }


}
