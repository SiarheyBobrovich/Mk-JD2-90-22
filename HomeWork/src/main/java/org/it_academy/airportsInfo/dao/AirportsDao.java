package org.it_academy.airportsInfo.dao;

import org.it_academy.airportsInfo.dao.api.AbstractAirportDao;
import org.it_academy.airportsInfo.dto.Airport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportsDao extends AbstractAirportDao<Airport> {

    public AirportsDao() {
        super();
    }

    @Override
    public List<Airport> getFromDB() {

        List<Airport> airports = new ArrayList<>();

        try(Connection connection = getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ALL_AIRPORTS_SELECTOR)) {

            try(ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    airports.add(map(resultSet));
                }
            }
            close();
            return airports;

        }catch (SQLException e) {
            close();
            throw new RuntimeException("Не удалось подключиться к базе", e);
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
