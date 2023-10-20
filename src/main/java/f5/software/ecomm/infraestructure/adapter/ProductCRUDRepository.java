package f5.software.ecomm.infraestructure.adapter;

import f5.software.ecomm.domain.Product;
import f5.software.ecomm.infraestructure.entity.ProductEntity;
import f5.software.ecomm.infraestructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCRUDRepository extends CrudRepository<ProductEntity, Integer> {

    Iterable<ProductEntity> findByUser(UserEntity u);
}
