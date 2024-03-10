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

@WebServlet(name = "loggedUserServlet", value ="/loggedUser")
public class LoggedUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AppController appController = new AppController();
        User user = ((User) request.getSession().getAttribute("userLogged"));
        appController.setUserLogged(user);
        List<BookDTO> bookDTOList = appController.getBookDTOsDB();
        request.setAttribute("bookDTOList",bookDTOList);
        List<Like> likeList = appController.getLikesDB();
        Like like = new Like();
        request.setAttribute("like",like);
        request.setAttribute("likesList",likeList);
        request.setAttribute("user",user);
        request.setAttribute("appController",appController);
        request.getRequestDispatcher("loggedUser.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }
}