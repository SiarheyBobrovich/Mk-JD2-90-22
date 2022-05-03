package org.it_academy.airportsInfo.dao;

import org.it_academy.airportsInfo.dao.api.AbstractAirportDao;
import org.it_academy.airportsInfo.dto.Flight;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FlightsDeprecatedDao extends AbstractAirportDao<Flight> {

    private final String allFlightsSelector =
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

    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private int offset;
    private int paramSize;

    public FlightsDeprecatedDao() {
        super();
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
        this.paramSize++;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
        this.paramSize++;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
        this.paramSize++;
    }

    public void setOffset(int offset) {
        this.offset = offset;
        this.paramSize++;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
        this.paramSize++;
    }

    @Override
    public List<Flight> getFromDB() {
        List<Flight> map;

        try (Connection connection = getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getSelector())
        ) {
            addWhereParams(preparedStatement);

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                map = map(resultSet);
            }
            close();
            return map;

        }catch (SQLException e) {
            close();
            throw new RuntimeException("Не удалось подключиться к базе");
        }
    }

    private String getSelector() {
        StringBuilder builder = new StringBuilder();
        String and = "AND\n";
        String where = "WHERE\n";

        if (departureAirport != null) {
            builder.append(where)
                    .append("\tdeparture_airport_name = ? ");
        }

        if (!Objects.isNull(arrivalAirport)) {
            builder.append(builder.length() > 0 ? and : where)
                    .append("\tarrival_airport_name = ? ");
        }

        if (!Objects.isNull(departureDate)) {
            builder.append(builder.length() > 0 ? and : where)
                    .append("\tdate_trunc('day', actual_departure_local) = ? ");
        }

        if (!Objects.isNull(arrivalDate)) {
            builder.append(builder.length() > 0 ? and : where)
                    .append("\tdate_trunc('day', actual_arrival_local) = ?\n");
        }

        return builder.append("OFFSET ?\n")
                .append("LIMIT 25;")
                .insert(0, allFlightsSelector)
                .toString();
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

    private void addWhereParams(PreparedStatement ps) throws SQLException {
        ps.setInt(paramSize--, this.offset);

        if (!Objects.isNull(arrivalDate)) {
            ps.setTimestamp(paramSize--, Timestamp.valueOf(arrivalDate));
        }

        if (!Objects.isNull(departureDate)) {
            ps.setTimestamp(paramSize--, Timestamp.valueOf(departureDate));
        }

        if (!Objects.isNull(arrivalAirport)) {
            ps.setString(paramSize--, this.arrivalAirport);
        }

        if (!Objects.isNull(departureAirport)) {
            ps.setString(paramSize--, this.departureAirport);
        }
    }
}
