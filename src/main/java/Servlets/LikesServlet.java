package Servlets;

import java.io.*;
import java.sql.Connection;
import java.util.List;

import com.ceica.booklikes.Controller.AppController;
import com.ceica.booklikes.modelos.BookDTO;
import com.ceica.booklikes.modelos.Like;
import com.ceica.booklikes.modelos.ModeloBase;
import com.ceica.booklikes.modelos.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "likesServlet", value = "/likes")
public class LikesServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AppController appController = new AppController();
        appController.setUserLogged((User) request.getSession().getAttribute("userLogged"));
        int idBookDTO = Integer.parseInt(request.getParameter("idBookDTO"));
        if (!appController.isBookLikedByUser(idBookDTO)) {
            appController.newLike(idBookDTO);
            response.getWriter().write(createRedLikeManagerHtml(appController, idBookDTO));
        } else {
            appController.deleteLikeById(idBookDTO);
            response.getWriter().write(createBlackLikeManagerHtml(appController, idBookDTO));
        }

    }

    private String createBlackLikeManagerHtml(AppController appController, int idBookDTO) {
        return appController.getAllLikesOfBookById(idBookDTO) +
                "<i onclick=\"manageLikes(" + idBookDTO + ")\" class=\"fa-solid fa-heart\"></i>";
    }

    private String createRedLikeManagerHtml(AppController appController, int idBookDTO) {
        return appController.getAllLikesOfBookById(idBookDTO) +
                "<i onclick=\"manageLikes(" + idBookDTO + ")\" class=\"fa-solid fa-heart\" style=\"color: red\"></i>";
    }
}