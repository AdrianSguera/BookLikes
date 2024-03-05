package com.ceica.booklikes.Controller;

import com.ceica.booklikes.modelos.Favorito;
import com.ceica.booklikes.modelos.Libro;
import com.ceica.booklikes.modelos.Usuario;

import java.util.List;

public class AppController {
    public AppController() {
    }

    public List<Usuario> getUsuariosBD() {
        return Usuario.getUsuariosBD();
    }

    public List<Libro> getLibrosBD() {
        return Libro.getLibrosBD();
    }

    public List<Libro> getLibrosByUser(Usuario usuario) {
        return new Libro().getByUser(usuario);
    }
    public int countLibrosByUser(int idUser){
        return new Favorito().getFavoritoByUser(idUser).size();
    }
    public List<Libro> getLibrosUserLike(int idUsuario){
        return new Libro().getByUserLike(idUsuario);
    }
    public boolean isLoged(String usu, String pass) {
        return Usuario.login(usu, pass);
    }
    public Libro getLibroByTitulo(String titulo){
        return new Libro().getLibroByTitulo(titulo).get(0);
    }
}
