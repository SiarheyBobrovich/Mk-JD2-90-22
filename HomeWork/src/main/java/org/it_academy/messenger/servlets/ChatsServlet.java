package org.it_academy.messenger.servlets;

import org.it_academy.messenger.dao.entity.Message;
import org.it_academy.messenger.dao.entity.User;
import org.it_academy.messenger.service.UserStorage;
import org.it_academy.messenger.service.api.IUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChatServlet", urlPatterns = "/ui/user/chats")
public class ChatsServlet extends HttpServlet {

    private final IUserStorage storage = UserStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");

        List<Message> messages = storage.getMessages(user);
        req.setAttribute("messages", messages);

        req.getRequestDispatcher("/ui/user/chats.jsp").forward(req, resp);
    }
}
