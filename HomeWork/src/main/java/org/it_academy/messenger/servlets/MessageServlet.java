package org.it_academy.messenger.servlets;

import org.it_academy.messenger.core.dto.MessageDto;
import org.it_academy.messenger.dao.entity.User;
import org.it_academy.messenger.service.UserStorage;
import org.it_academy.messenger.service.StatisticStorage;
import org.it_academy.messenger.service.api.IUserStorage;

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

    private final IUserStorage storage;

    public MessageServlet() {
        storage = UserStorage.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String toUserLogin = req.getParameter(TO_USER);
        MessageDto user = new MessageDto(
                (User) req.getSession().getAttribute("user"),
                req.getParameter(TEXT)
        );

        try {
            storage.addMessage(user, toUserLogin);

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
