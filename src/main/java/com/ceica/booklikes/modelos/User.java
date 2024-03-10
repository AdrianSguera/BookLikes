package com.ceica.booklikes.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class User extends ModeloBase {
    private int id;
    private String username, password, email;
    private LocalDateTime creationDate;

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreationDate() {
        return dateFormatter(creationDate);
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public static List<User> getUsersDB() {
        List<User> userList = new ArrayList<>();
        List<Object> objectList = new User().leerTodos("select * from users");
        return getUser((List<User>) userList, objectList);
    }

    @Override
    protected String getNombreTabla() {
        return "users";
    }

    public static User login(String userOrEmail, String pass) {
        List<User> userList = User.getUsersDB();
        Optional<User> userOptional = userList.stream()
                .filter(user -> userOrEmail.equals(user.getUsername()) || userOrEmail.equals(user.getEmail()) && pass.equals(user.getPassword()))
                .findFirst();
        return userOptional.orElse(null);
    }

    public User getUserById(int idUser) {
        List<User> userList = new ArrayList<>();
        List<Object> objectList = new User().leerTodos("select * from users where idUser = " + idUser);
        return getUser(userList, objectList).get(0);
    }

    private static List<User> getUser(List<User> userList, List<Object> objectList) {
        for (Object obj : objectList) {
            Object[] objects = (Object[]) obj;
            User user = new User();
            user.setId((int) objects[0]);
            user.setUsername((String) objects[1]);
            user.setPassword((String) objects[2]);
            user.setEmail((String) objects[3]);
            user.setCreationDate((LocalDateTime) objects[4]);
            userList.add(user);
        }
        return userList;
    }
}

