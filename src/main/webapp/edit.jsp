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
    <form method="get" action="edit">
        <label for="title" >Título:</label>
        <input type="hidden" name="idlibro" value="${libro.idlibro}">
        <input type="text" id="title" name="titulo" style="
                  width: 80%;
                     margin-left: 10px;" value="${libro.titulo}">

        <label for="descripcion">Descripción:</label>
        <textarea id="descripcion" name="descripcion" rows="3" cols="21" style="margin-left:10px; width: 80%;"></textarea>

        <label for="autor">Autor:</label>
        <input type="text" id="autor" name="autor" style="
                margin-block-end: 5px;
                width: 80%;
                margin-left: 10px;"><br>

        <a href="mybooks"><input type="submit" value="Enviar" style="margin-left: 10px"></a>
    </form>
</div>
</body>
</html>
