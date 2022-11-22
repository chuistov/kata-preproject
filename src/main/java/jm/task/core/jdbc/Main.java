package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Ivan", "Ivanov", (byte) 25);
        userService.saveUser("Maria", "Petrova", (byte) 27);
        userService.saveUser("Simon", "Jones", (byte) 35);

        var users = userService.getAllUsers();
        System.out.println("\nUser list before deletion");
        users.forEach(System.out::println);

        userService.removeUserById(1);
        users = userService.getAllUsers();
        System.out.println("\nUser list after deletion");
        users.forEach(System.out::println);



    }


}
