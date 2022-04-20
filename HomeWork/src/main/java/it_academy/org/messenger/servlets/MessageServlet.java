package it_academy.org.messenger.servlets;

import it_academy.org.messenger.core.dto.User;
import it_academy.org.messenger.service.UserStorage;
import it_academy.org.messenger.service.api.IUserStorage;
import it_academy.org.messenger.service.StatisticStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MessageServlet", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {

    private static final String TO_USER = "toUser";
    private static final String TEXT = "text";

    private final IUserStorage<User> storage;

    public MessageServlet() {
        storage = UserStorage.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String toUserLogin = req.getParameter(TO_USER);
        String text = req.getParameter(TEXT);

        User fromUser = (User)req.getSession().getAttribute("user");

        try {
            storage.addMessage(fromUser.getLogin(), toUserLogin, text);
            StatisticStorage.getInstance().incrementCountMessages();

        }catch (IllegalArgumentException e) {
            sendRedirect(req, resp, "/ui/user/message", "?error=" + e.getMessage());
            return;
        }catch (IllegalStateException e) {
            sendRedirect(req, resp, "/ui/signIn", "?error=" + e.getMessage());
            return;
        }

        sendRedirect(req, resp,"/ui/user/message", "?message=Message has been sent.");
        return;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            sendRedirect(req, resp, "/ui/signIn", "?error=Please sing in!");
            return;
        }

        req.getRequestDispatcher("/ui/user/message.jsp").forward(req, resp);
    }

    private void sendRedirect(HttpServletRequest req, HttpServletResponse resp,
                           String contextPath,
                           String message) throws IOException {
        resp.sendRedirect(req.getContextPath() + contextPath + message);
    }
}
