<%@ page import="com.ceica.booklikes.modelos.Libro" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ceica.booklikes.modelos.LibroFav" %><%--
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
    <title style="margin-top: 8px">BookLikes</title>
    <div>
        <input class="campo" type="submit" value="Login" style="float: right;
    margin-top: 5px;
    margin-right: 45px;"
               }>
        <link rel="stylesheet" href="assets/css/book.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    </div>
</head>
<body>
<border>
    <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> BookLikes</h1>
    <div class="box">
<table border="1" id="customers" class="table table-striped table-bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>Título</th>
        <th>Descripción</th>
        <th style="width: 20%">Autor</th>
        <th style=" width: 10%;">Date</th>
        <th style="width: 8%;">Likes</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Obtener la lista de libros desde el atributo del request
        List<LibroFav> libros = (List<LibroFav>) request.getAttribute("libros");

        if (libros !=null){
        for (LibroFav libro : libros) {
    %>
    <tr>
        <td><%= libro.getId() %></td>
        <td><%= libro.getTitulo() %></td>
        <td><%= libro.getDescripcion() %></td>
        <td><%= libro.getAutor() %></td>
        <td><%= libro.getFavoritos()%></td>
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
    </div>
</border>
</body>
</html>
