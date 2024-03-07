<%@ page import="java.sql.Connection" %>
<%@ page import="com.ceica.booklikes.modelos.ModeloBase" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página de inicio</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7;
        }

        h1 {
            text-align: center;
            margin-top: 50px;
            color: #333;
        }

        p {
            text-align: center;
            color: #666;
        }

        ul {
            list-style-type: none;
            padding: 0;
            text-align: center;
            margin-top: 20px;
        }

        li {
            display: inline-block;
            margin: 0 10px;
        }

        a {
            text-decoration: none;
            padding: 10px 20px;
            background-color: #04AA6D;
            color: white;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        a:hover {
            background-color: #038c58;
        }
    </style>
</head>
<body>
<h1>Bienvenido a la página de inicio</h1>
<p>Por favor, elige una opción:</p>
<ul>
    <li><a href="login">Iniciar Sesión</a></li>
    <li><a href="register">Registrarse</a></li>
</ul>
</body>
</html>
