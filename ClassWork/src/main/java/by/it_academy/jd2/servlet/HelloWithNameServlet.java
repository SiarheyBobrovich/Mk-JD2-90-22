package by.it_academy.jd2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloWithNameServlet", urlPatterns = "/hello_with_name")
public class HelloWithNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");


        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().append("Hello ").append(lastName)
                .append(" ")
                .append(firstName)
        ;
    }
}
