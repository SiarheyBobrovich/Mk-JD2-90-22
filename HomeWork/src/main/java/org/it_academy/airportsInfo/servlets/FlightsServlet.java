package org.it_academy.airportsInfo.servlets;

import org.it_academy.airportsInfo.dto.Airport;
import org.it_academy.airportsInfo.service.AirportsService;
import org.it_academy.airportsInfo.service.FlightsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FlightsServlet", urlPatterns = "/flights")

public class FlightsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String departureAirport = req.getParameter("departureAirport");
        String arrivalAirport = req.getParameter("arrivalAirport");
        String departureDate = req.getParameter("departureDate");
        String arrivalDate = req.getParameter("arrivalDate");
        String offset = req.getParameter("offset");

        try {
            FlightsService flightsService = new FlightsService();
            req.setAttribute("flights", flightsService.get(departureAirport, arrivalAirport, departureDate, arrivalDate, offset));
            req.getRequestDispatcher("/airports/flightsInfo.jsp").forward(req, resp);
        } catch (IllegalArgumentException e) {
            resp.sendRedirect(req.getContextPath() + "/flights");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AirportsService service = new AirportsService();
        req.setAttribute("airports", service.get());
        req.getRequestDispatcher("/airports/flights.jsp").forward(req, resp);
    }
}
