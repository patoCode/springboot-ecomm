package f5.software.ecomm.appication.repository;

import f5.software.ecomm.domain.Order;

public interface OrderRepository {
    public Order createOrder(Order order);
    public Iterable<Order> getOrders();
}
