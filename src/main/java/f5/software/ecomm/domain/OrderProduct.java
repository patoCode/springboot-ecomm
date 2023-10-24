package f5.software.ecomm.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderProduct {
    private Product producto;
    private Order order;
    private Integer qty;

    public OrderProduct(Product producto, Order order, Integer qty) {
        this.producto = producto;
        this.order = order;
        this.qty = qty;
    }

    public BigDecimal getTotalPrice(){
        return this.producto.getPrice().multiply(BigDecimal.valueOf(qty));
    }

}
