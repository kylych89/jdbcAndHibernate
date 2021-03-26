package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    public void createUsersTable() {
        UserDao.INSTANCE_JDBC.createUsersTable();
    }

    public void dropUsersTable() {
        UserDao.INSTANCE_JDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
//        UserDao.INSTANCE.saveUser(name, lastName, age);
        UserDao.INSTANCE_HIBERNATE.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
//        UserDao.INSTANCE_JDBC.removeUserById(id);
        UserDao.INSTANCE_HIBERNATE.removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> list;
//        list = UserDao.INSTANCE_JDBC.getAllUsers();

        list = UserDao.INSTANCE_HIBERNATE.getAllUsers();

        return list;
    }

    public void cleanUsersTable() {
//        UserDao.INSTANCE_JDBC.cleanUsersTable();
        UserDao.INSTANCE_HIBERNATE.cleanUsersTable();

    }
}
