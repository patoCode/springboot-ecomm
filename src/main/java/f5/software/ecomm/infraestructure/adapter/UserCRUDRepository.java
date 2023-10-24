package f5.software.ecomm.infraestructure.adapter;

import f5.software.ecomm.domain.User;
import f5.software.ecomm.infraestructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCRUDRepository extends CrudRepository<UserEntity, Integer> {
     Optional<UserEntity> findByEmail(String email);
}
