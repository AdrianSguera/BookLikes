package Servlets;

import com.ceica.booklikes.Controller.AppController;
import com.ceica.booklikes.modelos.Libro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "NologServlet", value = "/nolog")
public class NologServlet extends HttpServlet {
AppController controller = new AppController();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Libro> libros = controller.getLibrosBD();
        request.setAttribute("libros",libros);
        request.getRequestDispatcher("nolog.jsp").forward(request, response);

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("nolog.jsp").forward(request, response);

    }
}
