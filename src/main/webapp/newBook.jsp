<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="newBook" enctype="multipart/form-data">
    <input type="text" placeholder="Title" name="title">
    <input type="text" placeholder="Author" name="author">
    <input type="text" placeholder="Description" name="description">
    <input type="file" name="file" accept="image/*">
    <input type="submit" value="New">
</form>
</body>
</html>
