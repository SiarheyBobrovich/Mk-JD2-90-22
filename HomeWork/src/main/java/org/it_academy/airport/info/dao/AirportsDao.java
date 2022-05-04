package org.it_academy.airport.info.dao;

import org.it_academy.airport.info.dao.api.IAirportDao;
import org.it_academy.airport.info.dto.Airport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportsDao implements IAirportDao<Airport> {

    /**
     * all airports query
     */
    private final String allAirportsSelector =
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

        try(Connection connection = AirportDataSource.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(allAirportsSelector)) {

            try(ResultSet resultSet = preparedStatement.executeQuery()) {

                return (map(resultSet));
            }

        }catch (SQLException e) {
            throw new RuntimeException("Не удалось подключиться к базе", e);
        }
    }

    /**
     * Method for saving the Airport objects taken from the DB
     * @param rs - ResultSet from JDBC
     * @return new List of Airport objects
     * @throws SQLException when connection has been closed
     */
    private List<Airport> map(ResultSet rs) throws SQLException {
        List<Airport> airports = new ArrayList<>();

        while (rs.next()) {
            airports.add(
                    new Airport(
                        rs.getString("airport_code"),
                        rs.getString("airport_name"),
                        rs.getString("city"),
                        rs.getString("coordinates"),
                        rs.getString("timezone")
                    )
            );
        }

        return airports;
    }
}
