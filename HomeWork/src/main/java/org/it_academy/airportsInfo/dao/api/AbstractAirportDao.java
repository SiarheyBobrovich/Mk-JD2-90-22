package org.it_academy.airportsInfo.dao.api;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.it_academy.airportsInfo.dto.api.BaseAirportObject;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public abstract class AbstractAirportDao<T extends BaseAirportObject> implements IAirportDao<T> {

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
            throw new RuntimeException("Проверьте правильность драйвера");
        }

        pool.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        pool.setUser("postgres");
        pool.setPassword("172143");

        return pool;
    }
}
