package com.mikimup.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Felda Ardelia Oktrianti
 */
public class MySQLConnection implements DBConnector {

    private final String URL = "jdbc:mysql://localhost:3306/mikimup_db";
    private final String USER = "root";
    private final String PASS = "12345678";

    @Override
    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
