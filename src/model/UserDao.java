package model;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User searchUserById(Integer id);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
}
