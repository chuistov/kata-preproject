package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
    }

    public void createUsersTable() {
        UserDaoJDBCImpl.getUserDaoJdbc().createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoJDBCImpl.getUserDaoJdbc().dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UserDaoJDBCImpl.getUserDaoJdbc().saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        UserDaoJDBCImpl.getUserDaoJdbc().removeUserById(id);
    }

    public List<User> getAllUsers() {
        return UserDaoJDBCImpl.getUserDaoJdbc().getAllUsers();
    }

    public void cleanUsersTable() {
        UserDaoJDBCImpl.getUserDaoJdbc().cleanUsersTable();
    }
}
