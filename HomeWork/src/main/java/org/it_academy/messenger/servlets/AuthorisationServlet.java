package org.it_academy.messenger.servlets;

import org.it_academy.messenger.service.UserStorage;
import org.it_academy.messenger.service.api.IUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

@WebServlet(name ="AuthorisationServlet", urlPatterns = "/api/login")
public class AuthorisationServlet extends HttpServlet {

    private final IUserStorage storage;
    private static final String LOGIN_PARAM = "login";
    private static final String PASSWORD_PARAM = "password";

    public AuthorisationServlet() {
        storage = UserStorage.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String login = req.getParameter(LOGIN_PARAM);
        String password = req.getParameter(PASSWORD_PARAM);

        try {
            if (storage.check(login, password)) {
                HttpSession session = req.getSession();
                session.setAttribute("user", storage.get(login));
            }

        }catch (IllegalArgumentException e) {
            resp.sendRedirect(req.getContextPath() + "/ui/signIn?error=" + URLEncoder.encode(e.getMessage(), Charset.defaultCharset()));
            return;
        }

        resp.sendRedirect(req.getContextPath() + "/ui");
        return;
    }
}
