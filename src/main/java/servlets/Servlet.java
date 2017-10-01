package servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 01.10.2017.
 */

@WebServlet(name = "hello", urlPatterns = "/hello")
public class Servlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        System.out.println("init config");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        request.setAttribute("name", name);
        request.getRequestDispatcher("hello.jsp").forward(request, response);
    }
}
