<%--
  Created by IntelliJ IDEA.
  User: ANTOINETTE
  Date: 24/11/2024
  Time: 8:16 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Courses</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="mt-5">Available Courses</h2>

    <table class="table">
        <thead>
        <tr>
            <th>Course Code</th>
            <th>Title</th>
            <th>Credits</th>
            <th>Degree Level</th>
            <th>Prerequisites</th>
        </tr>
        </thead>
        <tbody>
        <!-- Iterate through the courses -->
        <jsp:useBean id="courses" scope="request" type="java.util.List"/>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.course_code}</td>
                <td>${course.title}</td>
                <td>${course.credits}</td>
                <td>${course.degree_level}</td>
                <td>${course.prerequisites}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
