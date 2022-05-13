package by.it_academy.jd2.aviasales.controllers.html;

import by.it_academy.jd2.aviasales.dao.FlightsFilter;
import by.it_academy.jd2.aviasales.dao.Pageable;
import by.it_academy.jd2.aviasales.service.AirportsService;
import by.it_academy.jd2.aviasales.service.FlightsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FlightsServlet", urlPatterns = "/html/aviasales/flights")
public class FlightsServlet extends HttpServlet {

    private final FlightsService flightsService;
    private final AirportsService airportsService;

    public FlightsServlet() {
        this.flightsService = FlightsService.getInstance();
        this.airportsService = AirportsService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        FlightsFilter filter = FlightsFilter.Builder.create()
                .setArrivalAirport(req.getParameter("arrivalAirport"))
                .setDepartureAirport(req.getParameter("departureAirport"))
                .build();

        String pageRaw = req.getParameter("page");
        String sizeRaw = req.getParameter("size");

        int page = 1;
        int size = 50;

        if(pageRaw != null && !pageRaw.isEmpty()){
            page = Integer.parseInt(pageRaw);
        }
        if(sizeRaw != null && !sizeRaw.isEmpty()){
            size = Integer.parseInt(sizeRaw);
        }

        req.setAttribute("airports", this.airportsService.getAll());
        req.setAttribute("flights", this.flightsService.list(filter, Pageable.of(size, page)));

        req.getRequestDispatcher("/jsp/aviasales/flights.jsp").forward(req, resp);
    }
}
