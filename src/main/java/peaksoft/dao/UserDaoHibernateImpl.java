package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.model.User;
import peaksoft.utils.HibernateConfiguration;
import peaksoft.utils.UtilHibernate;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {
//        Session session = UtilHibernate.getSessionFactory().openSession();
//        session.beginTransaction();
//        Query query = session.createQuery("drop from User");
//        query.executeUpdate();
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("Table successfully deleted!!!");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
//        Session session = UtilHibernate.getSessionFactory().openSession();
        Session session = HibernateConfiguration.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("Added successfully!!!\n" + user);
    }

    @Override
    public void removeUserById(long id) {
//        Session session = UtilHibernate.getSessionFactory().openSession();
        Session session = HibernateConfiguration.getSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted!!!\n" + user);
    }

    @Override
    public List<User> getAllUsers() {
//        Session session = UtilHibernate.getSessionFactory().openSession();
        Session session = HibernateConfiguration.getSession();
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
//        Session session = UtilHibernate.getSessionFactory().openSession();
        Session session = HibernateConfiguration.getSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from User ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Table successfully cleaned!!!");
    }
}
