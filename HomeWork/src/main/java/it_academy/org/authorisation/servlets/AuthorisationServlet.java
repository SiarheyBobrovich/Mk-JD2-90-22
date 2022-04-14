package it_academy.org.authorisation.servlets;

import it_academy.org.authorisation.dto.User;
import it_academy.org.authorisation.service.UserStorage;
import it_academy.org.authorisation.service.api.IStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name ="AuthorisationServlet", urlPatterns = "/api/login")
public class AuthorisationServlet extends HttpServlet {

    private final IStorage storage;

    public AuthorisationServlet() {
        storage = UserStorage.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try {
            if (storage.check(login, password)) {
                User user = storage.get(login);
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
            }
        }catch (IllegalArgumentException e) {
            resp.sendError(400, e.getMessage());
            return;
        }
    }
}
