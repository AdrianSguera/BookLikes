package com.ceica.booklikes.Controller;

import com.ceica.booklikes.modelos.Favorito;
import com.ceica.booklikes.modelos.Libro;
import com.ceica.booklikes.modelos.ModeloBase;
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

    public boolean newUsuario(String username, String password){
        return new Usuario().insertar("(username,password) values (?,?)", username, password);
    }
    public boolean deleteUsuarioById(int idUser) {
        return new Usuario().eliminar("iduser=?", idUser);
    }
    public boolean changeUsernameUsuario(int idUser, String dato) {
        return new Usuario().modificar("username = ? WHERE iduser = ?", dato, idUser);
    }

    public boolean changePasswordUsuario(String username, String dato) {
        return new Usuario().modificar("password = ? WHERE username = ?", dato, username);
    }
    public boolean newLibro(String titulo, String autor, String descripcion, int idUser){
        return new Libro().insertar("(titulo,autor,descripcion,idUser) values (?,?,?,?)", titulo, autor, descripcion, idUser);
    }
    public boolean deleteLibroById(int idLibro) {
        return new Libro().eliminar("idLibros=?", idLibro);
    }
    public boolean changeTituloLibro(String titulo, String dato) {
        return new Libro().modificar("titulo = ? WHERE idLibros = ?", dato, titulo);
    }
    public boolean changeAutorLibro(String autor, String dato) {
        return new Libro().modificar("autor = ? WHERE idLibros = ?", dato, autor);
    }
    public boolean changeDescripcionLibro(String descripcion, String dato) {
        return new Libro().modificar("descripcion = ? WHERE idLibros = ?", dato, descripcion);
    }
    public boolean newFavorito(int idUser, int idLibro){
        return new Favorito().insertar("(idUsuarios,idLibros) values (?,?)", idUser, idLibro);
    }
}
