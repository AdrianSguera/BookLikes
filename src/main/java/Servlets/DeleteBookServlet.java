package Servlets;

import java.io.*;
import java.sql.Connection;
import java.util.List;

import com.ceica.booklikes.Controller.AppController;
import com.ceica.booklikes.modelos.BookDTO;
import com.ceica.booklikes.modelos.Like;
import com.ceica.booklikes.modelos.ModeloBase;
import com.ceica.booklikes.modelos.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "deleteBookServlet", value = "/deleteBook")
public class DeleteBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AppController appController = new AppController();
        appController.setUserLogged((User) request.getSession().getAttribute("userLogged"));
        int id = Integer.parseInt(request.getParameter("idBookDTO"));
        BookDTO bookDTO = appController.getBookDTOById(id);
        deleteImage(bookDTO.getImageSource());
        appController.deleteBookById(id);
        response.getWriter().write(createBookDiv(appController));
    }

    private String createBookDiv(AppController appController) {
        List<BookDTO> bookDTOList = appController.getBookDTOsByUser();
        List<Like> likeList = appController.getLikesDB();
        StringBuilder divContent = new StringBuilder();
        if (!bookDTOList.isEmpty()) {
            for (BookDTO bookDTObyUser : bookDTOList) {
                divContent.append("<div class=\"card\">")
                        .append("<img src=\"assets/images/")
                        .append(bookDTObyUser.getImageSource()).append("\" class=\"card-img-top\" alt=\"")
                        .append(bookDTObyUser.getTitle()).append(" image\">")
                        .append("<div class=\"card-body\">")
                        .append("<h5 class=\"card-title\">").append(bookDTObyUser.getTitle()).append("</h5>")
                        .append("<p class=\"card-text\">Author: ").append(bookDTObyUser.getAuthor()).append("</p>")
                        .append("<p class=\"card-text\">Description: ").append(bookDTObyUser.getDescription()).append("</p>")
                        .append("<p id=\"likesManager").append(bookDTObyUser.getId()).append("\">")
                        .append(bookDTObyUser.getLikeCount());
                boolean liked = false;
                for (Like like : likeList) {
                    if (like.getIdUser() == appController.getUserLogged().getId() && like.getIdBook() == bookDTObyUser.getId()) {
                        liked = true;
                        break;
                    }
                }
                if (liked) {
                    divContent.append("<i onclick=\"manageLikes(").append(bookDTObyUser.getId())
                            .append(")\" class=\"fa-solid fa-heart\" style=\"color: red\"></i>");
                } else {
                    divContent.append("<i onclick=\"manageLikes(").append(bookDTObyUser.getId())
                            .append(")\" class=\"fa-solid fa-heart\"></i>");
                }
                divContent.append("</p>")
                        .append("<p>")
                        .append("<i onclick=\"showEditForm(").append(bookDTObyUser.getId())
                        .append(")\" class=\"fa-solid fa-file-pen\"></i>")
                        .append("<i onclick=\"deleteBook(").append(bookDTObyUser.getId())
                        .append(")\" class=\"fa-solid fa-trash\"></i>")
                        .append("</p>")
                        .append("</div>")
                        .append("</div>")
                        .append("<div id=\"modalContainer").append(bookDTObyUser.getId()).append("\" class=\"modal-container\">")
                        .append("<div id=\"editForm\" class=\"modal-content\">")
                        .append("<form method=\"post\" action=\"editBook\">")
                        .append("<input type=\"hidden\" name=\"id\" value=\"").append(bookDTObyUser.getId()).append("\">")
                        .append("<input type=\"text\" name=\"title\" value=\"").append(bookDTObyUser.getTitle()).append("\">")
                        .append("<input type=\"text\" name=\"author\" value=\"").append(bookDTObyUser.getAuthor()).append("\">")
                        .append("<input type=\"text\" name=\"description\" value=\"").append(bookDTObyUser.getDescription()).append("\">")
                        .append("<input onclick=\"hideEditForm(").append(bookDTObyUser.getId()).append(")\" type=\"submit\" value=\"Save\">")
                        .append("</form>")
                        .append("</div>")
                        .append("</div>");
            }
        } else {
            divContent.append("<p>No books created</p>");
        }
        return divContent.toString();
    }

    private void deleteImage(String fileName) {
        String serverPath = System.getProperty("user.dir") + "/../webapps/BookLikes_war/assets/images";
        String localPath = System.getProperty("user.home") + "/IdeaProjects/BookLikes/src/main/webapp/assets/images";
        File fileToDeleteServer = new File(serverPath, fileName);
        File fileToDeleteLocal = new File(localPath, fileName);
        fileToDeleteLocal.delete();
        fileToDeleteServer.delete();
    }
}