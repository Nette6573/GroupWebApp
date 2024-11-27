<%--
  Created by IntelliJ IDEA.
  User: ANTOINETTE
  Date: 24/11/2024
  Time: 8:21 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<body>
<div class="container">
    <h2 class="mt-5">Manage Students</h2>

    <a href="addStudent.jsp" class="btn btn-primary mb-3">Add Student</a>

    <table class="table">
        <thead>
        <tr>
            <th>Student ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <!-- Iterate through students -->
        <jsp:useBean id="students" scope="request" type="java.util.List"/>
        <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.student_id}</td>
            <td>${student.first_name} ${student.last_name}</td>
            <td>${student.email}</td>
            <td>
                <a href="editStudent.jsp?id=${student.student_id}" class="btn btn-warning btn-sm">Edit</a>
                <a href="deleteStudent.jsp?id=${student.student_id}" class="btn btn-danger btn-sm">Delete</a>
</body>
</html>
