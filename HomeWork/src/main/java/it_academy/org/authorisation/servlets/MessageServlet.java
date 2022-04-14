package it_academy.org.authorisation.servlets;

import it_academy.org.authorisation.dto.Message;
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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MessageServlet", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {

    private static final String TO_USER = "toUser";
    private static final String TEXT = "text";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String toUserLogin = req.getParameter(TO_USER);
        String text = req.getParameter(TEXT);
        User fromUser;

        try {
            fromUser = (User)req.getSession().getAttribute("user");

            if (fromUser == null) {
                throw new IllegalArgumentException();
            }

        }catch (ClassCastException | IllegalArgumentException e) {
            resp.sendError(401, "You are an unauthorized user");
            return;
        }

        IStorage storage = UserStorage.getInstance();
        User toUser = storage.get(toUserLogin);

        try {

            Message message = new Message(fromUser, toUser, text);
            toUser.addMessage(message);
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

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        List<Message> messageList = user.getMessageList();
        if (messageList.isEmpty()) {
            writer.write("You don't have any messages yet");
        }else {
            user.getMessageList().forEach(x -> writer.write("<p>" + x.toString() + "</p><br>"));
        }

    }
}
