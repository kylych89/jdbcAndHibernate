package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.model.User;
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

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        Session session = UtilHibernate.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        /*
         * тест кылган учурда
         * shutDown методу катаа чыгарып жатат
         * java.lang.IllegalStateException: EntityManagerFactory is closed
         * ошон учун бул методду чакырган жокмун
         */
//        UtilHibernate.shutDown();
        System.out.println("Added successfully!!!\n" + user);
    }

    @Override
    public void removeUserById(long id) {
        Session session = UtilHibernate.getSessionFactory().openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();

        /*
         * тест кылган учурда
         * shutDown методу катаа чыгарып жатат
         * java.lang.IllegalStateException: EntityManagerFactory is closed
         * ошон учун бул методду чакырган жокмун
         */
//        UtilHibernate.shutDown();
        System.out.println("Successfully deleted!!!\n" + user);
    }

    @Override
    public List<User> getAllUsers() {
        Session session = UtilHibernate.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("from User ").getResultList();
        session.getTransaction().commit();
        session.close();

        /*
         * тест кылган учурда
         * shutDown методу катаа чыгарып жатат
         * java.lang.IllegalStateException: EntityManagerFactory is closed
         * ошон учун бул методду чакырган жокмун
         */
//        UtilHibernate.shutDown();
        for (User user : users) {
            System.out.println("Finded " + user + " users");
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = UtilHibernate.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from User ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();

        /*
         * тест кылган учурда
         * shutDown методу катаа чыгарып жатат
         * java.lang.IllegalStateException: EntityManagerFactory is closed
         * ошон учун бул методду чакырган жокмун
         */
//        UtilHibernate.shutDown();
        System.out.println("Table successfully cleaned!!!");
    }
}
