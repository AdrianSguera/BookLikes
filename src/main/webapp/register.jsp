<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form method="post" action="register">
    <input type="text" placeholder="Username" name="username" required>
    <input type="password" placeholder="Password" name="password" required>
    <input type="password" placeholder="Repeat password" name="passwordRepeat" required>
    <input type="email" placeholder="Example@gmail.com" name="email" required>
    <input type="submit" value="Register">
</form>
<p><c:out value="${requestScope.errorMessage}"/></p>
</body>
</html>
