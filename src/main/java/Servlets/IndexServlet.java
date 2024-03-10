package Servlets;

import java.io.*;
import java.sql.Connection;
import java.util.List;

import com.ceica.booklikes.Controller.AppController;
import com.ceica.booklikes.modelos.BookDTO;
import com.ceica.booklikes.modelos.ModeloBase;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "indexServlet", value ="")
public class IndexServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection connection = ModeloBase.getConnection();
        AppController appController = new AppController();
        List<BookDTO> bookDTOList = appController.getBookDTOsDB();
        request.setAttribute("bookDTOList",bookDTOList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}