package it_academy.org.messenger.servlets;

import it_academy.org.messenger.core.dto.Message;
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
import java.io.PrintWriter;
import java.util.List;

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

        if (fromUser == null) {
            resp.sendError(401, "You are an unauthorized user");
            return;
        }else if (text == null) {
            resp.sendError(400, "The message is incorrect");
            return;
        }

        try {
            storage.addMessages(fromUser.getLogin(), toUserLogin, text);
            StatisticStorage.getInstance().incrementCountMessages();
            resp.getWriter().append("Message has been sent");

        }catch (IllegalArgumentException e) {
            resp.sendError(400, e.getMessage());
            return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendError(401, "You are an unauthorized user");
            return;
        }

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        List<Message> messageList = storage.getMessages(user.getLogin());
        if (messageList.isEmpty()) {
            writer.write("You don't have any messages yet");
        }else {
            messageList.forEach(x -> writer.write("<p>" + x.toString() + "</p><br>"));
        }

    }
}
