package org.it_academy.airportsInfo.servlets;

import org.it_academy.airportsInfo.dto.Airport;
import org.it_academy.airportsInfo.dto.Flight;
import org.it_academy.airportsInfo.service.AirportsService;
import org.it_academy.airportsInfo.service.FlightsService2;
import org.it_academy.airportsInfo.service.api.IAirportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "Flight", urlPatterns = "/flight")

public class FlightsServlet2 extends HttpServlet {
    private IAirportService<Airport> aiAirport = new AirportsService();
    private IAirportService<Flight> aiFlight;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        List<String> params = new ArrayList<>();

        params.add(req.getParameter("departureAirport"));
        params.add(req.getParameter("arrivalAirport"));
        params.add(req.getParameter("departureDate"));
        params.add(req.getParameter("arrivalDate"));
        String offset = req.getParameter("offset");
        params.add(offset == null ? "0" : offset);

        aiFlight = new FlightsService2(params);

        try {
            req.setAttribute("flights", aiFlight.get());
            req.getRequestDispatcher("/airports/flightsInf.jsp").forward(req, resp);
        } catch (IllegalArgumentException e) {
            resp.sendRedirect(req.getContextPath() + "/flights2?error" + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("airports",
                this.aiAirport.get().stream().
                        sorted(Comparator.comparing(Airport::getName))
                        .collect(Collectors.toList())
        );
        req.getRequestDispatcher("/airports/flight.jsp").forward(req, resp);
    }
}
