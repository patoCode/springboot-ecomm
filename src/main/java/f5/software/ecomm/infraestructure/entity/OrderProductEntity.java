package f5.software.ecomm.infraestructure.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders_product")
public class OrderProductEntity {
    @EmbeddedId
    private OrderProductPk pk;
    private Integer qty;
}
