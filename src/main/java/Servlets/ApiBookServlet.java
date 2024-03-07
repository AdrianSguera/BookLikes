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

@WebServlet (name = "ApiBookServlet",value = "/apibook")
public class ApiBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Usuario user = (Usuario) request.getSession().getAttribute("user");
        int idlibro = Integer.parseInt(request.getParameter("idlibro"));
        AppController controller = new AppController();
        List<Integer> favoritos =  controller.getFavoritosLibro(idlibro);
        if (!favoritos.isEmpty()){
            for (int i = 0; i < favoritos.size(); i++) {
                controller.deleteFavoritoById(favoritos.get(i),idlibro);
            }
        }
        controller.deleteLibroById(idlibro);
        List<Libro> libroList= controller.getLibrosByUser(user);
        request.setAttribute("libroscreados",libroList);
        request.getRequestDispatcher("userbooks.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
    }
