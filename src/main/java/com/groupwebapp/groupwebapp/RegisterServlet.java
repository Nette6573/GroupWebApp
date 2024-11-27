package com.groupwebapp.groupwebapp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    public RegisterServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get user inputs from the registration form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String position = request.getParameter("position");

        // Hash the password before storing it (use a secure hashing algorithm)
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        // Use DataAccessObject to add the user (username, hashed password, and position)
        boolean isAdded = DataAccessObject.addUser(username, hashedPassword, position);

        if (isAdded) {
            // Redirect to login page after successful registration
            response.sendRedirect("login.jsp");
        } else {
            // If registration failed, show an error message (you can redirect to register.jsp with error)
            response.sendRedirect("register.jsp?error=Registration failed");
        }
    }
}
