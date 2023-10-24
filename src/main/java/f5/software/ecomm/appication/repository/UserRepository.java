package f5.software.ecomm.appication.repository;

import f5.software.ecomm.domain.User;

public interface UserRepository {
    public User create(User u);
    public User findByEmail(String email);
    public User findById(Integer id);
}