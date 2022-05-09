package org.it_academy.aviasales.info.dao;

import org.it_academy.aviasales.info.dao.api.IAirportDao;
import org.it_academy.aviasales.info.dto.Flight;
import org.it_academy.aviasales.info.dto.Pageable;
import org.it_academy.aviasales.info.dto.filters.api.IFilter;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class FlightDao implements IAirportDao<Flight> {

    private final static FlightDao instance = new FlightDao();
    /**
     * All flights query
     */
    private static final String SQL_SELECT =
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

    public static FlightDao getInstance() {
        return instance;
    }

    private FlightDao() {}

    @Override
    public List<Flight> getFromDB(Pageable page, IFilter filters) {
        String query = "";

        if (!Objects.isNull(filters) && !filters.isEmpty()) {
            query = getSelector(filters);
        }

        boolean isPageNull = Objects.isNull(page);

        if (!isPageNull) {
            query = addPageParam(query);
        }

        query = SQL_SELECT + query + ";";

        try (Connection connection = AirportDataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            int index = 0;
            for (Object value : filters) {
                if (!Objects.isNull(value)) {
                    preparedStatement.setObject(++index, value);
                }
            }

            if (!isPageNull) {
                int size = page.getSize();
                preparedStatement.setInt(++index, size * (page.getPage() - 1));
                preparedStatement.setInt(++index, size);
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return map(resultSet);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Не удалось подключиться к базе");
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Не верен формат даты");
        }
    }

    /**
     * Method to create the query for JDBC
     * @param filter - additional parameters for query have been saved
     * @return - Full query
     */
    private String getSelector(IFilter filter) {
        StringBuilder builder = new StringBuilder();
        String and = "AND\n";
        String where = "WHERE\n";

        Map<String, Object> params = filter.getParams();

        if (!Objects.isNull(params.get("departureAirport"))) {
            builder.append("\tdeparture_airport = ? ");
        }

        if (!Objects.isNull(params.get("arrivalAirport"))) {
            if (builder.length() > 0) {
                builder.append(and);
            }
            builder.append("\tarrival_airport = ? ");
        }

        if (!Objects.isNull(params.get("actualDepartureLocal"))) {
            if (builder.length() > 0) {
                builder.append(and);
            }
                builder.append("\tdate_trunc('day', actual_departure_local) = ? ");
        }

        if (!Objects.isNull(params.get("actualArrivalLocal"))) {
            if (builder.length() > 0) {
                builder.append(and);
            }
                builder.append("\tdate_trunc('day', actual_arrival_local) = ?\n");
        }

        return builder.insert(0, where).toString();
    }

    private String addPageParam(String query) {
        return query + "OFFSET ?\nLIMIT ?";
    }


    /**
     * Method for saving the Flight objects taken from the DB
     * @param rs - ResultSet from JDBC
     * @return new List of Flights objects
     * @throws SQLException when connection has been closed
     */
    private List<Flight> map(ResultSet rs) throws SQLException {
        List<Flight> resultList = new ArrayList<>();

        while (rs.next()) {
            Flight.Builder builder = Flight.Builder.create();

            builder.setFlightId(rs.getLong("flight_id"));
            builder.setFlightNo(rs.getString("flight_no"));
            builder.setScheduledDeparture(rs.getTimestamp("scheduled_departure").toLocalDateTime());
            builder.setScheduledDepartureLocal(rs.getTimestamp("scheduled_departure_local").toLocalDateTime());
            builder.setScheduledArrival(rs.getTimestamp("scheduled_arrival").toLocalDateTime());
            builder.setScheduledArrivalLocal(rs.getTimestamp("scheduled_arrival_local").toLocalDateTime());
            builder.setScheduledDuration(parse(rs.getString("scheduled_duration")));
            builder.setDepartureAirport(rs.getString("departure_airport"));
            builder.setDepartureAirportName(rs.getString("departure_airport_name"));
            builder.setDepartureCity(rs.getString("departure_city"));
            builder.setArrivalAirport(rs.getString("arrival_airport"));
            builder.setArrivalAirportName(rs.getString("arrival_airport_name"));
            builder.setArrivalCity(rs.getString("arrival_city"));
            builder.setStatus(rs.getString("status"));
            builder.setAircraftCode(rs.getString("aircraft_code"));
            builder.setActualDeparture(parse(rs.getTimestamp("actual_departure")));
            builder.setActualDepartureLocal(parse(rs.getTimestamp("actual_departure_local")));
            builder.setActualArrival(parse(rs.getTimestamp("actual_arrival")));
            builder.setActualArrivalLocal(parse(rs.getTimestamp("actual_arrival_local")));
            builder.setActualDuration(parse(rs.getString("actual_duration")));

            resultList.add(builder.build());
        }

        return resultList;
    }

    private LocalDateTime parse(Timestamp time) {
        try {
            return time.toLocalDateTime();
        }catch (NullPointerException e) {
            return null;
        }
    }

    private Duration parse(String time) {
        if (time == null) {
            return null;
        }
        List<Integer> collect = Arrays.stream(time.split(":"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int seconds = (collect.get(0) * 60 * 60) +
                collect.get(1) * 60 +
                collect.get(2);
        return Duration.ofSeconds(seconds);
    }

}

