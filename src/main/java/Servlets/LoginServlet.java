package Servlets;

import com.ceica.booklikes.Controller.AppController;
import com.ceica.booklikes.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().invalidate();
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        AppController controller = new AppController();
        String user = request.getParameter("username");
        String password = request.getParameter("password");
        try {
        if (controller.isLoged(user,password)){
            HttpSession session = request.getSession();
            session.setAttribute("user", controller.getUsuarioLogeado());
            response.sendRedirect("loged");
        } else {
            request.setAttribute("message", "Usuario o Contraseña incorrectos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }catch (Exception e){
        request.setAttribute("message", "Usuario o Contraseña incorrectos");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    }
}
