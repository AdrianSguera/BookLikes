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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AppController controller = new AppController();
        Usuario user = (Usuario) request.getSession().getAttribute("user");
        List<Libro> libros = controller.getLibrosByUser(user);
        request.setAttribute("libroscreados",libros);
        int iduser = user.getId();
        request.setAttribute("iduser",iduser);
        request.getRequestDispatcher("userbooks.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        AppController appController = new AppController();
        Usuario user = (Usuario) request.getSession().getAttribute("user");
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String autor = request.getParameter("autor");
        appController.newLibro(titulo,autor,descripcion, user.getId());

        List<Libro> libros = appController.getLibrosByUser(user);
        request.setAttribute("libroscreados",libros);
        response.sendRedirect("mybooks");
    }
}
