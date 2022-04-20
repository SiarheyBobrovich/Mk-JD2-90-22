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

@WebServlet(name = "AdminStatisticsServlet", urlPatterns = "/api/admin/statistics")
public class AdminStatisticsServlet extends HttpServlet {

    private static final IStatisticStorage storage = StatisticStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        User user = (User) req.getSession().getAttribute("user");

        if (user != null && user.getStatus() == Role.ADMIN) {
            req.setAttribute("countUsers", storage.getCountUsers());
            req.setAttribute("sendMessages", storage.getCountMessages());

            req.getRequestDispatcher("/ui/admin/statistics.jsp").forward(req, resp);
            return;

        }else {
            resp.sendError(403);
        }
    }
}
