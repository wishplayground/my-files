package lk.ijse.dep11.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "customerServelet", urlPatterns = {"/customers","/clients"})
public class CustomerSevelet extends HttpServlet {

    static {
        System.out.println("Custemer servelet has initilized" + Thread.currentThread().getName());
    }
    public CustomerSevelet(){
        System.out.println("Customer Sevelet" + Thread.currentThread().getName());
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init(ServeletConfig)" + Thread.currentThread().getName());
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Init()" + Thread.currentThread().getName());
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service(HttpServletRequest req, HttpServletResponse resp)" + Thread.currentThread().getName());
        super.service(req, resp);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service(ServletRequest req, ServletResponse res)" + Thread.currentThread().getName());
        super.service(req, res);
    }

    @Override
    public void destroy() {
        System.out.println("distroy" + Thread.currentThread().getName());
        super.destroy();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize" + Thread.currentThread().getName());
        super.finalize();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Customer Servelet</h1>");
        resp.getWriter().println("Context path: " + req.getContextPath());
        resp.getWriter().println("Servelet Path: " + req.getServletPath());
        resp.getWriter().println("Path info: " + req.getPathInfo());
    }
}
