package com.ceica.booklikes;

import java.io.*;

import com.ceica.booklikes.Controller.AppController;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        AppController appController = new AppController();

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + appController.getLibroByTitulo("titulo3") + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}