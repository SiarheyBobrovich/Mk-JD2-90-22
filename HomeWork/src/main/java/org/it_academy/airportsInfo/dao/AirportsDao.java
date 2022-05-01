package org.it_academy.airportsInfo.dao;

import org.it_academy.airportsInfo.dao.api.IAirportDao;
import org.it_academy.airportsInfo.dto.Airport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportsDao implements IAirportDao {
    private static final String ALL_AIRPORTS_SELECTOR =
            "SELECT\n" +
                "airport_code,\n" +
                "airport_name,\n" +
                "city,\n" +
                "coordinates,\n" +
                "timezone\n" +
            "FROM\n" +
                "bookings.airports\n" +
            "ORDER BY\n" +
                "city;";

    @Override
    public List<Airport> getFromDB() {

        List<Airport> airports = new ArrayList<>();

        try(Connection connection = getConnection();
        Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(ALL_AIRPORTS_SELECTOR);

            while (resultSet.next()) {
                airports.add(map(resultSet));
            }

            return airports;

        }catch (SQLException e) {
            throw new RuntimeException("Не удалось подключиться к базе", e);
        }catch (ClassNotFoundException e) {
            throw new RuntimeException("Проверьте драйвер", e);
        }
    }

    private Airport map(ResultSet rs) throws SQLException {
        return new Airport(
                rs.getString("airport_code"),
                rs.getString("airport_name"),
                rs.getString("city"),
                rs.getString("coordinates"),
                rs.getString("timezone")
        );
    }
}
