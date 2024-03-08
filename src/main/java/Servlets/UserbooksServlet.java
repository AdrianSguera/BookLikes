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
import java.io.PrintWriter;
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
        AppController appcontroller = new AppController();
        Usuario user = (Usuario) request.getSession().getAttribute("user");
        if (request.getParameter("idlibro")!=null){
            int idlibro = Integer.parseInt(request.getParameter("idlibro"));
            List<Integer> favoritos =  appcontroller.getFavoritosLibro(idlibro);
            if (!favoritos.isEmpty()){
                for (int i = 0; i < favoritos.size(); i++) {
                    appcontroller.deleteFavoritoById(favoritos.get(i),idlibro);
                }
            }
            appcontroller.deleteLibroById(idlibro);
            List<Libro> libros = appcontroller.getLibrosByUser(user);
            StringBuilder tbody = new StringBuilder();
            for (Libro libro : libros) {
                tbody.append("<tr><td>").append(libro.getId()).append("</td>")
                        .append("<td>").append(libro.getTitulo()).append("</td>")
                        .append("<td>").append(libro.getDescripcion()).append("</td>")
                        .append("<td>").append(libro.getAutor()).append("</td>")
                        .append("<td><a href=\"edit?titulo=").append(libro.getTitulo()).append("\">")
                        .append("<i class=\"fa-regular fa-pen-to-square\" style=\"\"></i></a>")
                        .append("<i class=\"fa-solid fa-trash\" onClick=\"borrar(").append(libro.getId()).append(")\" style=\"margin-left: 10px;\"></i>")
                        .append("</td></tr>");

                ;
            }
            if (libros.isEmpty()) {
                tbody.append("<tr><td colspan=\"5\">No hay libros</td></tr>");
            }
            PrintWriter out =response.getWriter();
            out.write(tbody.toString());
        }else {
            AppController appController = new AppController();
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");
            String autor = request.getParameter("autor");
            appController.newLibro(titulo, autor, descripcion, user.getId());
            List<Libro> libros = appController.getLibrosByUser(user);
            request.setAttribute("libroscreados", libros);
            response.sendRedirect("mybooks");
        }
    }

}
