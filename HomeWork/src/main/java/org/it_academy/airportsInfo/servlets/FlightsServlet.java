package org.it_academy.airportsInfo.servlets;

import org.it_academy.airportsInfo.dto.Airport;
import org.it_academy.airportsInfo.dto.Flight;
import org.it_academy.airportsInfo.service.AirportsService;
import org.it_academy.airportsInfo.service.FlightsService;
import org.it_academy.airportsInfo.service.api.IAirportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Comparator;
import java.util.stream.Collectors;

@WebServlet(name = "FlightsServlet", urlPatterns = "/flights")

public class FlightsServlet extends HttpServlet {
    private IAirportService<Airport> aiAirport;
    private IAirportService<Flight> aiFlight;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String departureAirport = req.getParameter("departureAirport");
        String arrivalAirport = req.getParameter("arrivalAirport");
        String departureDate = req.getParameter("departureDate");
        String arrivalDate = req.getParameter("arrivalDate");
        String offset = req.getParameter("offset");


         aiFlight = new FlightsService(
                departureAirport,
                arrivalAirport,
                departureDate,
                arrivalDate,
                offset.length() == 0 ? "0" : offset
        );

        try {
            req.setAttribute("flights", aiFlight.get());
            req.getRequestDispatcher("/airports/flightsInfo.jsp").forward(req, resp);
        } catch (IllegalArgumentException e) {
            resp.sendRedirect(req.getContextPath() + "/flights?error" + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        aiAirport = new AirportsService();
        req.setAttribute("airports",
                this.aiAirport.get().stream().
                        sorted(Comparator.comparing(Airport::getName))
                        .collect(Collectors.toList())
        );
        req.getRequestDispatcher("/airports/flights.jsp").forward(req, resp);
    }
}
