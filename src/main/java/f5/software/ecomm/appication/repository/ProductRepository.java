package f5.software.ecomm.appication.repository;

import f5.software.ecomm.domain.Product;
import f5.software.ecomm.domain.User;

import java.util.List;

public interface ProductRepository {

    public Product findById(Product p);
    public Product save(Product p);
    public Product update(Product p);
    public void delete(Product p);
    public List<Product> list();
    public Product findByName(String name);
    public List<Product> getProductByUser(User u);

}
