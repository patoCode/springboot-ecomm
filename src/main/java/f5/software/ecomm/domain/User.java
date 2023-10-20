package f5.software.ecomm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
public class User {

    private Integer id;
    private String username;
    private String name;
    private String lastname;
    private String email;
    private String address;
    private String cellphone;
    private String password;
    private UserType type;
    private LocalDateTime created;


}
