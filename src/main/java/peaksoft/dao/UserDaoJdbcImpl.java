package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {
    }

    public void createUsersTable() {
        String SQLQuery = "create table if not exists users (id serial primary key, name varchar(50) not null, last_name varchar(50) not null, age int)";
        try (Connection connection = Util.getConnection();
             Statement st = connection.createStatement()) {
            st.executeUpdate(SQLQuery);
            System.out.println("Table created to the PostgreSQL successfully!!!");
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    public void dropUsersTable() {
        String SQLDropTable = "drop table users";
        try (Connection connection = Util.getConnection();
             Statement st = connection.createStatement()) {
            st.executeUpdate(SQLDropTable);
            System.out.println("The table is deleted successfully!!!");
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }

    }

    public void saveUser(String name, String lastName, byte age) {

        String SQLInsert = "insert into users (name, last_name, age) values (?, ?, ?)";
        try (Connection connection = Util.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQLInsert)) {
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setByte(3, age);
            ps.executeUpdate();
            System.out.println(name + " is saved to database successfully!!!");
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    public void removeUserById(long id) {
        String SQLRemove = "delete from users where id = ?";
        try (Connection connection = Util.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQLRemove)) {
            ps.setLong(1, id);
            ps.executeUpdate();
            System.out.println("user with this " + id + " was successfully deleted!!!");
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    public List<User> getAllUsers() {

        List<User> list = new ArrayList<>();

        String SQLGetAllUsers = "select * from users";
        try (Connection connection = Util.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQLGetAllUsers);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setAge(rs.getByte(4));
                list.add(user);
                System.out.println(user);
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
        return list;
    }

    public void cleanUsersTable() {
        String SQLTableClean = "truncate users";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQLTableClean);
            System.out.println("Users table is successfully cleaned!!!");
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }
}