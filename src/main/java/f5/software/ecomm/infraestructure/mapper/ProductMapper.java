package f5.software.ecomm.infraestructure.mapper;

import f5.software.ecomm.domain.Product;
import f5.software.ecomm.infraestructure.entity.ProductEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "image", target = "image"),
            @Mapping(source = "created", target = "created"),
            @Mapping(source = "updated", target = "updated"),
            @Mapping(source = "user", target = "user")
    })
    Product toProduct(ProductEntity entity);
    Iterable<Product> toProducts(Iterable<ProductEntity> products);

    @InheritConfiguration
    ProductEntity toProductEntity(Product p);

}
