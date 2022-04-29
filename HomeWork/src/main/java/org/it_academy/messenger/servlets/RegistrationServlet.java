package org.it_academy.messenger.servlets;

import org.it_academy.messenger.service.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="RegistrationServlet", urlPatterns = "/api/user")
public class RegistrationServlet extends HttpServlet {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String THIRD_NAME = "thirdName";
    private static final String BIRTHDAY = "birthday";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String login = req.getParameter(LOGIN);
        String pass = req.getParameter(PASSWORD);
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        String thirdName = req.getParameter(THIRD_NAME);
        String birthday = req.getParameter(BIRTHDAY);

        try {
            UserStorage.getInstance().save(login, pass, firstName, lastName, thirdName, birthday);

        }catch (IllegalArgumentException e) {
            resp.sendRedirect(req.getContextPath() + "/ui/signUp.jsp?error="+ e.getMessage());
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/ui" + "?message=You've successfully registered.");
        return;
    }
}
