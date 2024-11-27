<%--
  Created by IntelliJ IDEA.
  User: ANTOINETTE
  Date: 24/11/2024
  Time: 8:19 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Course Enrollment</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <h2 class="mt-5">Enroll in a Course</h2>

  <form action="enrollServlet" method="POST">
    <div class="form-group">
      <label for="courseCode">Course Code</label>
      <input type="text" class="form-control" id="courseCode" name="courseCode" required>
    </div>
    <button type="submit" class="btn btn-primary">Enroll</button>
  </form>
</div>
</body>
</html>
