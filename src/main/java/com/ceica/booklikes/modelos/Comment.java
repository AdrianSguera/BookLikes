package com.ceica.booklikes.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Comment extends ModeloBase{

    private int id, idUser, idBook;

    private String comment;

    private LocalDateTime creationDate;

    public Comment() {
    }

    public Comment(int idUser, int idBook, String comment) {
        this.idUser = idUser;
        this.idBook = idBook;
        this.comment = comment;
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

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreationDate() {
        return dateFormatter(creationDate);
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    protected String getNombreTabla() {
        return "comments";
    }

    public List<Comment> getCommentsByIdBookDTO(int idBook){
        List<Comment> commentList = new ArrayList<>();
        List<Object> objectList = new Comment().leerTodos("select * from comments where idBook= " + idBook);
        return getBookDTOS(commentList, objectList);
    }

    private List<Comment> getBookDTOS(List<Comment> commentList, List<Object> objectList) {
        for (Object obj : objectList) {
            Object[] objects = (Object[]) obj;
            Comment comment = new Comment();
            comment.setId((int) objects[0]);
            comment.setComment((String) objects[1]);
            comment.setIdUser((int) objects[2]);
            comment.setIdBook((int) objects[3]);
            comment.setCreationDate((LocalDateTime) objects[4]);
            commentList.add(comment);
        }
        return commentList;
    }
}
