package lk.ijse.dep11.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ItemServelet", urlPatterns = {"/items/*","*.pdf","/clients/*"})
public class ItemServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>Item Servelet</h1>");
        response.getWriter().println("Context path: " + request.getContextPath());
        response.getWriter().println("Servelet Path: " + request.getServletPath());
        response.getWriter().println("Path info: " + request.getPathInfo());
    }
}
