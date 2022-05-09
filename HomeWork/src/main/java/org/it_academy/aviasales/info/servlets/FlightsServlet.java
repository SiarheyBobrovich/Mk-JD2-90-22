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

        req.setAttribute("airports",
                airportService.getAll().stream().
                        sorted(Comparator.comparing(Airport::getName))
                        .collect(Collectors.toList())
        );

        String queryString = req.getQueryString();

        //Перенаправляем если это первый вход на сайт
        if (req.getSession().isNew() || (queryString == null || queryString.isEmpty())) {
            req.getRequestDispatcher("/airports/flightsInfo.jsp").forward(req, resp);
            return;
        }

        //параметры
        String departureAirport = req.getParameter("departureAirport");
        String arrivalAirport = req.getParameter("arrivalAirport");
        String departureDate = req.getParameter("departureDate");
        String arrivalDate = req.getParameter("arrivalDate");

        //Создаём фильтр
        FlightFilters filter = FlightFilters.Builder
                .create()
                .setDepartureAirport(departureAirport)
                .setArrivalAirport(arrivalAirport)
                .setActualDepartureLocal(parse(departureDate))
                .setActualArrivalLocal(parse(arrivalDate))
                .build();

        //Создаём страницу
        int pageRow = 25;
        int page = 0;

        String pageRequest = req.getParameter("page");


        if (pageRequest != null) {
            try {
                page = Integer.parseInt(pageRequest);

            }catch (NumberFormatException e) {
                resp.sendRedirect(req.getContextPath() + "/flights");
                return;
            }
        }

        Pageable pageable = new Pageable(pageRow, ++page);

        //Заполняем форму вывода
        req.setAttribute("page", page);
        req.setAttribute("filter", filter);
        req.setAttribute("flights", flightService.getWithParams(pageable, filter));

        req.getRequestDispatcher("/airports/flightsInfo.jsp").forward(req, resp);
    }

    private LocalDateTime parse(String s) {
        if (s != null && !s.isEmpty()) {
            return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay();
        }

        return null;
    }
}
