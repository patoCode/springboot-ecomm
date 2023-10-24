package f5.software.ecomm.appication.service;

import f5.software.ecomm.appication.repository.UserRepository;
import f5.software.ecomm.domain.User;

public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User u){
        return repository.create(u);
    }

    public User findByEmail(String email){
        return repository.findByEmail(email);
    }

    public User findById(Integer id){
        return repository.findById(id);
    }

}
