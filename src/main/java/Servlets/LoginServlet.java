package Servlets;

import java.io.*;
import java.sql.Connection;
import java.util.List;

import com.ceica.booklikes.Controller.AppController;
import com.ceica.booklikes.modelos.BookDTO;
import com.ceica.booklikes.modelos.ModeloBase;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value ="/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        session.invalidate();
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AppController appController = new AppController();
        if (appController.Login(request.getParameter("usernameOrEmail"), request.getParameter("password"))) {
            HttpSession session = request.getSession();
            session.setAttribute("userLogged",appController.getUserLogged());
            response.sendRedirect("loggedUser");
        } else {
            request.setAttribute("errorMessage","Incorrect user or password");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}