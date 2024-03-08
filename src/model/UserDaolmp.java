package model;

import repository.UserRepository;

import java.util.List;

public class UserDaolmp implements UserDao {
    @Override
    public List<User> getAllUsers() {
        return UserRepository.getAllUsers();
    }

    @Override
    public User searchUserById(Integer id) {
        List<User> users = UserRepository.getAllUsers();
        return users.stream()
                .filter(user -> user.getUser_id().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void createUser(User user) {
        UserRepository.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        UserRepository.updateUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        UserRepository.deleteUser(id);
    }
}
