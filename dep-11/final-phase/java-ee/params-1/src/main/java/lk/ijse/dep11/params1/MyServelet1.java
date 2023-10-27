package lk.ijse.dep11.params1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello1",initParams = {
                                                    @WebInitParam(name="app.username",value = "root"),
                                                    @WebInitParam(name = "app.password",value = "1234")})
public class MyServelet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>MyServelet1</h1>");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("MyServlet1");
        System.out.println("ServletConfig: "+getServletConfig());
        System.out.println("ServletConfig: "+getServletConfig().getServletContext());
        System.out.println("Context Parameter");
        System.out.println("app.name"+getServletConfig().getInitParameter("app.name"));
        System.out.println("dep.batch"+getServletConfig().getInitParameter("dep.batch"));

    }
}
