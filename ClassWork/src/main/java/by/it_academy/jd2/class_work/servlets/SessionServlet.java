package by.it_academy.jd2.class_work.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "Session", urlPatterns = "/session")
public class SessionServlet extends HttpServlet {

    private final String LAST_NAME = "lastName";
    private final String FIRST_NAME = "firstName";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();

        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);

        if (firstName != null && lastName != null) {
            session.setAttribute(FIRST_NAME, firstName);
            session.setAttribute(LAST_NAME, lastName);

        }else {
            firstName = (String)session.getAttribute(FIRST_NAME);
            lastName = (String) session.getAttribute(LAST_NAME);
        }

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        if (firstName != null && lastName != null) {
            writer.write("<p>Hello " + firstName + " " + lastName + "</p>");
        }else {
            throw new IllegalArgumentException("Вы не идентифицированы");
        }
    }
}