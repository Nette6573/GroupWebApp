package com.groupwebapp.groupwebapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccessObject {
    private static final Logger logger = LoggerFactory.getLogger(DataAccessObject.class);

    // Get a user by username and password
    public static String validateUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("position"); // Return the position of the user
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            logger.error("Error during user validation for username: {}", username, e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null; // Return null if no user is found or credentials don't match
    }

    public static boolean addUser(String username, String password, String position) {
        String query = "INSERT INTO users (username, password, position) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, position);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0; // Return true if rows were affected
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error during user validation for username: {}", username, e);
            return false;
        }
    }
}
