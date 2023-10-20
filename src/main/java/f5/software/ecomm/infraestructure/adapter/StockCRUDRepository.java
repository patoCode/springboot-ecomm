package f5.software.ecomm.infraestructure.adapter;

import f5.software.ecomm.infraestructure.entity.ProductEntity;
import f5.software.ecomm.infraestructure.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockCRUDRepository extends CrudRepository<StockEntity, Integer> {
    List<StockEntity> findByProduct(ProductEntity p);

}
