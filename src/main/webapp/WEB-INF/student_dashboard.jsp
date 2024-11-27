<jsp:useBean id="studentGPA" scope="request" type="com.groupwebapp.groupwebapp.StudentServlet"/>
<jsp:useBean id="studentName" scope="request" type="com.groupwebapp.groupwebapp.LoginServlet"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Student Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="mt-5">Welcome, ${studentName}</h2>
    <p>Your current GPA: ${studentGPA}</p>

    <div class="list-group">
        <a href="viewCourses.jsp" class="list-group-item list-group-item-action">View Courses</a>
        <a href="viewGrades.jsp" class="list-group-item list-group-item-action">View Grades</a>
        <a href="courseEnroll.jsp" class="list-group-item list-group-item-action">Enroll in a Course</a>
        <a href="logoutServlet" class="list-group-item list-group-item-action">Logout</a>
    </div>
</div>
</body>
</html>
