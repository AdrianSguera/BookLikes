package Servlets;

import com.ceica.booklikes.Controller.AppController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
AppController controller = new AppController();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String user = request.getParameter("username");
        String password = request.getParameter("password");
        if (user!= null & password!=null){
            controller.newUsuario(user,password);
            response.sendRedirect("login");
        }else {
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }
}
