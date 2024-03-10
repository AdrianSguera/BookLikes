<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>BookLikes</title>
    <link rel="stylesheet" href="assets/css/myBooks.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="assets/js/myBooks.js"></script>
</head>
<body>
<div class="container mt-5">
    <div class="cabecera">
        <a href="loggedUser">
            <button>Return to all books</button>
        </a>
    </div>
    <h2>BookLikes</h2>
    <h3><c:out value="${sessionScope.userLogged.getUsername()}"/> books</h3>

    <!-- Card Deck de Bootstrap para mostrar la lista de libros -->
    <div id="bookInfoDiv" class="card-deck mt-4">
        <c:forEach items="${bookDTObyUserList}" var="bookDTObyUser">
            <div class="card">
                <img src="assets/images/${bookDTObyUser.getImageSource()}" class="card-img-top"
                     alt="<c:out value="${bookDTObyUser.getTitle()}"/> image">
                <div class="card-body">
                    <h5 class="card-title"><c:out value="${bookDTObyUser.getTitle()}"/></h5>
                    <p class="card-text">Author: <c:out value="${bookDTObyUser.getAuthor()}"/></p>
                    <p class="card-text">Description: <c:out value="${bookDTObyUser.getDescription()}"/></p>
                    <p id="likesManager${bookDTObyUser.getId()}">
                        <c:out value="${bookDTObyUser.getLikeCount()}"/>
                        <c:set var="liked" value="false" />
                        <c:forEach items="${likesList}" var="like">
                            <c:if test="${like.idUser == userLogged.id && like.idBook == bookDTObyUser.id}">
                                <c:set var="liked" value="true" />
                            </c:if>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${liked eq true}">
                                <i onclick="manageLikes(${bookDTObyUser.id})" class="fa-solid fa-heart" style="color: red"></i>
                            </c:when>
                            <c:otherwise>
                                <i onclick="manageLikes(${bookDTObyUser.id})" class="fa-solid fa-heart"></i>
                            </c:otherwise>
                        </c:choose>
                    </p>
                    <p>
                        <i onclick="showEditForm(${bookDTObyUser.getId()})" class="fa-solid fa-file-pen"></i>
                        <i onclick="deleteBook(${bookDTObyUser.getId()})" class="fa-solid fa-trash"></i>
                    </p>
                </div>
            </div>
            <div id="modalContainer${bookDTObyUser.getId()}" class="modal-container">
                <div id="editForm" class="modal-content">
                    <form method="post" action="editBook">
                        <input type="hidden" name="id" value="${bookDTObyUser.getId()}">
                        <input type="text" name="title" value="${bookDTObyUser.getTitle()}">
                        <input type="text" name="author" value="${bookDTObyUser.getAuthor()}">
                        <input type="text" name="description" value="${bookDTObyUser.getDescription()}">
                        <input onclick="hideEditForm(${bookDTObyUser.getId()})" type="submit" value="Save">
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<a href="newBook.jsp">
    <button>New Book</button>
</a>
</body>
</html>
