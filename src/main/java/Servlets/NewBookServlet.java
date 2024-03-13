package Servlets;

import com.ceica.booklikes.Controller.AppController;
import com.ceica.booklikes.modelos.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.nio.file.Paths;

@WebServlet(name = "newBookServlet", value = "/newBook")
public class NewBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AppController appController = new AppController();
        appController.setUserLogged((User) request.getSession().getAttribute("userLogged"));

        Part titlePart = request.getPart("title");
        String title = convertPartToString(titlePart);

        Part authorPart = request.getPart("author");
        String author = convertPartToString(authorPart);

        Part descriptionPart = request.getPart("description");
        String description = convertPartToString(descriptionPart);

        Part filePart = request.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        saveImageInServer(filePart, fileName);
        appController.newBook(title, author, description, fileName);
        response.sendRedirect("myBooks");
    }

    private void saveImageInServer(Part filePart, String fileName) throws IOException {
        // Especifica la ubicación de almacenamiento en Tomcat
        String tomcatUploadPath = System.getProperty("user.dir") + "/../webapps/BookLikes_war/assets/images";

        // Especifica la ubicación de almacenamiento en el repositorio local del proyecto
        String localRepoPath = System.getProperty("user.home") + "/IdeaProjects/BookLikes/src/main/webapp/assets/images";

        // Lee el contenido del archivo
        InputStream fileContent = filePart.getInputStream();

        // Escribe el contenido en un archivo en Tomcat
        OutputStream tomcatOutputStream = new FileOutputStream(new File(tomcatUploadPath, fileName));
        int read = 0;
        byte[] bytes = new byte[1024];
        while ((read = fileContent.read(bytes)) != -1) {
            tomcatOutputStream.write(bytes, 0, read);
        }
        tomcatOutputStream.close();
        fileContent.close(); // Cerrar el InputStream

        // Crear una copia de la imagen en el repositorio local del proyecto
        InputStream fileContentCopy = filePart.getInputStream();
        OutputStream localRepoOutputStream = new FileOutputStream(new File(localRepoPath, fileName));
        while ((read = fileContentCopy.read(bytes)) != -1) {
            localRepoOutputStream.write(bytes, 0, read);
        }
        localRepoOutputStream.close();
        fileContentCopy.close(); // Cerrar el InputStream
    }


    private String convertPartToString(Part part) throws IOException {
        if (part != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } else {
            return null;
        }
    }

}