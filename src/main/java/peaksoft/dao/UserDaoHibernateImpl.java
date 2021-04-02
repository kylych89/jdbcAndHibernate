package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.model.User;
import peaksoft.util.HibernateConfiguration;
import peaksoft.util.Util;

import java.sql.SQLException;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        try (
                Session session = Util.getSession();
                session.beginTransaction();
                session.createQuery("create table if not exists users (id serial primary key, name varchar(50) not null, last_name varchar(50) not null, age int)");



        ) {

        } catch (SQLException s) {

        }


    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from User");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Table successfully deleted!!!");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        Session session = Util.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("Added successfully!!!\n" + user);
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted!!!\n" + user);
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSession();
        session.beginTransaction();
        List<User> users = session.createQuery("from User ").getResultList();
        session.getTransaction().commit();
        session.close();
        for (User user : users) {
            System.out.println("Finded " + user + " users");
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from User");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Table successfully cleaned!!!");
    }
}
