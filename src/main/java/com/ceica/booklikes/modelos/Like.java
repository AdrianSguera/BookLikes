package com.ceica.booklikes.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Like extends ModeloBase{
    private int idUser, idBook;
    private LocalDateTime creationDate;

    public Like() {
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

    public String getCreationDate() {
        return dateFormatter(creationDate);
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<Like> getLikesDB() {
        List<Like> likeList = new ArrayList<>();
        List<Object> objectList = new Like().leerTodos("select * from likes");
        for (Object obj : objectList) {
            Object[] objects = (Object[]) obj;
            Like like = new Like();
            like.setIdUser((int) objects[0]);
            like.setIdBook((int) objects[1]);
            like.setCreationDate((LocalDateTime) objects[2]);
            likeList.add(like);
        }
        return likeList;
    }

    @Override
    protected String getNombreTabla() {
        return "likes";
    }

    public Long getAllLikesOfBookById(int idBook){
        List<Object> objectList = new Like().leerTodos("select count(idUser) from likes where idBook= " + idBook + " group by idBook");
        Long likeCount = 0L;
        for (Object obj : objectList) {
            Object[] objects = (Object[]) obj;
            likeCount = ((Long) objects[0]);
        }
        return likeCount;
    }

    public boolean isBookLikedByUser(int idUser, int idBook){
        List<Like> likeList = getLikesDB();
        return likeList.stream().anyMatch(like -> like.getIdUser() == idUser && like.getIdBook() == idBook);
    }
}
