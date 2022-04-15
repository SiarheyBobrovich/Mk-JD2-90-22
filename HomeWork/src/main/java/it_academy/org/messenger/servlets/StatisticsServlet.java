package it_academy.org.messenger.servlets;

import it_academy.org.messenger.core.dto.User;
import it_academy.org.messenger.core.dto.enums.Role;
import it_academy.org.messenger.service.StatisticStorage;
import it_academy.org.messenger.service.api.IStatisticStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StatisticsServlet", urlPatterns = "/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {

    private static final IStatisticStorage storage = StatisticStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        User user = (User) req.getSession().getAttribute("user");
        if (user != null && user.getStatus() == Role.ADMIN) {
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.write("<p>Пользователей: " + storage.getCountUsers() + "</p>");
            writer.write("<p>Сообщений отправлено: " + storage.getCountMessages() + "</p>");
        }else {
            resp.sendError(403);
        }
    }
}
