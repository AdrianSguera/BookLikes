<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 05/03/2024
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ceica.booklikes.modelos.LibroFav" %>
<%@ page import="com.ceica.booklikes.modelos.Libro" %>
<!DOCTYPE html>
<html>
<style>
    #tablaLibrosFav {
        display: none;
    }
</style>
<head>
    <title>Título de tu página</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="assets/js/loged.js"></script> <!-- Incluye tu archivo JavaScript externo -->
</head>
<body>


<!-- Contenido de tu página -->

<table id="tablaLibros">
    <thead>
    <tr>
        <th>ID Libro</th>
        <th>Título</th>
        <th>Descripción</th>
        <th>Autor</th>
        <th>Likes</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<LibroFav> libros = (List<LibroFav>) request.getAttribute("libros");
        if (libros != null) {
            for (LibroFav libro : libros) {
    %>
    <tr>
        <td><%= libro.getId() %></td>
        <td><%= libro.getTitulo() %></td>
        <td><%= libro.getDescripcion() %></td>
        <td><%= libro.getAutor() %></td>
        <td><%= libro.getFavoritos() %></td>
        <td><i class="fa fa-heart" onclick="newfavorito(<%= libro.getId() %>, <%= libro.getIdUsusario() %>)"></i></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>

<table id="tablaLibrosFav">
    <thead>
    <tr>
        <th>ID Libro</th>
        <th>Título</th>
        <th>Descripción</th>
        <th>Autor</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Libro> favLibrosByUser = (List<Libro>) request.getAttribute("favLibrosByUser");
        if (favLibrosByUser != null) {
            for (Libro libro : favLibrosByUser) {
    %>
    <tr>
        <td><%= libro.getId() %></td>
        <td><%= libro.getTitulo() %></td>
        <td><%= libro.getDescripcion() %></td>
        <td><%= libro.getAutor() %></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>

<button onclick="cambiarTabla()">Mostrar Libros Favoritos</button>

<!-- Buscador de libros -->
<input type="text" id="inputBusqueda" placeholder="Buscar libro...">
<button onclick="buscarLibro()">Buscar</button>

<!-- Botón para redirigir a la página "crud" -->
<a href="edit" class="button">Quieres crear un libro? Clickea</a>


<!-- Más contenido de tu página -->

</body>
</html>

