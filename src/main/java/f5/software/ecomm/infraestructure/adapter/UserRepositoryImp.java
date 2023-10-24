package f5.software.ecomm.infraestructure.adapter;

import f5.software.ecomm.appication.repository.UserRepository;
import f5.software.ecomm.domain.User;
import f5.software.ecomm.infraestructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImp implements UserRepository {

    public UserCRUDRepository repository;
    public UserMapper mapper;

    public UserRepositoryImp(UserCRUDRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User create(User u) {
        return mapper.toUser(repository.save(mapper.toUserEntity(u)));
    }

    @Override
    public User findByEmail(String email) {
        return mapper.toUser(repository.findByEmail(email).get());
    }

    @Override
    public User findById(Integer id) {
        return mapper.toUser(repository.findById(id).get());
    }
}
