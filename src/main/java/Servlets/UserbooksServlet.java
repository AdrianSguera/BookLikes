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

@WebServlet (name = "UserbooksServlet",value = "/mybooks")
public class UserbooksServlet extends HttpServlet {
    AppController controller = new AppController();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Usuario user = (Usuario) request.getSession().getAttribute("user");
        List<Libro> libros = controller.getLibrosByUser(user);
        request.setAttribute("libroscreados",libros);
        int iduser = user.getId();
        request.setAttribute("iduser",iduser);
        request.getRequestDispatcher("loged.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

    }
}
