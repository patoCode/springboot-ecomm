package f5.software.ecomm.infraestructure.adapter;

import f5.software.ecomm.appication.repository.OrderRepository;
import f5.software.ecomm.domain.Order;
import f5.software.ecomm.infraestructure.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImp implements OrderRepository {

    private final OrderCRUDRepository repository;
    private final OrderMapper mapper;

    public OrderRepositoryImp(OrderCRUDRepository repository, OrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Order createOrder(Order order) {
        return mapper.toOrder(repository.save(mapper.toEntity(order)));
    }

    @Override
    public Iterable<Order> getOrders() {
        return mapper.toOrders(repository.findAll());
    }
}
