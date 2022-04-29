package org.it_academy.airportsInfo.servlets;

import org.it_academy.airportsInfo.service.AirportsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AirportsServlet", urlPatterns = "/airports")
public class AirportsServlet extends HttpServlet {

    private AirportsService as = new AirportsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("airports", as.get());

        req.getRequestDispatcher("/airports/airports.jsp").forward(req, resp);
    }
}
