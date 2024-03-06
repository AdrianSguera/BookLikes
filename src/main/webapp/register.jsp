<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 05/03/2024
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<link rel="stylesheet" href="assets/css/login.css">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrarse</title>
</head>
<body>
<h1>Registrarse</h1>
<form class="form-signup" action="register" method="post">
    <input type="text" id="user-name" class="form-control" placeholder="username" name="username" required="" autofocus="">
    <input type="password" id="user-pass" class="form-control" placeholder="password" name="password" required autofocus="">
    <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Sign Up</button>
</form>
</body>
</html>

