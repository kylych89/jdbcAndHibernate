package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoJdbcImpl();

    public void createUsersTable() {
        userDao.createUsersTable();
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
//        UserDao.INSTANCE_HIBERNATE.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
//        UserDao.INSTANCE_HIBERNATE.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
//        UserDao.INSTANCE_HIBERNATE.removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> list;
        list = userDao.getAllUsers();

//        list = UserDao.INSTANCE_HIBERNATE.getAllUsers();

        return list;
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
//        UserDao.INSTANCE_HIBERNATE.cleanUsersTable();

    }
}
