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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.stream.Collectors;

@WebServlet(name = "Flights", urlPatterns = "/flights")

public class FlightsServlet extends HttpServlet {
    private final IAirportService<Airport> airportService;
    private final IAirportService<Flight> flightService;

    public FlightsServlet() {
        airportService = AirportsService.getInstance();
        flightService = FlightsService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String departureAirport = req.getParameter("departureAirport");
        String arrivalAirport = req.getParameter("arrivalAirport");
        String departureDate = req.getParameter("departureDate");
        String arrivalDate = req.getParameter("arrivalDate");

        //ПЕРЕДЕЛАТЬ
        FlightFilters filter = (FlightFilters) req.getAttribute("filter");
        Pageable page = (Pageable) req.getAttribute("page");

        if (filter == null) {
            filter = FlightFilters.Builder
                    .create()
                    .setDepartureAirport(departureAirport)
                    .setArrivalAirport(arrivalAirport)
                    .setActualDepartureLocal(parse(departureDate))
                    .setActualArrivalLocal(parse(arrivalDate))
                    .build();
        }

        if (page == null) {
            page = new Pageable(25, 1);
        }

        req.setAttribute("airports",
                airportService.getAll().stream().
                        sorted(Comparator.comparing(Airport::getName))
                        .collect(Collectors.toList())
        );

        //До сюда
        req.setAttribute("page", page);
        req.setAttribute("filter", filter);
        req.setAttribute("flights", flightService.getWithParams(page, filter));

        req.getRequestDispatcher("/airports/flightsInfo.jsp").forward(req, resp);
    }

    private LocalDateTime parse(String s) {
        if (s != null && !s.isEmpty()) {
            return LocalDate.parse(s, DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay();
        }

        return null;
    }
}
