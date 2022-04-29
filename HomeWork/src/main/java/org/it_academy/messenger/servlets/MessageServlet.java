package org.it_academy.messenger.servlets;

import org.it_academy.messenger.core.dto.User;
import org.it_academy.messenger.service.UserStorage;
import org.it_academy.messenger.service.api.IUserStorage;
import org.it_academy.messenger.service.StatisticStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        req.getRequestDispatcher("/ui/user/message.jsp").forward(req, resp);
    }

    private void sendRedirect(HttpServletRequest req, HttpServletResponse resp,
                           String contextPath,
                           String message) throws IOException {
        resp.sendRedirect(req.getContextPath() + contextPath + message);
    }
}
