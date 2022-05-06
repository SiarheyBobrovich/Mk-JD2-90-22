package org.it_academy.aviasales.info.dao;

import org.it_academy.aviasales.info.dao.api.IAirportDao;
import org.it_academy.aviasales.info.dto.Flight;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class FlightDao implements IAirportDao<Flight> {

    private String selector;
    private List<String> params = new ArrayList();

    private int numberOfParam;

    public FlightDao(String selector) {
        super();
        this.selector = selector;
    }

    /**
     * Setter to save to param list
     * @param value param to save
     */
    public void setParam(String value) {
        if (!Objects.isNull(value) && !value.isEmpty()) {
            params.add(value);
        }
    }

    @Override
    public List<Flight> getFromDB() {

        try (Connection connection = AirportDataSource.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selector)) {

            for (String value : params) {
                addParams(preparedStatement, value);
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
     * Method to add parameter to parametrised query
     * @param ps - PreparedStatement where will be added
     * @param param - parameter to add instead of "?"
     * @throws SQLException - More or less parameters than query have
     */
    private void addParams(PreparedStatement ps, String param) throws SQLException, DateTimeParseException {
        if (param.matches("\\d{4}-\\d{2}-\\d{2}")) {
            ps.setTimestamp(++numberOfParam, getTimestamp(param));
        }else if (param.matches("\\d+")) {
            ps.setInt(++numberOfParam, Integer.parseInt(param));
        }else if (param.matches("[аА-яЯёЁ]+")) {
            ps.setString(++numberOfParam, param);
        }else {
            throw new IllegalArgumentException("Не верно введён параметр: " + param);
        }
    }

    /**
     * Method to get timestamp object from string by DateTimeFormatter("yyyy-MM-dd)
     * @param str - string which has date
     * @return new Timestamp object
     * @throws DateTimeParseException when string cannot not be parsed
     */
    private Timestamp getTimestamp(String str) throws DateTimeParseException {
        return Timestamp.valueOf(
                LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                        .atStartOfDay()
        );
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
            builder.setFlightNo(rs.getLong("flight_no"));
            builder.setScheduledDeparture(rs.getTimestamp("scheduled_departure").toLocalDateTime());
            builder.setScheduledDepartureLocal(rs.getTimestamp("scheduled_departure_local").toLocalDateTime());
            builder.setScheduledArrival(rs.getTimestamp("scheduled_arrival").toLocalDateTime());
            builder.setScheduledArrivalLocal(rs.getTimestamp("scheduled_arrival_local").toLocalDateTime());
            builder.setScheduledDuration(Duration.ofSeconds(rs.getTimestamp("scheduled_duration").getTime()));
            builder.setDepartureAirport(rs.getString("departure_airport"));
            builder.setDepartureAirportName(rs.getString("departure_airport_name"));
            builder.setDepartureCity(rs.getString("departure_city"));
            builder.setArrivalAirport(rs.getString("arrival_airport"));
            builder.setArrivalAirportName(rs.getString("arrival_airport_name"));
            builder.setArrivalCity(rs.getString("arrival_city"));
            builder.setStatus(rs.getString("status"));
            builder.setAircraftCode(rs.getString("aircraft_code"));
            builder.setActualDeparture(rs.getTimestamp("actual_departure").toLocalDateTime());
            builder.setActualDepartureLocal(rs.getTimestamp("actual_departure_local").toLocalDateTime());
            builder.setActualArrival(rs.getTimestamp("actual_arrival").toLocalDateTime());
            builder.setActualArrivalLocal(rs.getTimestamp("actual_arrival_local").toLocalDateTime());
            builder.setActualDuration(Duration.ofSeconds(rs.getTimestamp("actual_duration").getTime()));

            resultList.add(builder.build());
        }

        return resultList;
    }
}

