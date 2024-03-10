package Servlets;

import java.io.*;
import java.sql.Connection;
import java.util.List;

import com.ceica.booklikes.Controller.AppController;
import com.ceica.booklikes.modelos.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "commentServlet", value = "/comment")
public class CommentServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AppController appController = new AppController();
        int idBook = Integer.parseInt(request.getParameter("idBook"));
        List<Comment> commentList = appController.getCommentsByIdBookDTO(idBook);
        BookDTO bookDTO = appController.getBookDTOById(idBook);
        request.setAttribute("bookDTO",bookDTO);
        request.setAttribute("commentList",commentList);
        request.setAttribute("appController",appController);
        request.getRequestDispatcher("comment.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}