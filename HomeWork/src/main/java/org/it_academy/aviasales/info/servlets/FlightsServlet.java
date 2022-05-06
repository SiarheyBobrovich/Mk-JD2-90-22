package org.it_academy.aviasales.info.servlets;

import org.it_academy.aviasales.info.dto.Airport;
import org.it_academy.aviasales.info.dto.Flight;
import org.it_academy.aviasales.info.dto.Pageable;
import org.it_academy.aviasales.info.dto.filters.FlightFilters;
import org.it_academy.aviasales.info.service.AirportsService;
import org.it_academy.aviasales.info.service.FlightsService;
import org.it_academy.aviasales.info.service.api.IAirportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

@WebServlet(name = "Flights", urlPatterns = "/flights")

public class FlightsServlet extends HttpServlet {
    private static final IAirportService<Airport> airportService = AirportsService.getInstance();
    private static final IAirportService<Flight> flightService = FlightsService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        if (req.getAttribute("airports") == null) {

            req.setAttribute("airports",
                    airportService.getAll().stream().
                            sorted(Comparator.comparing(Airport::getName))
                            .collect(Collectors.toList())
            );

            req.getRequestDispatcher("/airports/flightsInfo.jsp").forward(req, resp);
            return;
        }

        FlightFilters filter;
        Pageable page;

        if (!Objects.isNull(req.getParameter("next"))) {
            filter = (FlightFilters) req.getAttribute("filter");
            page = (Pageable) req.getAttribute("page");
            page.incrementPage();

        }else {
            filter = FlightFilters.Builder.create()
                    .setDepartureAirport(req.getParameter("departureAirport"))
                    .setArrivalAirport(req.getParameter("arrivalAirport"))
                    .setActualDepartureLocal(parse(req.getParameter("departureDate")))
                    .setActualArrivalLocal(parse(req.getParameter("arrivalDate")))
                    .build();

            page = new Pageable(25, 1);

        }

        req.setAttribute("page", page);
        req.setAttribute("filter", filter);
        req.setAttribute("flights", flightService.getWithParams(page, filter));

        req.getRequestDispatcher("/airports/flightsInfo.jsp").forward(req, resp);
    }

    private LocalDateTime parse(String s) {
        if (s.isEmpty()) {
            return null;
        }
        return LocalDate.parse(s, DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay();
    }
}
