<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 05/03/2024
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en"><head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
</head>
<body>
<h1>Iniciar Sesión</h1>
<form action="login" method="post">
    <div>
        <label for="username">Usuario:</label>
        <input type="text" id="username" name="username" required>
    </div>
    <div>
        <label for="password">Contraseña:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <button type="submit">Iniciar Sesión</button>
</form>
<p>¿Aún no tienes una cuenta? <a href="register">Regístrate</a></p>
<p>¿Prefieres continuar sin iniciar sesión? <a href="nolog">Haz clic aquí</a>.</p>
<p id ="menssage">${menssage}</p>

</body></html>
