package f5.software.ecomm.infraestructure.entity;



import f5.software.ecomm.domain.User;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Entity
@Table(name = "orders")
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dateCreated;
    @ManyToOne
    private UserEntity user;
}
