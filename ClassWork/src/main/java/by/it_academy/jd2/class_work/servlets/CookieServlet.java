package by.it_academy.jd2.class_work.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cookie", urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        Cookie firstNameCookie = null;
        Cookie lastNameCookie = null;

        resp.setContentType("text/html; charset=UTF-8");

        if (firstName != null) {
            firstNameCookie = new Cookie("firstName", firstName);
            firstNameCookie.setMaxAge(600);

        }else {
            resp.getWriter().append("<p>Введите имя!</p>");
        }

        String lastName = req.getParameter("lastName");

        if (lastName != null) {
            lastNameCookie = new Cookie("lastName", lastName);
            lastNameCookie.setMaxAge(600);

        }else {
            resp.getWriter().append("<p>Введите фамилию!</p>");
        }
        if (firstName != null && lastName != null) {
            resp.addCookie(firstNameCookie);
            resp.addCookie(lastNameCookie);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        String firstName = null;
        String lastName = null;

        if (cookies != null) {

            for (Cookie c : cookies) {

                if (c.getName().equals("firstName")) {
                    firstName = c.getValue();
                }
                if (c.getName().equals("lastName")) {
                    lastName = c.getValue();
                }
            }
        }

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        if (firstName == null || lastName == null) {
            writer.append("Не найдена имя и фамилия!");

        }else {

            resp.setContentType("text/html; charset=UTF-8");
            writer.append("Привет ")
                    .append(firstName)
                    .append(" ")
                    .append(lastName);
        }
    }
}
