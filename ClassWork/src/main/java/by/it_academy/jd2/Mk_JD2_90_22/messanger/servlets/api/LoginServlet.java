package by.it_academy.jd2.Mk_JD2_90_22.messanger.servlets.api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;


@WebServlet(name = "LoginServlet", urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        Random rnd = new Random();
        boolean ok = rnd.nextBoolean();

        String contextPath = req.getContextPath();
        if (ok) {
            resp.sendRedirect(contextPath + "/hello_with_name?firstName=ilya");
        } else {

            resp.sendRedirect(contextPath + "/ui/signIn");
        }


    }
}
