package f5.software.ecomm.infraestructure.adapter;

import f5.software.ecomm.appication.repository.ProductRepository;
import f5.software.ecomm.domain.Product;
import f5.software.ecomm.domain.User;
import f5.software.ecomm.infraestructure.mapper.ProductMapper;
import f5.software.ecomm.infraestructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductrepositoryImp implements ProductRepository {
    private final ProductCRUDRepository repository;
    private final ProductMapper mapper;
    private final UserMapper userMapper;

    public ProductrepositoryImp(ProductCRUDRepository repository, ProductMapper mapper, UserMapper userMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.userMapper = userMapper;
    }

    @Override
    public Product findById(Product p) {
        return mapper.toProduct(repository.findById(p.getId()).orElse(null));
    }

    @Override
    public Product save(Product p) {
        return mapper.toProduct( repository.save(mapper.toProductEntity(p) ) );
    }

    @Override
    public Product update(Product p) {
        return null;
    }

    @Override
    public void delete(Product p) {
        repository.deleteById(p.getId());
    }

    @Override
    public List<Product> list() {
        return (List<Product>) mapper.toProducts(repository.findAll());
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public List<Product> getProductByUser(User u) {
        return (List<Product>) mapper.toProducts(repository.findByUser(userMapper.toUserEntity(u)));
    }
}
