<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="login">
    <input type="text" placeholder="Username or email" name="usernameOrEmail" required>
    <input type="password" placeholder="Password" name="password" required>
    <input type="submit" value="Log in">
</form>
<p><c:out value="${requestScope.errorMessage}"/></p>
<a href="register"><button>Do not have an account? Click here to register!</button></a>
</body>
</html>
