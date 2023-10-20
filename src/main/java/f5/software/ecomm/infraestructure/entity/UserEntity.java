package f5.software.ecomm.infraestructure.entity;

import f5.software.ecomm.domain.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String name;
    private String lastname;
    private String email;
    private String address;
    private String cellphone;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType type;

    private LocalDateTime created;

    @OneToMany
    private List<ProductEntity> productEntity;
}
