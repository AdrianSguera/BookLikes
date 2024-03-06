package com.ceica.booklikes.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LibroFav extends Libro {
    private Long favoritos;

    public LibroFav() {
    }

    public Long getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Long favoritos) {
        this.favoritos = favoritos;
    }

    @Override
    public String toString() {
        return "LibroFav{" +
                "favoritos=" + favoritos +
                '}';
    }

    public List<LibroFav> getFavoritosByLibro() {
        List<LibroFav> libroList = new ArrayList<>();
        List<Object> objectList = new Libro().leerTodos("select libros.idLibros, libros.titulo, libros.autor, libros.descripcion," +
                " libros.FechaCreacion, libros.idUsuarios, count(favoritos.idLibros) as favoritos from favoritos \n" +
                "inner join libros on libros.idLibros = favoritos.idLibros\n" +
                "group by favoritos.idLibros");
        for (Object obj : objectList) {
            Object[] objects = (Object[]) obj;
            LibroFav libro = new LibroFav();
            libro.setId((int) objects[0]);
            libro.setTitulo((String) objects[1]);
            libro.setAutor((String) objects[2]);
            libro.setDescripcion((String) objects[3]);
            libro.setFechaCreacion((LocalDateTime) objects[4]);
            libro.setIdUsusario((int) objects[5]);
            libro.setFavoritos((Long) objects[6]);
            libroList.add(libro);
        }
        return libroList;
    }
}