package peaksoft.service;

import peaksoft.model.User;

import java.util.List;

public interface UserService {

    UserService INSTANCE = new UserServiceImpl();

    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}

