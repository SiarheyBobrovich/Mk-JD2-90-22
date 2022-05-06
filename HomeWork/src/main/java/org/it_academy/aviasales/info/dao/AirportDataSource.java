package org.it_academy.aviasales.info.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class AirportDataSource {

    private static final AirportDataSource airportDataSource = new AirportDataSource();
    private final DataSource dataSource;

    private AirportDataSource() {
        this.dataSource = getPool();
    }

    /**
     * Singleton's getter
     * @return - link to DataSource object
     */
    public static AirportDataSource getInstance() {
        return airportDataSource;
    }

    /**
     * Getter for connect to JDBC
     * @return - connecting from pool
     * @throws SQLException - if connect has been closed
     */
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * Create and connect pool to JDBC
     * @return new data source object
     */
    private DataSource getPool() {
        ComboPooledDataSource pool = new ComboPooledDataSource();

        try {
            pool.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new RuntimeException("Проверьте правильность драйвера");
        }

        pool.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        pool.setUser("postgres");
        pool.setPassword("172143");

        return pool;
    }
}