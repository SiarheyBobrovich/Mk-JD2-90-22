package it_academy.org.messenger.servlets;

import it_academy.org.messenger.core.dto.User;
import it_academy.org.messenger.service.UserStorage;
import it_academy.org.messenger.service.api.IUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name ="AuthorisationServlet", urlPatterns = "/api/login")
public class AuthorisationServlet extends HttpServlet {

    private final IUserStorage<User> storage;
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
            resp.sendError(400, e.getMessage());
            return;
        }
    }
}
