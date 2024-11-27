package com.registry.service;

public class CourseGrade {
    private String courseCode;
    private String grade;
    private int credits;

    // Constructor, Getters, and Setters
    public CourseGrade(String courseCode, String grade, int credits) {
        this.courseCode = courseCode;
        this.grade = grade;
        this.credits = credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getgrade() {
        return grade;
    }
}
