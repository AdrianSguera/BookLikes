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
    <link rel="stylesheet" href="assets/css/comment.css">
    <script src="assets/js/comment.js"></script>
</head>
<body>
<h2>BookLikes</h2>
<div class="container mt-5">
    <div class="cabecera">
        <a href="loggedUser">
            <button>Return to main page</button>
        </a>
    </div>

    <!-- Card Deck de Bootstrap para mostrar la lista de libros -->
    <div class="card-deck mt-4">
        <div class="card">
            <img src="assets/images/${bookDTO.getImageSource()}" class="card-img-top" alt="${bookDTO.getTitle()} image">
            <div class="card-body">
                <h5 class="card-title">${bookDTO.getTitle()}</h5>
                <p class="card-text">Author: ${bookDTO.getAuthor()}</p>
                <p class="card-text">Description: ${bookDTO.getDescription()}</p>
                ${bookDTO.getLikeCount()}<i class="fa-solid fa-heart"></i>
            </div>
        </div>
    </div>
</div>
<button onclick="showNewCommentForm()">Comment</button>
<div>
    <c:forEach items="${commentList}" var="comment">
        <p>${appController.getUserById(comment.getIdUser()).getUsername()}</p>
        <p>${comment.getCreationDate()}</p>
        <p>${comment.getComment()}</p>
    </c:forEach>
</div>
<div id="modalContainer" class="modal-container">
    <div class="modal-content">
        <form action="comment" method="post">
            <input type="hidden" value="${bookDTO.getId()}" name="idBook">
            <textarea name="comment" cols="30" rows="10"></textarea>
            <input onclick="hideNewCommentForm()" type="submit" value="Submit">
        </form>
    </div>
</div>
</body>
</html>