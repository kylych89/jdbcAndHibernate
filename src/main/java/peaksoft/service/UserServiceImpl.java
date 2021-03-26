package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    public void createUsersTable() {
        UserDao.INSTANCE.createUsersTable();
    }

    public void dropUsersTable() {
        UserDao.INSTANCE.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
       UserDao.INSTANCE.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        UserDao.INSTANCE.removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> list;
        list = UserDao.INSTANCE.getAllUsers();
        return list;
    }

    public void cleanUsersTable() {
        UserDao.INSTANCE.cleanUsersTable();
    }
}
