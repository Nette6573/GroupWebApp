<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registry</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<h1>Welcome to the Registry Department!</h1>
<div class="container">
    <h2 class="text-center mt-5">Login</h2>
    <form action="login" method="POST">
        <div class="form-group">
            <label for="username">Username (Student ID or Admin)</label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Login</button>
    </form>
    <p class="mt-3">Don't have an account? <a href="Register.jsp">Register here</a></p>

    <%-- Display error message if any --%>
    <c:if test="${not empty param.error}">
        <div class="alert alert-danger mt-3">
            <strong>Error!</strong> ${param.error}
        </div>
    </c:if>
</div>
</body>
</html>
