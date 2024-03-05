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
    public int countLibrosByUser(Usuario usuario){
        return new Favorito().getFavoritoByUser(usuario).size();
    }
    public List<Libro> getLibrosUserLike(Usuario usuario){
        return new Libro().getByUserLike(usuario);
    }
    public boolean isLoged(String usu, String pass) {
        return Usuario.login(usu, pass);
    }
    public Libro getLibroByTitulo(String titulo){
        return new Libro().getLibroByTitulo(titulo).get(0);
    }
}
