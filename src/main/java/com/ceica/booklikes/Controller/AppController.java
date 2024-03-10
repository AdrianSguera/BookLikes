package com.ceica.booklikes.Controller;

import com.ceica.booklikes.modelos.*;

import java.util.ArrayList;
import java.util.List;

public class AppController {
    private User userLogged;
    public AppController() {
    }

    public boolean Login(String userOrEmail, String pass) {
        this.userLogged = User.login(userOrEmail, pass);
        return this.userLogged!=null;
    }

    public User getUserLogged() {
        return userLogged;
    }

    public void setUserLogged(User user) {
        this.userLogged = user;
    }

    public List<User> getUsersDB() {
        return User.getUsersDB();
    }

    public List<Book> getBooksDB() {
        return Book.getBooksDB();
    }

    public List<BookDTO> getBookDTOsDB(){
        return new BookDTO().getBookDTOsDB();
    }

    public List<BookDTO> getBookDTOsByUser() {
        return new BookDTO().getBookDTOsByUser(userLogged);
    }

    public List<Like> getLikesDB(){return new Like().getLikesDB();}

    public List<Book> getBooksUserLike(){
        return new Book().getBooksUserLike(userLogged);
    }

    public BookDTO getBookDTOById(int idBook){
        return new BookDTO().getBookDTOById(idBook);
    }

    public boolean newUser(String username, String password, String email){
        return new User().insertar("(username,password,email) values (?,?,?)", username, password, email);
    }

    public boolean deleteUserById(int idUser) {
        return new User().eliminar("idUser=?", idUser);
    }

    public boolean editUsernameUser(int idUser, String newData) {
        return new User().modificar("username = ? WHERE idUser = ?", newData, idUser);
    }

    public boolean editPasswordUser(int idUser, String newData) {
        return new User().modificar("password = ? WHERE idUser = ?", newData, idUser);
    }

    public boolean newBook(String title, String author, String description, String fileName){
        return new Book().insertar("(title,author,description,idUser,imageSource) values (?,?,?,?,?)", title, author, description, userLogged.getId(), fileName);
    }

    public boolean deleteBookById(int idBook) {
        return new Book().eliminar("idBook=?", idBook);
    }

    public boolean editTitleBook(int idBook, String newData) {
        return new Book().modificar("title = ? WHERE idBook = ?", newData, idBook);
    }

    public boolean editAuthorBook(int idBook, String newData) {
        return new Book().modificar("author = ? WHERE idBook = ?", newData, idBook);
    }

    public boolean editDescriptionBook(int idBook, String newData) {
        return new Book().modificar("description = ? WHERE idBook = ?", newData, idBook);
    }

    public boolean newLike(int idBook){
        return new Like().insertar("(idUser,idBook) values (?,?)", userLogged.getId(), idBook);
    }

    public boolean deleteLikeById(int idBook){return new Like().eliminar("idUser=? and idBook=?",userLogged.getId(),idBook);}

    public Long getAllLikesOfBookById(int idBookDTO){
        return new Like().getAllLikesOfBookById(idBookDTO);
    }

    public boolean isBookLikedByUser(int idBook){return new Like().isBookLikedByUser(userLogged.getId(), idBook);}

    public User getUserById(int idUser){
        return new User().getUserById(idUser);
    }

    public List<Comment> getCommentsByIdBookDTO(int idBook){
        return new Comment().getCommentsByIdBookDTO(idBook);
    }
}

