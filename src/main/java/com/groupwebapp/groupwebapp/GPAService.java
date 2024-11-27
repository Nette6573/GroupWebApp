package com.groupwebapp.groupwebapp;

import com.registry.service.CourseGrade;

import java.util.List;

public class GPAService {
    /**
     * Calculates the GPA based on a list of CourseGrade objects.
     * @param grades List of CourseGrade objects containing grades and course credits
     * @return GPA as a double
     */
    public double calculateGPA(List<CourseGrade> grades) {
        double totalQualityPoints = 0;
        double totalCredits = 0;

        for (CourseGrade grade : grades) {
            double qualityPoints = getQualityPoints(grade.getgrade());
            totalQualityPoints += qualityPoints * grade.getCredits();
            totalCredits += grade.getCredits();
        }

        return totalCredits > 0 ? totalQualityPoints / totalCredits : 0;
    }

    /**
     * Maps the grade to the corresponding quality points.
     * @param grade Grade received for the course (A, B+, etc.)
     * @return Quality points corresponding to the grade
     */
    private double getQualityPoints(String grade) {
        return switch (grade) {
            case "A" -> 4.00;
            case "B+" -> 3.50;
            case "B" -> 3.00;
            case "B-" -> 2.67;
            case "C+" -> 2.33;
            case "C" -> 2.00;
            case "D" -> 1.67;
            case "F" -> 0.00;
            default -> 0.00; // Default if no valid grade
        };
    }
}
