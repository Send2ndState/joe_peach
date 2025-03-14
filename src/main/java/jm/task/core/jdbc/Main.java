package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Test1", "Test1", (byte) 35);
        userService.saveUser("Test2", "Test2", (byte) 24);
        userService.saveUser("Test3", "Test3", (byte) 28);
        userService.saveUser("Test4", "Test4", (byte) 65);
        userService.removeUserById(1L);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
