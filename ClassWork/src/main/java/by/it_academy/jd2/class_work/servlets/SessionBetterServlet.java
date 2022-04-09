package by.it_academy.jd2.class_work.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Session2", urlPatterns = "/session2")
public class SessionBetterServlet extends HttpServlet {

    private final String LAST_NAME = "lastName";
    private final String FIRST_NAME = "firstName";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();

        String firstName, lastName;

        if ((firstName = req.getParameter(FIRST_NAME)) == null ||
                (lastName = req.getParameter(LAST_NAME)) == null) {

            firstName = (String) session.getAttribute(FIRST_NAME);
            lastName = (String) session.getAttribute(LAST_NAME);
        }

        if (firstName != null && lastName != null) {
            session.setAttribute(FIRST_NAME, firstName);
            session.setAttribute(LAST_NAME, lastName);
        }else {
            throw new IllegalArgumentException("Вы не идентифицированы");
        }

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.write("<p>Hello " + firstName + " " + lastName + "</p>");
    }
}