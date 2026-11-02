package com.mikimup.database;

import java.sql.Connection;

/**
 * @author Felda Ardelia Oktrianti
 */
public interface DBConnector {

    Connection getConnection() throws Exception;
}
