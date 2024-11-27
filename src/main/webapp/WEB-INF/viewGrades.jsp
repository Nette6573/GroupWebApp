<%--
  Created by IntelliJ IDEA.
  User: ANTOINETTE
  Date: 24/11/2024
  Time: 8:18 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- Correct JSTL Taglib -->
<html>
<head>
  <title>Grades</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <h2 class="mt-5">Your Grades</h2>

  <table class="table">
    <thead>
    <tr>
      <th>Course Code</th>
      <th>Coursework Grade</th>
      <th>Final Exam Grade</th>
      <th>Final Grade</th>
    </tr>
    </thead>
    <tbody>
    <!-- Iterate through student’s grades -->
    <%--@elvariable id="enrollments" type="java.util.List"--%>
    <c:forEach var="enrollment" items="${enrollments}">
      <tr>
        <td>${enrollment.course_code}</td>
        <td>${enrollment.coursework_grade}</td>
        <td>${enrollment.final_exam_grade}</td>
        <td>${enrollment.final_grade}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>

