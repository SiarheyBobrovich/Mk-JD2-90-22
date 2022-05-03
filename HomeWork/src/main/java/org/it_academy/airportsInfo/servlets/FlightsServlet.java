package org.it_academy.airportsInfo.servlets;

import org.it_academy.airportsInfo.dto.Airport;
import org.it_academy.airportsInfo.dto.Flight;
import org.it_academy.airportsInfo.service.AirportsService;
import org.it_academy.airportsInfo.service.FlightsService;
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

@WebServlet(name = "Flights", urlPatterns = "/flights")

public class FlightsServlet extends HttpServlet {
    private final IAirportService<Airport> airportService = new AirportsService();
    private IAirportService<Flight> flightService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        List<String> params = new ArrayList<>();

        params.add(req.getParameter("departureAirport"));
        params.add(req.getParameter("arrivalAirport"));
        params.add(req.getParameter("departureDate"));
        params.add(req.getParameter("arrivalDate"));
        String offset = req.getParameter("offset");

        try {
            params.add(offset == null ? "0" : String.valueOf(Integer.parseInt(offset) + 25));
        }catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/flights?error" + e.getMessage());
        }

        flightService = new FlightsService(params);

        try {
            req.setAttribute("flights", flightService.get());

        } catch (RuntimeException e) {
            resp.sendRedirect(req.getContextPath() + "/flights?error" + e.getMessage());
        }

        req.getRequestDispatcher("/airports/flightsInfo.jsp?" +
                "departureAirport=" + params.get(0) +
                "&arrivalAirport=" + params.get(1) +
                "&departureDate=" + params.get(2) +
                "&arrivalDate=" + params.get(3) +
                "&offset=" + params.get(4))
                .forward(req, resp)
        ;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("airports",
                this.airportService.get().stream().
                        sorted(Comparator.comparing(Airport::getName))
                        .collect(Collectors.toList())
        );
        req.getRequestDispatcher("/airports/flights.jsp").forward(req, resp);
    }
}
