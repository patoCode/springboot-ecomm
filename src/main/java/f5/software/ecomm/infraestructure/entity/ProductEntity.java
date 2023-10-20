package f5.software.ecomm.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private String description;
    private String image;
    private BigDecimal price;
    private LocalDateTime created;
    private LocalDateTime updated;

    @ManyToOne
    private UserEntity user;
}
