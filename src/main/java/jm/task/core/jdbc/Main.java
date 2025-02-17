package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Vasya", "Belokonev", (byte) 35);
        userService.saveUser("Kolya", "Vasylev", (byte) 24);
        userService.saveUser("Kostya", "Gusov", (byte) 28);
        userService.saveUser("Mr", "Bean", (byte) 65);
        userService.removeUserById(1L);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
