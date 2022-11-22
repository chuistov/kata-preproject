package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.exception.DaoException;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static final UserDaoJDBCImpl userDaoJdbc = new UserDaoJDBCImpl();

    private UserDaoJDBCImpl() {
    }

    public static UserDaoJDBCImpl getUserDaoJdbc() {
        return userDaoJdbc;
    }

    public void createUsersTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS repository.user (
                    id bigint auto_increment primary key,
                    name varchar(100),
                    last_name varchar(100),
                    age tinyint);
                """;
        try (var connection = Util.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void dropUsersTable() {
        String sql = """
                DROP TABLE IF EXISTS repository.user;
                """;
        try (var connection = Util.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = """
                INSERT INTO repository.user (name, last_name, age)
                VALUES (?, ?, ?);
                """;
        try (var connection = Util.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void removeUserById(long id) {
        String sql = """
                DELETE FROM repository.user
                WHERE id = ?;
                """;
        try (var connection = Util.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sql = """
                SELECT * FROM repository.user;
                """;
        try (var connection = Util.getConnection();
             var statement = connection.prepareStatement(sql)) {

            var resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                byte age = resultSet.getByte(4);
                list.add(new User(id, name, lastName, age));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return list;
    }

    public void cleanUsersTable() {
        String sql = """
                TRUNCATE TABLE repository.user;
                """;
        try (var connection = Util.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
