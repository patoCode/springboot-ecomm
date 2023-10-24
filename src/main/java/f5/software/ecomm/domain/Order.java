package f5.software.ecomm.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {

    private Integer id;
    private LocalDateTime dateCreated;
    List<OrderProduct> orderProduct;
    private User user;

    public void addProduct(List<OrderProduct> order){
        this.setOrderProduct(order);
    }

    public BigDecimal getTotalOrderPrice(){
        return getOrderProduct().stream().map(
                p -> p.getTotalPrice()
        ).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
