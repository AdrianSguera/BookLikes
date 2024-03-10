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

@WebServlet(name = "myBooksServlet", value ="/myBooks")
public class MyBooksServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AppController appController = new AppController();
        User userLogged = (User) request.getSession().getAttribute("userLogged");
        appController.setUserLogged(userLogged);
        request.setAttribute("userLogged",userLogged);
        List<BookDTO> bookDTObyUserList = appController.getBookDTOsByUser();
        request.setAttribute("bookDTObyUserList",bookDTObyUserList);
        List<Like> likeList = appController.getLikesDB();
        Like like = new Like();
        request.setAttribute("like",like);
        request.setAttribute("likesList",likeList);
        request.getRequestDispatcher("myBooks.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }
}