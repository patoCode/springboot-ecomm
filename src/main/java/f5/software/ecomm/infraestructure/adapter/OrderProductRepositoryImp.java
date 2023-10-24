package f5.software.ecomm.infraestructure.adapter;

import f5.software.ecomm.appication.repository.OrderProductRepository;
import f5.software.ecomm.appication.repository.OrderRepository;
import f5.software.ecomm.domain.Order;
import f5.software.ecomm.domain.OrderProduct;
import f5.software.ecomm.infraestructure.mapper.OrderMapper;
import f5.software.ecomm.infraestructure.mapper.OrderProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderProductRepositoryImp implements OrderProductRepository{

    OrderProductCRUDRepository repository;
    OrderMapper mapper;
    OrderProductMapper opMapper;

    public OrderProductRepositoryImp(OrderProductCRUDRepository repository, OrderMapper mapper, OrderProductMapper opMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.opMapper = opMapper;
    }

    @Override
    public OrderProduct create(OrderProduct op) {
        return opMapper.toOrderProduct(repository.save(opMapper.toEntity(op)));
    }

    @Override
    public Iterable<OrderProduct> getOrderProducts() {
        return opMapper.toOrderProducts(repository.findAll());
    }

    @Override
    public List<OrderProduct> getOrderProductByOrder(Order order) {
        return opMapper.toOrderProductList(repository.findByPkOrder(mapper.toEntity(order)));
    }
}
