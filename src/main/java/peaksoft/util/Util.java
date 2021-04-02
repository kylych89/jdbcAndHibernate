package peaksoft.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import peaksoft.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.URL;

public class Util {
    // реализуйте настройку соеденения с БД
    private final static String url = "jdbc:postgresql://localhost:5432/user";
    private final static String user = "postgres";
    private final static String password = "010689";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connected to the PostgreSQL server successfully!!!");
            } else {
                System.out.println("Connection to the PostgreSQL server failed!!!");
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
        return connection;
    }

    private static final SessionFactory sessionFactory;

    static {
        try {
            Properties prop = new Properties();
            prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/user");
            prop.setProperty("hibernate.connection.username", "postgres");
            prop.setProperty("hibernate.connection.password", "010689");
            prop.setProperty("dialect", "org.hibernate.dialect.PostgreSQL9Dialect");

//            prop.setProperty("hibernate.hbm2ddl.auto", "create");

            sessionFactory = new org.hibernate.cfg.Configuration()
                    .addProperties(prop)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }

    public static void shutDown() {
        getSession().close();
    }
}
