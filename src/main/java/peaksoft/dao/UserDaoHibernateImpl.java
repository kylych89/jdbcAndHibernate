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
        String SQLQuery = "create table if not exists users " +
                "(id serial primary key, " +
                "name varchar(50) not null, " +
                "last_name varchar(50) not null, " +
                "age int)";
        Session session = null;
        try {
            session = Util.getSession();
            session.beginTransaction();
            session.createSQLQuery(SQLQuery).executeUpdate();
            session.getTransaction().commit();
            System.out.println("Hibernate table successfully created!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session == null) {
                session.close();
            } else if (session.getTransaction() == null) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        String SQLTableClean = "drop table if exists users";
        Session session = null;
        try {
            session = Util.getSession();
            session.beginTransaction();
            Query query = session.createSQLQuery(SQLTableClean);
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Hibernate table successfully deleted!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session == null) {
                session.close();
            } else if (session.getTransaction() == null) {
                session.getTransaction().rollback();
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
            System.out.println("Hibernate table successfully saved!!!\n" + user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session == null) {
                session.close();
            } else if (session.getTransaction() == null) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = null;
        try {
            session = Util.getSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            System.out.println("Hibernate table successfully deleted!!!\n" + user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session == null) {
                session.close();
            } else if (session.getTransaction() == null) {
                session.getTransaction().rollback();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session = null;
        List<User> users = null;
        try {
            session = Util.getSession();
            session.beginTransaction();
            users = session.createQuery("from User ").getResultList();
            session.getTransaction().commit();
            session.close();
            for (User user : users) {
                System.out.println("Finded " + user + " users");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session == null) {
                session.close();
            } else if (session.getTransaction() == null) {
                session.getTransaction().rollback();
            }
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = null;
        try {
            session = Util.getSession();
            session.beginTransaction();
            Query query = session.createQuery("delete from User");
            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Hibernate table successfully cleaned!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session == null) {
                session.close();
            } else if (session.getTransaction() == null) {
                session.getTransaction().rollback();
            }
        }
    }
}
