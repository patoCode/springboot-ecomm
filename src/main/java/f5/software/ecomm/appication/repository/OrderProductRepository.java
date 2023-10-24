package f5.software.ecomm.appication.repository;

import f5.software.ecomm.domain.Order;
import f5.software.ecomm.domain.OrderProduct;

import java.util.List;

public interface OrderProductRepository {

    OrderProduct create(OrderProduct op);
    Iterable<OrderProduct> getOrderProducts();
    List<OrderProduct> getOrderProductByOrder(Order order);


}
