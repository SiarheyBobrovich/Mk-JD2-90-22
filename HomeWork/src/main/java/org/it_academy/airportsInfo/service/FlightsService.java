package org.it_academy.airportsInfo.service;

import org.it_academy.airportsInfo.dao.FlightsDao;
import org.it_academy.airportsInfo.dao.api.IAirportDao;
import org.it_academy.airportsInfo.dto.Flight;
import org.it_academy.airportsInfo.service.api.IAirportService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;

public class FlightsService implements IAirportService<Flight>{

    private final FlightsDao fd;
    private final String departureAirport;
    private final String arrivalAirport;
    private final String departureDate;
    private final String arrivalDate;
    private String offset;

    public FlightsService(String departureAirport, String arrivalAirport, String departureDate, String arrivalDate, String offset) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.offset = offset;
        fd = new FlightsDao();
    }

    @Override
    public List<Flight> get() {

        if (check(departureAirport)) {
            fd.setDepartureAirport(departureAirport);
        }

        if (check(arrivalAirport)) {
            fd.setArrivalAirport(arrivalAirport);
        }


        if (check(offset)) {
            fd.setOffset(Integer.parseInt(offset));
        }

        try {
            if (check(departureDate)) {
                fd.setDepartureDate(getDate(departureDate));
            }

            if (check(arrivalDate)) {
                fd.setArrivalDate(getDate(arrivalDate));
            }
        }catch (DateTimeParseException e) {
            fd.close();
            throw new IllegalArgumentException("Не верно введена дата");
        }

        return fd.getFromDB();
    }

    private boolean check(String str) {
        return !Objects.isNull(str) && str.length() > 0;
    }

    private LocalDateTime getDate(String date) throws DateTimeParseException {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay();
    }
}
