package com.groupwebapp.groupwebapp;

import com.registry.service.CourseGrade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/dashboard")
public class StudentServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(StudentServlet.class);  // Logger setup
    private GPAService gpaService;

    @Override
    public void init() {
        gpaService = new GPAService();
    }

    // If you don't need to throw ServletException or IOException in doPost, remove the 'throws' clause.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        // This method doesn't throw exceptions in your code, so no need for 'throws ServletException, IOException'
    }

    // If you don't need to throw ServletException or IOException in doGet, remove the 'throws' clause.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<CourseGrade> grades = getStudentGradesFromDatabase();

            // Calculate GPA using the GPAService
            double gpa = gpaService.calculateGPA(Collections.singletonList((CourseGrade) grades));

            // Set GPA as an attribute to display on the JSP
            request.setAttribute("gpa", gpa);

            // Forward to JSP page (e.g., student dashboard)
            RequestDispatcher dispatcher = request.getRequestDispatcher("studentDashboard.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            // Use SLF4J logger to log the exception with a meaningful message
            logger.error("Error processing student dashboard request", e);  // Log the exception using logger
        }
    }

    // Example method to retrieve student grades
    private List<CourseGrade> getStudentGradesFromDatabase() {
        // This would actually query the database
        return List.of(
                new CourseGrade("CS101", "A", 3),
                new CourseGrade("MA101", "B+", 4)
        );
    }
}
