package Servlets;

import com.ceica.booklikes.Controller.AppController;
import com.ceica.booklikes.modelos.Usuario;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name = "ApiServlet",value = "/api")
public class ApiServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
        int idlibro = Integer.parseInt(request.getParameter("idlibro"));
        int idusuario = Integer.parseInt(request.getParameter("idusuario"));
        Usuario user = (Usuario) request.getSession().getAttribute("user");
        if (user==null){
            response.setStatus(HttpServletResponse.SC_SEE_OTHER);
            response.setHeader("Location", "/login");
        }else {
            AppController controller = new AppController();
            controller.newFavorito(idlibro,idusuario);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{

    }
}
