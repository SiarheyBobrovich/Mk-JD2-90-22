package org.it_academy.messenger.servlets;

import org.it_academy.messenger.service.StatisticStorage;
import org.it_academy.messenger.service.api.IStatisticStorage;

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

        req.setAttribute("countUsers", storage.getCountUsers());
        req.setAttribute("sendMessages", storage.getCountMessages());

        req.getRequestDispatcher("/ui/admin/statistics.jsp").forward(req, resp);
    }
}
