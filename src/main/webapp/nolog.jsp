<%@ page import="com.ceica.booklikes.modelos.Libro" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 05/03/2024
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Libros</title>
</head>
<script src="nolog.js"></script>
<body>
<h1>Lista de Libros</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Título</th>
        <th>Descripción</th>
        <th>Autor</th>
        <th>Likes</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Obtener la lista de libros desde el atributo del request
        List<Libro> libros = (List<Libro>) request.getAttribute("libros");

        if (libros !=null){
        for (Libro libro : libros) {
    %>
    <tr>
        <td><%= libro.getId() %></td>
        <td><%= libro.getTitulo() %></td>
        <td><%= libro.getDescripcion() %></td>
        <td><%= libro.getAutor() %></td>
        <td><input type="button" onclick="newfavorito(<%=libro.getId()+"&"+libro.getIdUsusario()%>)">Like</input></td>
    </tr>
    <%
        }
    }else{
        out.println("No se encontraron libros.");
        } %>
    </tbody>
</table>

<form action="login">
    <input type="submit" value="Login">
</form>
</body>
</html>
