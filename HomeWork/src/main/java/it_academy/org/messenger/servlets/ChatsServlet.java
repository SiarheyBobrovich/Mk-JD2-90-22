package it_academy.org.messenger.servlets;

import it_academy.org.messenger.core.dto.Message;
import it_academy.org.messenger.core.dto.User;
import it_academy.org.messenger.service.UserStorage;
import it_academy.org.messenger.service.api.IUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChatServlet", urlPatterns = "/ui/user/chats")
public class ChatsServlet extends HttpServlet {

    private final IUserStorage<User> storage = UserStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object obj = req.getSession().getAttribute("user");

        if (obj == null){
            resp.sendRedirect( req.getContextPath() + "/ui/signIn" + "?error=Authorise to see your messages");
            return;
        }

        User user = (User) obj;
        List<Message> messages = storage.getMessages(user.getLogin());
        req.setAttribute("messages", messages);

        req.getRequestDispatcher("/ui/user/chats.jsp").forward(req, resp);
    }
}
