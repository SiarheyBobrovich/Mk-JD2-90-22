package by.it_academy.jd2.Mk_JD2_90_22.aviasales.controllers.html;

import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.FlightsFilter;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao.Pageable;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.service.AirportsService;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.service.FlightsService;
import by.it_academy.jd2.Mk_JD2_90_22.aviasales.controllers.html.utils.PaginationUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FlightsServlet", urlPatterns = "/aviasales/html/flights")
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

        FlightsFilter.Builder builder = FlightsFilter.Builder.create();

        String arrivalAirportRaw = req.getParameter("arrivalAirport");

        if(arrivalAirportRaw != null && !arrivalAirportRaw.isEmpty()){
            builder.setArrivalAirport(arrivalAirportRaw);
        }

        String departureAirportRaw = req.getParameter("departureAirport");

        if(departureAirportRaw != null && !departureAirportRaw.isEmpty()){
            builder.setDepartureAirport(departureAirportRaw);
        }

        FlightsFilter filter = builder.build();

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

        Pageable pageable = Pageable.of(size, page);

        long totalElements = this.flightsService.count(filter);

        req.setAttribute("arrivalAirport", filter.getArrivalAirport());
        req.setAttribute("departureAirport", filter.getDepartureAirport());
        req.setAttribute("totalElements", totalElements);
        req.setAttribute("page", pageable.getPage());
        req.setAttribute("size", pageable.getSize());
        req.setAttribute("maxPage", PaginationUtils.maxPageCount(totalElements, pageable));
        req.setAttribute("airports", this.airportsService.getAll());
        req.setAttribute("flights", this.flightsService.list(filter, pageable));

        req.getRequestDispatcher("/jsp/aviasales/flights.jsp").forward(req, resp);
    }
}
