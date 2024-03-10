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

@WebServlet(name = "registerServlet", value ="/register")
public class RegisterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AppController appController = new AppController();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("passwordRepeat");
        String email = request.getParameter("email");
        if (password.equals(passwordRepeat)){
            if (appController.newUser(username,password,email))
                response.sendRedirect("login");
            else {
                request.setAttribute("errorMessage","There was an error. Please try again later");
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }
        } else {
            request.setAttribute("errorMessage","Check introduced passwords and try again");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }
}