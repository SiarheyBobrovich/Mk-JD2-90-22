package org.it_academy.messenger.main;

import org.it_academy.messenger.dao.LoginDao;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        LoginDao loginDao = new LoginDao();
        Connection connection = loginDao.getConnection();
    }
}
