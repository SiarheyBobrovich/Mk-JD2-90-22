package org.it_academy.airportsInfo.dao.api;

import org.it_academy.airportsInfo.dto.Airport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface IAirportDao {

    default Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/demo",
                "postgres",
                "172143"
        );
    }

    List<Airport> getFromDB();
}
