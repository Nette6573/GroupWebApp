package com.groupwebapp.groupwebapp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

    static {
        LoggerFactory.getLogger(LoginServlet.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate user credentials and get role (admin, student, lecturer, etc.)
        String position = DataAccessObject.validateUser(username, password);

        if (position != null) {
            // Set session attribute to track user login state (optional, but recommended)
            request.getSession().setAttribute("username", username);

            // Now, depending on the role, redirect to the corresponding dashboard
            switch (position.toLowerCase()) {
                case "admin":
                    response.sendRedirect("admin_dashboard.jsp");
                    break;
                case "student":
                    // Set student data before forwarding to the student dashboard
                    String studentName = getStudentNameFromDatabase();
                    double studentGPA = getStudentGPAFromDatabase();

                    // Set attributes for student name and GPA
                    request.setAttribute("studentName", studentName);
                    request.setAttribute("studentGPA", studentGPA);

                    // Forward the request to the student dashboard
                    RequestDispatcher dispatcher = request.getRequestDispatcher("student_dashboard.jsp");
                    dispatcher.forward(request, response);
                    break;
                case "lecturer":
                    response.sendRedirect("lecturer_dashboard.jsp");
                    break;
                default:
                    response.sendRedirect("login.jsp?error=Invalid role");
                    break;
            }
        } else {
            // If validation fails, redirect to log in with an error message
            response.sendRedirect("login.jsp?error=Invalid credentials");
        }
    }

    private String getStudentNameFromDatabase() {
        // Fetch student name from the database based on the username
        // Return the student's name or null if not found
        return "";
    }

    private double getStudentGPAFromDatabase() {
        // Fetch student GPA from the database based on the username
        // Return the GPA or 0.0 if not found
        return 0;
    }

}
