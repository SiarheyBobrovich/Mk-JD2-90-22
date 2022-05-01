package org.it_academy.messenger.dao;

import java.sql.Connection;

public class LoginDao {

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");



        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Проверь правильность драйвера и соединения с базой", e);
        }

        return connection;
    }

}
