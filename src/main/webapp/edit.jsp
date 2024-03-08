<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 07/03/2024
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

<div class="two">
    <form method="post" action="edit">
        <label for="title" >Título:</label>
        <input type="text" id="title" name="titulo" style="
                  width: 80%;
                     margin-left: 10px;" value="${libro.getTitulo()}">

        <label for="descripcion">Descripción:</label>
        <textarea id="descripcion" name="descripcion" rows="3" cols="21" style="margin-left:10px; width: 80%;">${libro.getDescripcion()}</textarea>

        <label for="autor">Autor:</label>
        <input type="text" id="autor" name="autor" style="
                margin-block-end: 5px;
                width: 80%;
                margin-left: 10px;" value="${libro.getAutor()}"><br>

        <input type="hidden" name="idLibro" value="${libro.getId()}">

        <input type="submit" value="Enviar" style="margin-left: 10px">
    </form>
</div>
</body>
</html>
