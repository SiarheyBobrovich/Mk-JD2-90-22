package org.it_academy.airportsInfo.servlets;

import org.it_academy.airportsInfo.dto.Airport;
import org.it_academy.airportsInfo.service.AirportsService;
import org.it_academy.airportsInfo.service.api.IAirportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AirportsServlet", urlPatterns = "/airports")
public class AirportsServlet extends HttpServlet {

    private IAirportService<Airport> as;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        as = new AirportsService();
        req.setAttribute("airports", as.get());

        req.getRequestDispatcher("/airports/airports.jsp").forward(req, resp);
    }
}
