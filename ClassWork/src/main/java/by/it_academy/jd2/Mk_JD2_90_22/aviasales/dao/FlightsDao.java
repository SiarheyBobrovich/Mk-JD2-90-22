package by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao;

import java.sql.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightsDao implements IFlightsDao{
    private final static FlightsDao instance = new FlightsDao();

    private final static String SELECT_SQL = "SELECT\n" +
            "    flight_id,\n" +
            "    flight_no,\n" +
            "    scheduled_departure,\n" +
            "    scheduled_departure_local,\n" +
            "    scheduled_arrival,\n" +
            "    scheduled_arrival_local,\n" +
            "    scheduled_duration,\n" +
            "    departure_airport,\n" +
            "    departure_airport_name,\n" +
            "    departure_city,\n" +
            "    arrival_airport,\n" +
            "    arrival_airport_name,\n" +
            "    arrival_city,\n" +
            "    status,\n" +
            "    aircraft_code,\n" +
            "    actual_departure,\n" +
            "    actual_departure_local,\n" +
            "    actual_arrival,\n" +
            "    actual_arrival_local,\n" +
            "    actual_duration\n" +
            "FROM\n" +
            "    bookings.flights_v\n" +
            "\n";

    private final static String COUNT_SQL = "SELECT count(flight_id) FROM bookings.flights_v";

    @Override
    public List<Flights> getAll() {
        return list(null, Pageable.of(0, 0));
    }

    @Override
    public List<Flights> list(FlightsFilter filter, Pageable pageable) {
        if(filter == null){
            filter = FlightsFilter.Builder.create().build();
        }

        if(pageable == null){
            pageable = Pageable.of(25, 1);
        }

        List<Flights> flights = new ArrayList<>();

        List<Object> params = new ArrayList<>();

        String where = where(filter, params);

        String page = "";

        if(pageable.getSize() > 0){
            page += " LIMIT " + pageable.getSize();
        }
        if (pageable.getPage() > 0){
            int offset = pageable.getSize() * (pageable.getPage() - 1);

            page += " OFFSET " + offset;
        }

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SQL + where + page);
        ) {
            int index = 0;
            for (Object param : params) {
                statement.setObject(++index, param);
            }

            try(ResultSet resultSet = statement.executeQuery();){
                while (resultSet.next()){
                    flights.add(map(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flights;
    }

    @Override
    public Flights get(Long id) {
        if(id == null){
            throw new IllegalArgumentException("ID не задан");
        }

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_SQL + " WHERE flight_id = ?;");
        ) {
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery();){
                while (resultSet.next()){
                    return map(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public long count(FlightsFilter filter) {
        if(filter == null){
            filter = FlightsFilter.Builder.create().build();
        }

        List<Object> params = new ArrayList<>();

        String where = where(filter, params);

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(COUNT_SQL + where);
        ) {
            int index = 0;
            for (Object param : params) {
                statement.setObject(++index, param);
            }

            try(ResultSet resultSet = statement.executeQuery();){
                while (resultSet.next()){
                    return resultSet.getLong(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    private String where(FlightsFilter filter, List<Object> params){
        String where = "";

        if(filter.getArrivalAirport() != null){
            where += " arrival_airport = ?";
            params.add(filter.getArrivalAirport());
        }

        if(filter.getDepartureAirport() != null){
            if(where.length() > 0){
                where += " AND ";
            }
            where += " departure_airport = ?";
            params.add(filter.getDepartureAirport());
        }

        if(filter.getScheduledArrivalLocal() != null){
            if(where.length() > 0){
                where += " AND ";
            }
            where += " scheduled_arrival_local = ?";
            params.add(filter.getScheduledArrivalLocal());
        }

        if(filter.getScheduledDepartureLocal() != null){
            if(where.length() > 0){
                where += " AND ";
            }
            where += " scheduled_departure_local = ?";
            params.add(filter.getScheduledDepartureLocal());
        }

        if(where.length() > 0){
            where = " WHERE " + where;
        }

        return where;
    }

    private Flights map(ResultSet rs) throws SQLException {
        return Flights.Builder.create()
                .setFlightId(rs.getLong("flight_id"))
                .setFlightNo(rs.getString("flight_no"))
                .setScheduledDeparture(rs.getObject("scheduled_departure", OffsetDateTime.class))
                .setScheduledArrival(rs.getObject("scheduled_arrival", OffsetDateTime.class))
                .setDepartureAirport(rs.getString("departure_airport"))
                .setArrivalAirport(rs.getString("arrival_airport"))
                .setStatus(rs.getString("status"))
                .setAircraftCode(rs.getString("aircraft_code"))
                .setActualDeparture(rs.getObject("actual_departure", OffsetDateTime.class))
                .setActualArrival(rs.getObject("actual_arrival", OffsetDateTime.class))
                .build();
    }

    @Override
    public void close() throws Exception {
        ConnectionFactory.close();
    }

    public static FlightsDao getInstance() {
        return instance;
    }
}
