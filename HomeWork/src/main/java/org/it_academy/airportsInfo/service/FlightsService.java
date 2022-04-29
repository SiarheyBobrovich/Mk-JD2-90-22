package org.it_academy.airportsInfo.service;

import org.it_academy.airportsInfo.dao.FlightsDao;
import org.it_academy.airportsInfo.dto.Airport;
import org.it_academy.airportsInfo.service.api.IAirportService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Formatter;
import java.util.List;

public class FlightsService implements IAirportService {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final FlightsDao fd;
    private final String fromAirport;
    private final String toAirport;
    private final LocalDateTime fromDate;
    private final LocalDateTime toDate;

    public FlightsService(String fromAirport, String toAirport, String fromDate, String toDate) {
        this.fd = new FlightsDao();
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.fromDate = getDate(fromDate);
        this.toDate = getDate(toDate);
    }

    @Override
    public List<Airport> get() {
        return null;
    }

    private LocalDateTime getDate(String date) {
        try {
            return LocalDateTime.parse(date, formatter);
        }catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid time format");
        }
    }
}
