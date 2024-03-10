package Servlets;

import java.io.*;
import java.sql.Connection;
import java.util.List;

import com.ceica.booklikes.Controller.AppController;
import com.ceica.booklikes.modelos.BookDTO;
import com.ceica.booklikes.modelos.ModeloBase;
import com.ceica.booklikes.modelos.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "editBookServlet", value ="/editBook")
public class EditBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AppController appController = new AppController();
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String description = request.getParameter("description");
        appController.editTitleBook(id,title);
        appController.editAuthorBook(id,author);
        appController.editDescriptionBook(id,description);
        response.sendRedirect("myBooks");
    }
}