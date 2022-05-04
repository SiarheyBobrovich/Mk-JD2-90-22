package org.it_academy.airportsInfo.dao;

import org.it_academy.airportsInfo.dao.api.AirportDataSource;
import org.it_academy.airportsInfo.dao.api.IAirportDao;
import org.it_academy.airportsInfo.dto.Flight;

import java.sql.*;
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
            resultList.add(new Flight(
                    rs.getString("flight_id"),
                    rs.getString("flight_no"),
                    rs.getString("scheduled_departure"),
                    rs.getString("scheduled_departure_local"),
                    rs.getString("scheduled_arrival"),
                    rs.getString("scheduled_arrival_local"),
                    rs.getString("scheduled_duration"),
                    rs.getString("departure_airport"),
                    rs.getString("departure_airport_name"),
                    rs.getString("departure_city"),
                    rs.getString("arrival_airport"),
                    rs.getString("arrival_airport_name"),
                    rs.getString("arrival_city"),
                    rs.getString("status"),
                    rs.getString("aircraft_code"),
                    rs.getString("actual_departure"),
                    rs.getString("actual_departure_local"),
                    rs.getString("actual_arrival"),
                    rs.getString("actual_arrival_local"),
                    rs.getString("actual_duration"))
            );
        }

        return resultList;
    }
}

