package com.ceica.booklikes.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Book extends ModeloBase{
    private int id, idUser;
    private String title, description, author, imageSource;
    private LocalDateTime creationDate;

    public Book() {
    }

    public Book(int idUser, String title, String description, String author, String imageSource) {
        this.idUser = idUser;
        this.title = title;
        this.description = description;
        this.author = author;
        this.imageSource = imageSource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public String getCreationDate() {
        return dateFormatter(creationDate);
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public static List<Book> getBooksDB() {
        List<Book> bookList = new ArrayList<>();
        List<Object> objectList = new Book().leerTodos("select * from books");
        return getBooks(bookList, objectList);
    }

    public List<Book> getBooksUserLike(User user) {
        List<Book> bookList = new ArrayList<>();
        List<Object> objectList = new Book().leerTodos("select books.idBook, books.title, books.author, books.description, books.creationDate, books.imageSource, books.idUser from likes\n" +
                "inner join books on likes.idBook = books.idBook\n" +
                "inner join users on users.idUser = likes.idUser\n" +
                "where likes.idUser =" + user.getId());
        return getBooks(bookList, objectList);
    }

    private static List<Book> getBooks(List<Book> bookList, List<Object> objectList) {
        for (Object obj : objectList) {
            Object[] objects = (Object[]) obj;
            Book book = new Book();
            book.setId((int) objects[0]);
            book.setTitle((String) objects[1]);
            book.setAuthor((String) objects[2]);
            book.setDescription((String) objects[3]);
            book.setCreationDate((LocalDateTime) objects[4]);
            book.setImageSource((String) objects[5]);
            book.setIdUser((int) objects[6]);
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    protected String getNombreTabla() {
        return "books";
    }
}
