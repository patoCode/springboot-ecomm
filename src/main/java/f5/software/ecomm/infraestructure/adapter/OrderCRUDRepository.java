package f5.software.ecomm.infraestructure.adapter;

import f5.software.ecomm.infraestructure.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderCRUDRepository extends CrudRepository<OrderEntity, Integer> {
}
