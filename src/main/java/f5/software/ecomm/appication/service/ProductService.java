package f5.software.ecomm.appication.service;


import f5.software.ecomm.appication.repository.ProductRepository;
import f5.software.ecomm.domain.Product;
import f5.software.ecomm.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public class ProductService {

    private final ProductRepository repository;
    private final UploadFile upload;

    public ProductService(ProductRepository repository, UploadFile upload) {
        this.repository = repository;
        this.upload = upload;
    }

    /* ====================== IMPORTANTE ====================== */
    /* ACA DEBEMOS IMPLEMENTAR TODOS LOS METODOS DEL repository */
    public Product findById(Product p){
        return repository.findById(p);
    }


    public List<Product> list(){
        return repository.list();
    }

    public Product save(Product p, MultipartFile file) throws IOException {
        User u = new User();
        u.setId(1);
        if(p.getId() == null){
            p.setUser(u);
            p.setCreated(LocalDateTime.now());
            p.setUpdated(LocalDateTime.now());
            p.setImage(upload.upload(file));
            return repository.save(p);
        }else{
            Product _db = repository.findById(p);
            if(!file.isEmpty()){

                if(!_db.getImage().equals("default.jpg"))
                    upload.deleteImage(_db.getImage());

                _db.setImage(upload.upload(file));
            }
            _db.setUser(u);
            _db.setName(p.getName());
            _db.setDescription(p.getDescription());
            _db.setUpdated(LocalDateTime.now());
            return repository.save(_db);
        }
    }

    public List<Product> getProductByUser(User u){
        return repository.getProductByUser(u);
    }

    public void delete(Integer id){
        Product p = new Product();
        p.setId(id);
        repository.delete(p);
        log.info("---- Eliminado el producto " + p.toString());
    }

}
