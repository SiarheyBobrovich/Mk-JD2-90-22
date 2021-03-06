package org.it_academy.aviasales.info.servlets;

import org.it_academy.aviasales.info.dto.Airport;
import org.it_academy.aviasales.info.service.AirportsService;
import org.it_academy.aviasales.info.service.api.IAirportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AirportsServlet", urlPatterns = "/airports")
public class AirportsServlet extends HttpServlet {

    private static final IAirportService<Airport> as = AirportsService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("airports", as.getAll());

        req.getRequestDispatcher("/airports/airports.jsp").forward(req, resp);
    }
}
