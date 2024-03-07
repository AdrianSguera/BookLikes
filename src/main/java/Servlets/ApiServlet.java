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

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        Usuario user = (Usuario) request.getSession().getAttribute("user");
        try {
            int idlibro = Integer.parseInt(request.getParameter("idlibro"));
            int idusuario = user.getId();
            if (user == null) {
                response.setStatus(HttpServletResponse.SC_SEE_OTHER);
                response.setHeader("Location", "/login");
            } else {
                AppController controller = new AppController();
                controller.newFavorito(idusuario, idlibro);
            }
        }catch (Exception e){

        }
        try {
            int idfavorito = Integer.parseInt(request.getParameter("idfavorito"));
            int idusuario = user.getId();
            if (user==null){
                response.setStatus(HttpServletResponse.SC_SEE_OTHER);
                response.setHeader("Location", "/login");
            }else {
                AppController controller = new AppController();
                controller.deleteFavoritoById(idusuario,idfavorito);
            }
        }catch (Exception e2){

        }
    }
}
