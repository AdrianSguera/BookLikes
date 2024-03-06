package Servlets;

import com.ceica.booklikes.Controller.AppController;
import com.ceica.booklikes.modelos.Libro;
import com.ceica.booklikes.modelos.LibroFav;
import com.ceica.booklikes.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet (name = "LogedServlet", value = "/loged")
public class LogedServlet extends HttpServlet {
    AppController controller = new AppController();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Usuario user = (Usuario) request.getSession().getAttribute("user");
        List<LibroFav> libros = controller.getFavoritosByLibro();
        request.setAttribute("libros",libros);
        List<Libro> favLibrosByUser = controller.getLibrosUserLike(user);
        request.setAttribute("favLibrosByUser",favLibrosByUser);
        request.getRequestDispatcher("loged.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{

    }
}
