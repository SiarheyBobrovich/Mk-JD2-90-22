package org.it_academy.airportsInfo.service;

import org.it_academy.airportsInfo.dao.FlightDao2;
import org.it_academy.airportsInfo.dao.api.IAirportDao;
import org.it_academy.airportsInfo.dto.Flight;
import org.it_academy.airportsInfo.service.api.IAirportService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FlightsService2 implements IAirportService<Flight>{

    public final String ALL_FLIGHTS_SELECTOR =
            "SELECT \n" +
                    "\tflight_id,\n" +
                    "\tflight_no,\n" +
                    "\tscheduled_departure,\n" +
                    "\tscheduled_departure_local,\n" +
                    "\tscheduled_arrival,\n" +
                    "\tscheduled_arrival_local,\n" +
                    "\tscheduled_duration,\n" +
                    "\tdeparture_airport,\n" +
                    "\tdeparture_airport_name,\n" +
                    "\tdeparture_city,\n" +
                    "\tarrival_airport,\n" +
                    "\tarrival_airport_name,\n" +
                    "\tarrival_city, status,\n" +
                    "\taircraft_code,\n" +
                    "\tactual_departure,\n" +
                    "\tactual_departure_local,\n" +
                    "\tactual_arrival,\n" +
                    "\tactual_arrival_local,\n" +
                    "\tactual_duration\n" +
                    "FROM\n" +
                    "\tbookings.flights_v\n";

    private IAirportDao<Flight> fd;

    public FlightsService2(List<String> params) {
        List<String> s = params.stream()
                .map(x -> x.isEmpty() ? null : x)
                .collect(Collectors.toList());


        FlightDao2 flightDao2 = new FlightDao2(getSelector(s));

        for (String param : s) {
            flightDao2.setParam(param);
        }

        fd = flightDao2;
    }

    @Override
    public List<Flight> get() {
        
        return fd.getFromDB();
    }

    private String getSelector(List<String> params) {
        StringBuilder builder = new StringBuilder();
        String and = "AND\n";
        String where = "WHERE\n";

        if (!Objects.isNull(params.get(0))) {
            builder.append(where)
                    .append("\tdeparture_airport_name = ? ");
        }

        if (!Objects.isNull(params.get(1))) {
            builder.append(builder.length() > 0 ? and : where)
                    .append("\tarrival_airport_name = ? ");
        }

        if (!Objects.isNull(params.get(2))) {
            builder.append(builder.length() > 0 ? and : where)
                    .append("\tdate_trunc('day', actual_departure_local) = ? ");
        }

        if (!Objects.isNull(params.get(3))) {
            builder.append(builder.length() > 0 ? and : where)
                    .append("\tdate_trunc('day', actual_arrival_local) = ?\n");
        }

        return builder.append("OFFSET ?\n")
                .append("LIMIT 25;")
                .insert(0, ALL_FLIGHTS_SELECTOR)
                .toString();
    }
}
