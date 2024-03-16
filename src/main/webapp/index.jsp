<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>BookLikes</title>
    <link rel="stylesheet" href="assets/css/index.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Arvo:ital,wght@0,400;0,700;1,400;1,700&family=Dancing+Script&display=swap" rel="stylesheet">
</head>
<body>
<header>
    <div class="container mt-5">
    <div class="cabecera">
        <a href="register">
            <button class="btnsesion">Register</button>
        </a>
        <a href="login">
            <button class="btnsesion">Log in</button>
        </a>
    </div>
    <h2>BookLikes</h2>
</header>
    <!-- Card Deck de Bootstrap para mostrar la lista de libros -->
    <div class="card-deck mt-4">
        <c:forEach items="${bookDTOList}" var="bookDTO">
            <div class="card">
                <img src="assets/images/${bookDTO.getImageSource()}" class="card-img-top" alt="<c:out value="${bookDTO.getTitle()}"/> image">
                <div class="card-body">
                    <h5 class="card-title"><c:out value="${bookDTO.getTitle()}"/></h5>
                    <p class="card-text">Author: <c:out value="${bookDTO.getAuthor()}"/></p>
                    <p class="card-text">Description: <c:out value="${bookDTO.getDescription()}"/></p>
                    <c:out value="${bookDTO.getLikeCount()}"/><i class="fa-solid fa-heart"></i>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>