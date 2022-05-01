package org.it_academy.airportsInfo.service;

import org.it_academy.airportsInfo.dao.FlightsDao;
import org.it_academy.airportsInfo.dto.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class FlightsService {
    private FlightsDao fd = new FlightsDao();

    public List<Flight> get(String departureAirport,
                            String arrivalAirport,
                            String departureDate,
                            String arrivalDate,
                            String offset) {

        this.fd = new FlightsDao();
        fd.setDepartureAirport(departureAirport);
        fd.setArrivalAirport(arrivalAirport);
        fd.setOffset(Integer.parseInt(offset));

        if (departureDate.length() != 0 ) {
            fd.setDepartureDate(getDate(departureDate));
        }
        if (arrivalDate.length() != 0 ) {
            fd.setArrivalDate(getDate(arrivalDate));
        }

        return fd.getFromDB();
    }

    private LocalDateTime getDate(String date) throws DateTimeParseException {
        LocalDate dateTime = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return dateTime.atStartOfDay();
    }
}
