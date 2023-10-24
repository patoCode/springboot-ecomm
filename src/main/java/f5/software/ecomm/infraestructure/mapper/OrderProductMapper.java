package f5.software.ecomm.infraestructure.mapper;

import f5.software.ecomm.domain.OrderProduct;
import f5.software.ecomm.infraestructure.entity.OrderProductEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, OrderMapper.class})
public interface OrderProductMapper {
    @Mappings({
        @Mapping(source="pk.product", target="producto"),
        @Mapping(source="qty", target="qty"),
        @Mapping(source="pk.order", target="order")
    })

    OrderProduct toOrderProduct(OrderProductEntity op);
    Iterable<OrderProduct> toOrderProducts(Iterable<OrderProductEntity> list);
    List<OrderProduct> toOrderProductList(Iterable<OrderProductEntity> list);
    @InheritConfiguration
    OrderProductEntity toEntity(OrderProduct p);

}
