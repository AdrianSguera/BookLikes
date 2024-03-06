<%@ page import="java.sql.Connection" %>
<%@ page import="com.ceica.booklikes.modelos.ModeloBase" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
    Connection con= ModeloBase.getConnection();
%>
<html lang="en"><head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página de inicio</title>
</head>
<body>
<h1>Bienvenido a la página de inicio</h1>
<p>Por favor, elige una opción:</p>
<ul>
    <li><a href="login">Iniciar Sesión</a></li>
    <li><a href="register">Registrarse</a></li>
</ul>

</body></html>