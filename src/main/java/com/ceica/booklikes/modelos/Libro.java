package com.ceica.booklikes.modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Libro extends ModeloBase{
    private int id, idUsusario;
    private String titulo, descripcion, autor;
    private LocalDate fechaCreacion;

    public Libro() {
    }

    public Libro(String titulo, String descripcion, String autor) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public static List<Libro> getLibrosBD() {
        List<Libro> libroList = new ArrayList<>();
        List<Object> objectList = new Libro().leerTodos("select * from libros");
        return getLibros(libroList, objectList);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", idUsusario=" + idUsusario +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
    public List<Libro> getByUser(Usuario usuario) {
        List<Libro> libroList = Libro.getLibrosBD();
        return libroList.stream()
                .filter(libro-> libro.getIdUsusario() == usuario.getId())
                .collect(Collectors.toList());
    }

    public List<Libro> getByUserLike(int idUsusario) {
        List<Libro> libroList = new ArrayList<>();
        List<Object> objectList = new Libro().leerTodos("select libros.idLibros, libros.titulo, libros.autor, libros.descripcion, libros.FechaCreacion, libros.idUsuarios from favoritos\n" +
                "inner join libros on favoritos.idLibros = libros.idLibros\n" +
                "inner join usuarios on usuarios.idUsuarios = favoritos.idUsuarios\n" +
                "where favoritos.idUsuarios =" + idUsusario);
        return getLibros(libroList, objectList);
    }

    private static List<Libro> getLibros(List<Libro> libroList, List<Object> objectList) {
        for (Object obj : objectList) {
            Object[] objects = (Object[]) obj;
            Libro libro = new Libro();
            libro.setId((int) objects[0]);
            libro.setTitulo((String) objects[1]);
            libro.setAutor((String) objects[2]);
            libro.setDescripcion((String) objects[3]);
            libro.setFechaCreacion((LocalDate) objects[4]);
            libro.setIdUsusario((int) objects[5]);
            libroList.add(libro);
        }
        return libroList;
    }

    @Override
    protected String getNombreTabla() {
        return "libros";
    }

    public List<Libro> getLibroByTitulo(String titulo) {
        List<Libro> libroList = new ArrayList<>();
        List<Object> objectList = new Libro().leerTodos("select * from libros where titulo like '" + titulo + "'");
        return getLibros(libroList, objectList);
    }
}
