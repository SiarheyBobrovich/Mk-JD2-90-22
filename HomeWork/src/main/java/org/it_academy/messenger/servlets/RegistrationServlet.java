package org.it_academy.messenger.servlets;

import org.it_academy.messenger.core.dto.UserDto;
import org.it_academy.messenger.service.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

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

        UserDto user = UserDto.create()
                .setLogin(req.getParameter(LOGIN))
                .setPassword(req.getParameter(PASSWORD))
                .setFirstName(req.getParameter(FIRST_NAME))
                .setLastName(req.getParameter(LAST_NAME))
                .setThirdName(req.getParameter(THIRD_NAME))
                .setBirthday(req.getParameter(BIRTHDAY))
                .build();

        try {
            UserStorage.getInstance().save(user);

        }catch (IllegalArgumentException e) {
            resp.sendRedirect(req.getContextPath() + "/ui/signUp.jsp?error="+ URLEncoder.encode(e.getMessage(), Charset.defaultCharset()));
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/ui" + "?message=You've successfully registered.");
        return;
    }
}
