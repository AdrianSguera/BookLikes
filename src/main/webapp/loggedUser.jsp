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
    <script src="assets/js/myBooks.js"></script>
    <script src="assets/js/loggedUser.js"></script>
</head>
<body>
<div class="container mt-5">
    <div class="cabecera">
        <a href="myBooks">
            <button>My Books</button>
        </a>
        <a href="login">
            <button>Close session</button>
        </a>
    </div>
    <h2>BookLikes</h2>
    <input type="text" id="searchInput" placeholder="Search...">
    <!-- Card Deck de Bootstrap para mostrar la lista de libros -->
    <div id="bookContainer" class="card-deck mt-4">
        <c:forEach items="${bookDTOList}" var="bookDTO">
            <div class="card">
                <a href="comment?idBook=${bookDTO.getId()}"><img src="assets/images/${bookDTO.getImageSource()}" class="card-img-top"
                     alt="${bookDTO.getTitle()} image"></a>
                <div class="card-body">
                    <h5 class="card-title">${bookDTO.getTitle()}</h5>
                    <p class="card-text">Uploaded by: ${appController.getUserById(bookDTO.getIdUser()).getUsername()}</p>
                    <p class="card-author">Author: ${bookDTO.getAuthor()}</p>
                    <p class="card-text">Description: ${bookDTO.getDescription()}</p>
                    <p id="likesManager${bookDTO.getId()}">
                        ${bookDTO.getLikeCount()}
                        <c:set var="liked" value="false" />
                        <c:forEach items="${likesList}" var="like">
                            <c:if test="${like.idUser == user.id && like.idBook == bookDTO.id}">
                                <c:set var="liked" value="true" />
                            </c:if>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${liked eq true}">
                                <i onclick="manageLikes(${bookDTO.id})" class="fa-solid fa-heart" style="color: red"></i>
                            </c:when>
                            <c:otherwise>
                                <i onclick="manageLikes(${bookDTO.id})" class="fa-solid fa-heart"></i>
                            </c:otherwise>
                        </c:choose>
                    </p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>