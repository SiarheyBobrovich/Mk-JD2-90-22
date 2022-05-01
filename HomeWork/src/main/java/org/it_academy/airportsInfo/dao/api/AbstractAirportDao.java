package org.it_academy.airportsInfo.dao.api;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.it_academy.airportsInfo.dto.api.BaseAirportObject;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public abstract class AbstractAirportDao<T extends BaseAirportObject> implements IAirportDao<T> {

    public static final String ALL_AIRPORTS_SELECTOR =
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

    public static final String ALL_FLIGHTS_SELECTOR =
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


    private final DataSource dataSource;

    protected AbstractAirportDao() {
        this.dataSource = getPool();
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public void close(){
        ((ComboPooledDataSource) dataSource).close();
    }

    private DataSource getPool() {
        ComboPooledDataSource pool = new ComboPooledDataSource();

        try {
            pool.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException("Проверьте правильность драйвера", e);
        }

        pool.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        pool.setUser("postgres");
        pool.setPassword("172143");

        return pool;
    }
}
