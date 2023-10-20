package f5.software.ecomm.domain;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@ToString(includeFieldNames = true)
public class Stock {

    private Integer id;
    private LocalDateTime dateRegister;
    private Integer unitIn;
    private Integer unitOut;
    private String description;
    private Integer balance;
    private Product product;

}
