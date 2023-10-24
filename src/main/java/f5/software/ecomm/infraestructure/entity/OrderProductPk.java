package f5.software.ecomm.infraestructure.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class OrderProductPk {

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderEntity order;
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity product;

}
