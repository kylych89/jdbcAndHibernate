package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDaoJdbc = new UserDaoJdbcImpl();
    private UserDao userDaoHibernate = new UserDaoHibernateImpl();

    public void createUsersTable() {
//        userDaoJdbc.createUsersTable();
        userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() {
//        userDaoJdbc.dropUsersTable();
        userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
//        userDaoJdbc.saveUser(name, lastName, age);
        userDaoHibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
//        userDaoJdbc.removeUserById(id);
        userDaoHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> list;
//        list = userDaoJdbc.getAllUsers();
        list = userDaoHibernate.getAllUsers();
        return list;
    }

    public void cleanUsersTable() {
//        userDaoJdbc.cleanUsersTable();
        userDaoHibernate.cleanUsersTable();
    }
}
