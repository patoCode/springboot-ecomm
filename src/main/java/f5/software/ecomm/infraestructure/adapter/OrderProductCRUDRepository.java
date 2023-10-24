package f5.software.ecomm.infraestructure.adapter;

import f5.software.ecomm.infraestructure.entity.OrderEntity;
import f5.software.ecomm.infraestructure.entity.OrderProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderProductCRUDRepository extends CrudRepository<OrderProductEntity, Integer> {

    List<OrderProductEntity> findByPkOrder(OrderEntity o);

}
