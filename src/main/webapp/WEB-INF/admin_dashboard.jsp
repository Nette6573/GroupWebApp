<%--
  Created by IntelliJ IDEA.
  User: ANTOINETTE
  Date: 24/11/2024
  Time: 8:00 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Administrator Dashboard</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <h2 class="mt-5">Admin Dashboard</h2>

  <div class="list-group">
    <a href="manageStudents.jsp" class="list-group-item list-group-item-action">Manage Students</a>
    <a href="manageLecturers.jsp" class="list-group-item list-group-item-action">Manage Lecturers</a>
    <a href="manageCourses.jsp" class="list-group-item list-group-item-action">Manage Courses</a>
    <a href="manageEnrollments.jsp" class="list-group-item list-group-item-action">Manage Enrollments</a>
    <a href="logoutServlet" class="list-group-item list-group-item-action">Logout</a>
  </div>
</div>>
</body>
</html>
