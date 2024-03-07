package Servlets;

import com.ceica.booklikes.Controller.AppController;
import com.ceica.booklikes.modelos.Libro;
import com.ceica.booklikes.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet (name = "EditServlet",value = "/edit")
public class EditServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AppController controller = new AppController();
        Usuario user = (Usuario) request.getSession().getAttribute("user");

        int idlibro = Integer.parseInt(request.getParameter("idlibro"));
        Libro libro=controller.getLibrosById(idlibro);
        request.setAttribute("libro",libro);
        request.getRequestDispatcher("edit.jsp").forward(request,response);

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
        AppController controller = new AppController();
        int idlibro = Integer.parseInt(request.getParameter("idlibro"));
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String autor = request.getParameter("autor");
        controller.changeTituloLibro(idlibro,titulo);
        controller.changeDescripcionLibro(idlibro,descripcion);
        controller.changeAutorLibro(idlibro,autor);
        List<Libro> libros = controller.getLibrosByUser(user);
        request.setAttribute("libroscreados", libros);
        response.sendRedirect("mybooks");
    }
    }