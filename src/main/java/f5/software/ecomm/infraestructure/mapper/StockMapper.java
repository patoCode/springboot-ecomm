package f5.software.ecomm.infraestructure.mapper;

import f5.software.ecomm.domain.Stock;
import f5.software.ecomm.infraestructure.entity.ProductEntity;
import f5.software.ecomm.infraestructure.entity.StockEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface StockMapper {

    @Mappings(
        {
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "dateRegister", target = "dateRegister"),
            @Mapping(source = "unitIn", target = "unitIn"),
            @Mapping(source = "unitOut", target = "unitOut"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "balance", target = "balance"),
            @Mapping(source = "product", target = "product")
        }
    )
    Stock toStock(StockEntity entity);
    List<Stock> toStock(List<StockEntity> list);
    @InheritConfiguration
    StockEntity toEntity(Stock stock);
}
