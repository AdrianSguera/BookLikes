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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AppController appcontroller = new AppController();
        Usuario user = (Usuario) request.getSession().getAttribute("user");
        List<LibroFav> libros = appcontroller.getFavoritosByLibro();
        request.setAttribute("libros",libros);
        List<Libro> favLibrosByUser = appcontroller.getLibrosUserLike(user);
        request.setAttribute("favLibrosByUser",favLibrosByUser);
        int iduser = user.getId();
        request.setAttribute("iduser",iduser);
        request.getRequestDispatcher("loged.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        AppController appcontroller = new AppController();
        Usuario usuario = (Usuario) request.getSession().getAttribute("user");
        if (request.getParameter("idlibro")!=null&&request.getParameter("idUser")!=null){
            int idlibro = Integer.parseInt(request.getParameter("idlibro"));
            int iduser = Integer.parseInt(request.getParameter("idUser"));
            try {
                appcontroller.newFavorito(iduser,idlibro);
            }catch (Exception ignored){
            }
            response.getWriter().write(getAllLibrosTableHTML(appcontroller, request));
        }
        else if (request.getParameter("idlibro")!=null&&request.getParameter("idUser")!=null&&request.getParameter("titulo")!=null) {
            int idlibro = Integer.parseInt(request.getParameter("idlibro"));
            int iduser = Integer.parseInt(request.getParameter("idUser"));
            try {
                appcontroller.deleteFavoritoById(iduser, idlibro);
            } catch (Exception ignored) {
            }
            response.getWriter().write(getLibrosTableHTML(appcontroller, request, usuario));
        }else {
            String titulo = request.getParameter("titulo");
            String autor = request.getParameter("autor");
            String descripcion = request.getParameter("descripcion");
            appcontroller.newLibro(titulo,autor,descripcion,usuario.getId());
            response.sendRedirect("loged");
        }
    }

    public String getAllLibrosTableHTML(AppController appController, HttpServletRequest request) {

        List<LibroFav> libroFavList = appController.getFavoritosByLibro();

        StringBuilder tablaHTML = new StringBuilder();

        if (!libroFavList.isEmpty()){
            for (LibroFav libro : libroFavList) {
                tablaHTML.append("<tr>")
                        .append("<td>").append(libro.getId()).append("</td>")
                        .append("<td>").append(libro.getTitulo()).append("</td>")
                        .append("<td>").append(libro.getDescripcion()).append("</td>")
                        .append("<td>").append(libro.getAutor()).append("</td>")
                        .append("<td>")
                        .append(libro.getFavoritos())
                        .append("<i class=\"fa-regular fa-star\" onclick=\"newfavorito(")
                        .append(libro.getId()).append(", ").append(request.getAttribute("iduser")).append(")\"></i>")
                        .append("</td>")
                        .append("</tr>");
            }
        } else
            tablaHTML.append("<tr><td colspan=\"5\">No hay libros</td></tr>");

        return tablaHTML.toString();
    }
    public String getLibrosTableHTML(AppController appController, HttpServletRequest request, Usuario user) {

        List<Libro> libroList = appController.getLibrosByUser(user);

        StringBuilder tablaHTML = new StringBuilder();

        if (!libroList.isEmpty()){
            for (Libro libro : libroList) {
                tablaHTML.append("<tr>")
                        .append("<td>").append(libro.getId()).append("</td>")
                        .append("<td>").append(libro.getTitulo()).append("</td>")
                        .append("<td>").append(libro.getDescripcion()).append("</td>")
                        .append("<td>").append(libro.getAutor()).append("</td>")
                        .append("<td>")
                        .append("<i class=\"fa-regular fa-star\" onclick=\"deletefavorito(")
                        .append(libro.getId()).append(", ").append(request.getAttribute("iduser")).append(libro.getTitulo()).append(")\"></i>")
                        .append("</td>")
                        .append("</tr>");
            }
        } else
            tablaHTML.append("<tr><td colspan=\"5\">No hay libros</td></tr>");

        return tablaHTML.toString();
    }
}
