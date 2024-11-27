package com.groupwebapp.groupwebapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    // Create a logger instance
    private static final Logger logger = LoggerFactory.getLogger(DatabaseUtil.class);

    // Database URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/registry_system";
    private static final String USER = "root"; // username
    private static final String PASSWORD = "Twinny07112017"; // MySQL password

    // Method to establish and return a database connection
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection result;
        try {
            // Load the JDBC driver (optional for newer versions of Java)
            Class.forName("com.mysql.cj.jdbc.Driver");
            result = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            logger.error("Error while establishing database connection.", e);
            throw e;
        }
        return result;
    }
}
