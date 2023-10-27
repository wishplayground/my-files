package lk.ijse.dep11.params;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("hello1"/*urlPatterns = "/hello1",initParams = {@WebInitParam(name="app.username",value = "root"),@WebInitParam(name = "app.password",value = "1234")}*/)
public class MyServelet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>MyServelet1</h1>");
    }
}
