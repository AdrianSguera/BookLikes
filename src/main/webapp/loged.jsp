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
<head>
    <title style="margin-top: 8px">BookLikes</title>
    <link rel="stylesheet" href="assets/css/book.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="assets/js/loged.js"></script> <!-- Incluye tu archivo JavaScript externo -->
    <style>
        #tablaLibrosFav {
            display: none;
        }
    </style>
</head>
<body>
    <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> BookLikes</h1>
    <div style="float: right; margin-top: 5px; margin-right: 45px;">
        <a href="mybooks"><input  class="campo" type="submit" value="My books"></a>
    </div>

    <div class="box">
        <div class="one">
            <table id="tablaLibros" class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>ID Libro</th>
                    <th>Título</th>
                    <th>Descripción</th>
                    <th style="width: 20%;">Autor</th>
                    <th style="width: 12%;">Likes</th>
                </tr>
                </thead>
                <tbody id="tabladeLibrosFav">
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
                    <td>
                        <%= libro.getFavoritos() %>
                        <i class="fa-regular fa-star" onclick="newfavorito(<%= libro.getId() %>, <%= request.getAttribute("iduser") %>)"></i>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>

        <table id="tablaLibrosFav" class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>ID Libro</th>
                <th>Título</th>
                <th>Descripción</th>
                <th>Autor</th>
                <th>Likes</th>
            </tr>
            </thead>
            <tbody id="tabladeLibrosUser">
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
                <td>
                    <i class="fa-regular fa-star" onclick="deletefavorito(<%= libro.getId() %>, <%= request.getAttribute("iduser") %><%= libro.getTitulo() %>)"></i>
                </td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>

        <form>
            <label for="inputBusqueda">Search:</label>
            <input oninput="buscarLibro()" type="search" id="inputBusqueda" name="inputBusqueda" placeholder="Buscar" style="width: 80%; margin-left: 10px;">
        </form>
    </div>

    <button id="cambiarTabla" onclick="cambiarTabla()">Mostrar Libros Favoritos</button>
    <a href="login"><button>Cerrar sesión</button></a>
</body>
</html>
