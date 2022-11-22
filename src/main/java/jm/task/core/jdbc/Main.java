package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        var user1 = new User("Ivan", "Ivanov", (byte) 25);
        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        System.out.println("User с именем " + user1.getName() + " добавлен в базу данных");

        var user2 = new User("Maria", "Petrova", (byte) 35);
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        System.out.println("User с именем " + user2.getName() + " добавлен в базу данных");

        var user3 = new User("Simon", "Jones", (byte) 5);
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        System.out.println("User с именем " + user3.getName() + " добавлен в базу данных");

        var user4 = new User("Jose", "Merkator", (byte) 75);
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        System.out.println("User с именем " + user4.getName() + " добавлен в базу данных");

        var users = userService.getAllUsers();
        users.forEach(System.out::println);

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
