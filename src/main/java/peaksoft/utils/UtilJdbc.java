package peaksoft.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilJdbc {
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
}
