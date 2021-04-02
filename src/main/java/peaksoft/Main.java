package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

public class Main {

     static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        // JDBC

//        userService.dropUsersTable();

//        userService.createUsersTable();
//
//        userService.saveUser("Kanat", "Subanov", (byte) 23);
//        userService.saveUser("Kylych", "Sydykov", (byte) 32);
//        userService.saveUser("Chyngyz", "Sharshekeev", (byte) 34);
//        userService.saveUser("Aktan", "Chakiev", (byte) 17);
//        userService.saveUser("Kairat", "Mambetakunov", (byte) 33);
//        userService.saveUser("Esen", "Ryspekov", (byte) 29);

//        userService.getAllUsers();

//        userService.removeUserById(4);

//        userService.cleanUsersTable();





        // Hibernate
//        UserService.INSTANCE.saveUser("Kanat", "Subanov", (byte) 23);
//        UserService.INSTANCE.saveUser("Kylych", "Sydykov", (byte) 32);
//        UserService.INSTANCE.saveUser("Chyngyz", "Sharshekeev", (byte) 34);
//        UserService.INSTANCE.saveUser("Aktan", "Chakiev", (byte) 17);
//        UserService.INSTANCE.saveUser("Kairat", "Mambetakunov", (byte) 33);
//        UserService.INSTANCE.saveUser("Esen", "Ryspekov", (byte) 29);

//        UserService.INSTANCE.getAllUsers();

//        UserService.INSTANCE.removeUserById(1);

//        UserService.INSTANCE.cleanUsersTable();

//        UserService.INSTANCE.dropUsersTable();

    }
}
