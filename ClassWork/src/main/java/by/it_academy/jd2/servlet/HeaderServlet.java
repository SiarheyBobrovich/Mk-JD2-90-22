package by.it_academy.jd2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "HeaderServlet", urlPatterns = "/header")
public class HeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/http; charset=UTF-8");

        resp.getWriter().append(req.getHeader("User-agent") + "\n");
        resp.getWriter().append(req.getHeader("Accept")  + "\n");
        resp.getWriter().append(req.getHeader("Accept-charset")  + "\n");
        resp.getWriter().append(req.getHeader("Accept-Language")  + "\n");
        resp.getWriter().append(req.getHeader("Host")  + "\n");
        resp.getWriter().append(req.getHeader("Referer")  + "\n");
        resp.getWriter().append(req.getHeader("ARRAY_NAME_PARAM")  + "\n");
    }
}
