package com.ceica.booklikes.modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Usuario extends ModeloBase {
    private int id;
    private String username, password;
    private LocalDate fechaAlta;

    public Usuario() {
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public static List<Usuario> getUsuariosBD() {
        List<Usuario> userList = new ArrayList<>();
        List<Object> objectList = new Usuario().leerTodos("select * from usuarios");
        for (Object obj : objectList) {
            Object[] objects = (Object[]) obj;
            Usuario user = new Usuario();
            user.setId((int) objects[0]);
            user.setUsername((String) objects[1]);
            user.setPassword((String) objects[2]);
            userList.add(user);
        }
        return userList;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fechaAlta=" + fechaAlta +
                '}';
    }

    @Override
    protected String getNombreTabla() {
        return "usuarios";
    }

    public static boolean login(String usu, String pass) {
        List<Usuario> userList = Usuario.getUsuariosBD();
        Optional<Usuario> userOptional = userList.stream()
                .filter(user -> usu.equals(user.getUsername()) && pass.equals(user.getPassword()))
                .findFirst();
        return userOptional.isPresent();
    }
}

