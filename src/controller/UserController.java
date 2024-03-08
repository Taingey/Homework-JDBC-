package controller;

import model.User;
import model.UserDao;
import model.UserDaolmp;

import java.util.List;

public class UserController {
    private final UserDao userDao = new UserDaolmp();

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User searchById(Integer id) {
        return userDao.searchUserById(id);
    }

    public void createUser(User user) {
        userDao.createUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }
}
