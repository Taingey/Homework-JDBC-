package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static List<User> getAllUsers() {
        PropertiesLoader.loadProperties();
        String sql = "SELECT * FROM USERS";
        List<User> userList = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(
                        PropertiesLoader.properties.getProperty("database_url"),
                        PropertiesLoader.properties.getProperty("database_username"),
                        PropertiesLoader.properties.getProperty("database_password")
                );
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                userList.add(mapResultSetToUser(resultSet));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching users: " + e.getMessage());
        }
        return userList;
    }


    // Method to retrieve a user by ID
    public static User getUserById(Integer id) {
        String sql = "SELECT * FROM USERS WHERE user_id = ?";
        try (
                Connection connection = DriverManager.getConnection(
                        PropertiesLoader.properties.getProperty("database_url"),
                        PropertiesLoader.properties.getProperty("database_username"),
                        PropertiesLoader.properties.getProperty("database_password")
                );
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToUser(resultSet);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching user by ID: " + e.getMessage());
        }
        return null;
    }

    public static void createUser(User user) {
        String sql = "INSERT INTO USERS (user_uuid, user_name, user_email, user_password, is_deleted, is_verified) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        PropertiesLoader.loadProperties();
        try (
                Connection connection = DriverManager.getConnection(
                        PropertiesLoader.properties.getProperty("database_url"),
                        PropertiesLoader.properties.getProperty("database_username"),
                        PropertiesLoader.properties.getProperty("database_password")
                );
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, user.getUser_uuid());
            preparedStatement.setString(2, user.getUser_name());
            preparedStatement.setString(3, user.getUser_email());
            preparedStatement.setString(4, user.getUser_password());
            preparedStatement.setBoolean(5, user.is_deleted());
            preparedStatement.setBoolean(6, user.is_verified());

            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Error while creating user: " + sqlException.getMessage());
        }
    }

    public static void updateUser(User user) {
        String sql = "UPDATE USERS SET user_uuid=?, user_name=?, user_email=?, user_password=?, is_deleted=?, is_verified=? WHERE user_id=?";
        PropertiesLoader.loadProperties();
        try (
                Connection connection = DriverManager.getConnection(
                        PropertiesLoader.properties.getProperty("database_url"),
                        PropertiesLoader.properties.getProperty("database_username"),
                        PropertiesLoader.properties.getProperty("database_password")
                );
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, user.getUser_uuid());
            preparedStatement.setString(2, user.getUser_name());
            preparedStatement.setString(3, user.getUser_email());
            preparedStatement.setString(4, user.getUser_password());
            preparedStatement.setBoolean(5, user.is_deleted());
            preparedStatement.setBoolean(6, user.is_verified());
            preparedStatement.setInt(7, user.getUser_id());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Error while updating user: " + sqlException.getMessage());
        }
    }


    public static void deleteUser(int userId) {
        String sql = "DELETE FROM USERS WHERE user_id=?";
        PropertiesLoader.loadProperties();
        try (
                Connection connection = DriverManager.getConnection(
                        PropertiesLoader.properties.getProperty("database_url"),
                        PropertiesLoader.properties.getProperty("database_username"),
                        PropertiesLoader.properties.getProperty("database_password")
                );
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Error while deleting user: " + sqlException.getMessage());
        }
    }

    private static User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt("user_id"),
                resultSet.getString("user_uuid"),
                resultSet.getString("user_name"),
                resultSet.getString("user_email"),
                resultSet.getString("user_password"),
                resultSet.getBoolean("is_deleted"),
                resultSet.getBoolean("is_verified")
        );
    }
}
