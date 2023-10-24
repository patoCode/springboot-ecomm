package f5.software.ecomm.infraestructure.mapper;


import f5.software.ecomm.domain.Order;
import f5.software.ecomm.infraestructure.entity.OrderEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface OrderMapper {
    @Mappings({
        @Mapping(source="id", target="id"),
        @Mapping(source="dateCreated", target="dateCreated"),
        @Mapping(source="user", target="user")
    })

    Order toOrder(OrderEntity entity);
    Iterable<Order> toOrders(Iterable<OrderEntity> list);

    @InheritConfiguration
    OrderEntity toEntity(Order order);
}
