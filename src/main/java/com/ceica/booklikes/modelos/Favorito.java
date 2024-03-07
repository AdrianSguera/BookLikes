package com.ceica.booklikes.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Favorito extends ModeloBase{
    private int id, idUsusario, idLibro;
    private LocalDateTime fechaFavorito;

    public Favorito() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsusario() {
        return idUsusario;
    }

    public void setIdUsusario(int idUsusario) {
        this.idUsusario = idUsusario;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public LocalDateTime getFechaFavorito() {
        return fechaFavorito;
    }

    public void setFechaFavorito(LocalDateTime fechaFavorito) {
        this.fechaFavorito = fechaFavorito;
    }

    public static List<Favorito> getFavoritosBD() {
        List<Favorito> favoritoList = new ArrayList<>();
        List<Object> objectList = new Favorito().leerTodos("select * from favoritos");
        for (Object obj : objectList) {
            Object[] objects = (Object[]) obj;
            Favorito favorito = new Favorito();
            favorito.setIdUsusario((int) objects[0]);
            favorito.setIdLibro((int) objects[1]);
            favorito.setFechaFavorito((LocalDateTime) objects[2]);
            favoritoList.add(favorito);
        }
        return favoritoList;
    }

    @Override
    public String toString() {
        return "Favorito{" +
                "id=" + id +
                ", idUsusario=" + idUsusario +
                ", idLibro=" + idLibro +
                ", fechaFavorito=" + fechaFavorito +
                '}';
    }

    public List<Favorito> getFavoritoByUser(Usuario usuario) {
        List<Favorito> favoritoList = Favorito.getFavoritosBD();
        return favoritoList.stream()
                .filter(favorito -> favorito.getIdUsusario() == usuario.getId())
                .collect(Collectors.toList());
    }

    @Override
    protected String getNombreTabla() {
        return "favoritos";
    }
}
