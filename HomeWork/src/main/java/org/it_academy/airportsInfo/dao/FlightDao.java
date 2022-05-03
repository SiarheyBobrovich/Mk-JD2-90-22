package org.it_academy.airportsInfo.dao;

import org.it_academy.airportsInfo.dao.api.AbstractAirportDao;
import org.it_academy.airportsInfo.dto.Flight;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FlightDao extends AbstractAirportDao<Flight> {

    private String selector;
    private List<String> params = new ArrayList();

    private int numberOfParam;

    public FlightDao(String selector) {
        super();
        this.selector = selector;
    }

    public void setParam(String value) {
        if (!Objects.isNull(value) && !value.isEmpty()) {
            params.add(value);
        }
    }

    @Override
    public List<Flight> getFromDB() {
        List<Flight> map;

        try (Connection connection = getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selector)) {

            for (String value : params) {
                addParams(preparedStatement, value);
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                map = map(resultSet);
            }

            close();
            return map;

        } catch (SQLException e) {
            close();
            throw new RuntimeException("Не удалось подключиться к базе");
        }
    }

    private void addParams(PreparedStatement ps, String param) throws SQLException {
        if (param.matches("\\d{4}-\\d{2}-\\d{2}")) {
            ps.setTimestamp(++numberOfParam, getTimestamp(param));
        }else if (param.matches("\\d*")) {
            ps.setInt(++numberOfParam, Integer.parseInt(param));
        }else {
            ps.setString(++numberOfParam, param);
        }
    }

    private Timestamp getTimestamp(String text) {
        return Timestamp.valueOf(
                LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                        .atStartOfDay()
        );
    }

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

