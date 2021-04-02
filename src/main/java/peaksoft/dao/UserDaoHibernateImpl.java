package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        String SQLQuery = "create table if not exists users (id serial primary key, name varchar(50) not null, last_name varchar(50) not null, age int)";
        Session session = null;
        try {
            session = Util.getSession();
            session.beginTransaction();
            session.createSQLQuery(SQLQuery);
            session.getTransaction().commit();
            System.out.println("Table successfully deleted!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session == null) {
                session.close();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        String SQLTableClean = "truncate users";
        Session session = null;
        try {
            session = Util.getSession();
            session.beginTransaction();
            Query query = session.createSQLQuery(SQLTableClean);
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Table successfully deleted!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session == null) {
                session.close();
            }
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        Session session = null;
        try {
            session = Util.getSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            System.out.println("Added successfully!!!\n" + user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session == null) {
                session.close();
            }
        }
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
