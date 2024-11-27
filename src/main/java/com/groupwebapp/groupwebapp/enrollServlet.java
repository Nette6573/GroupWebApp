package com.groupwebapp.groupwebapp;

import com.registry.service.CourseGrade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/enrollServlet")
public class enrollServlet  extends HttpServlet {
    private GPAService gpaService;

    @Override
    public void init() {
        gpaService = new GPAService();
    }

    // Retrieve a list of CourseGrade objects from the database or session
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<CourseGrade> grades = getStudentGradesFromDatabase();

        // Set the grades (enrollments) as an attribute in the request
        request.setAttribute("enrollments", grades);

        // Calculate GPA using the GPAService
        double gpa = gpaService.calculateGPA(grades);  // Pass the correct list here

        // Set GPA as an attribute to display on the JSP
        request.setAttribute("gpa", gpa);

        // Forward to JSP page (e.g., studentDashboard.jsp)
        RequestDispatcher dispatcher = request.getRequestDispatcher("courseEnroll.jsp");
        dispatcher.forward(request, response);
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
