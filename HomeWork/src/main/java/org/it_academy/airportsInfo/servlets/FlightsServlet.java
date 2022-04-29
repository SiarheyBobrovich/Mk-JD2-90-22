package org.it_academy.airportsInfo.servlets;

import org.it_academy.airportsInfo.service.FlightsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FlightsServlet", urlPatterns = "/flights")

public class FlightsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fromAirport = req.getParameter("fromAirport");
        String toAirport = req.getParameter("toAirport");
        String fromDate = req.getParameter("fromDate");
        String toDate = req.getParameter("toDate");

        try {
            FlightsService flightsService = new FlightsService(fromAirport, toAirport, fromDate, toDate);
        } catch (IllegalArgumentException e) {
            resp.sendRedirect(req.getContextPath() + "/airports/flights.jsp");
        }
    }
}
