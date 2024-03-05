package Servlets;

import com.ceica.booklikes.Controller.AppController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        AppController controller = new AppController();
        String user = request.getParameter("username");
        String password = request.getParameter("password");
        if (controller.isLoged(user,password)){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("pass",password);
        }
    }
}
