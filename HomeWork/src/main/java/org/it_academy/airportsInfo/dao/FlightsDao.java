package org.it_academy.airportsInfo.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.it_academy.airportsInfo.dto.Flight;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FlightsDao{

    private final static String FLIGHTS_SELECTOR =
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
                    "\tbookings.flights_v\n" +
                    "WHERE\n" +
                    "\tdeparture_airport_name = ? AND\n" +
                    "\tarrival_airport_name = ? AND\n" +
                    "\tdate_trunc('day', actual_departure_local) = ? AND\n" +
                    "\tdate_trunc('day', actual_arrival_local) = ?\n" +
                    "OFFSET ?\n" +
                    "LIMIT 25;\n";

    private DataSource ds;
    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private int offset;

    public FlightsDao() {
        ComboPooledDataSource pool = new ComboPooledDataSource();

        try {
            pool.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException("Проверьте правильность драйвера", e);
        }

        pool.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        pool.setUser("postgres");
        pool.setPassword("172143");
        this.ds = pool;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public List<Flight> getFromDB() {

        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FLIGHTS_SELECTOR);
        ) {
            preparedStatement.setString(1, this.departureAirport);
            preparedStatement.setString(2, this.arrivalAirport);
            preparedStatement.setInt(5, this.offset);

            preparedStatement.setTimestamp(3, Timestamp.valueOf(departureDate));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(arrivalDate));


            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                return map(resultSet);
            }


        }catch (SQLException e) {
            throw new RuntimeException("Не удалось подключиться к базе", e);
        }
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
