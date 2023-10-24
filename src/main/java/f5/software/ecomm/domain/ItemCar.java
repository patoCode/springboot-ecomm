package f5.software.ecomm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@ToString(includeFieldNames = true)
public class ItemCar {
    private Integer idProduct;
    private String nameProduct;
    private Integer qty;
    private BigDecimal price;

    public BigDecimal getTotalPriceItem(){
        return price.multiply(BigDecimal.valueOf(qty));
    }
}
