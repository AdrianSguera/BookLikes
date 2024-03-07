<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ceica.booklikes.modelos.LibroFav" %>
<%@ page import="com.ceica.booklikes.modelos.Libro" %>
<!DOCTYPE html>
<html>
<head>
    <title style="margin-top: 8px">Mybooks</title>
    <link rel="stylesheet" href="assets/css/book.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="assets/js/userbooks.js"></script> <!-- Incluye tu archivo JavaScript externo -->
</head>
<body>
    <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> BookLikes</h1>
    <div class="box">
        <div class="one">
            <table id="tablaLibros" class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>ID Libro</th>
                    <th>Título</th>
                    <th>Descripción</th>
                    <th style="width: 20%;">Autor</th>
                    <th style="width: 11%;">Editar</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Libro> libros = (List<Libro>) request.getAttribute("libroscreados");
                    if (libros != null) {
                        for (Libro libro : libros) {
                %>
                <tr>
                    <td><%= libro.getId() %></td>
                    <td><%= libro.getTitulo() %></td>
                    <td><%= libro.getDescripcion() %></td>
                    <td><%= libro.getAutor() %></td>
                    <td> <i class="fa-regular fa-pen-to-square" style=""></i>
                        <i onclick="borrar(<%= libro.getId() %>)" class="fa-solid fa-trash" style="margin-left: 10px;"></i>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>

        <form>
            <label for="inputBusqueda">Search:</label>
            <input oninput="buscarLibro()" type="search" id="inputBusqueda" name="inputBusqueda" placeholder="Buscar" style="width: 80%; margin-left: 10px;">
        </form>

        <div class="two">
            <form method="post" action="mybooks">
                <label for="title" >Título:</label>
                <input type="text" id="title" name="titulo" style="
                  width: 80%;
                     margin-left: 10px;">

                <label for="descripcion">Descripción:</label>
                <textarea id="descripcion" name="descripcion" rows="3" cols="21" style="margin-left:10px; width: 80%;"></textarea>

                <label for="autor">Autor:</label>
                <input type="text" id="autor" name="autor" style="
                margin-block-end: 5px;
                width: 80%;
                margin-left: 10px;"><br>

                <input type="submit" value="Enviar" style="margin-left: 10px">
            </form>
        </div>
    </div>
</body>
</html>