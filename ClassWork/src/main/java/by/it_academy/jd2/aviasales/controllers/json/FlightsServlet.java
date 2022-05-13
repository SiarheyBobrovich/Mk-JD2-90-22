package by.it_academy.jd2.aviasales.controllers.json;

import by.it_academy.jd2.aviasales.controllers.json.dto.Page;
import by.it_academy.jd2.aviasales.dao.Flights;
import by.it_academy.jd2.aviasales.dao.FlightsFilter;
import by.it_academy.jd2.aviasales.dao.Pageable;
import by.it_academy.jd2.aviasales.service.FlightsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FlightsServletJson", urlPatterns = "/json/aviasales/flights")
public class FlightsServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    private final FlightsService flightsService;

    public FlightsServlet() {
        this.flightsService = FlightsService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

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

        Page<Flights> objectBuilder = Page.Builder.create(Flights.class)
                .setPage(page)
                .setSize(size)
                .setTotalElements(100)
                .setContent(this.flightsService.list(filter, Pageable.of(size, page)))
                .build();

        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
        String s = objectMapper.writeValueAsString(objectBuilder);

        resp.getWriter().write(s);

    }
}
