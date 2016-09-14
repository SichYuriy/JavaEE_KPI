package com.gmail.at.sichyuriyy.lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuriy
 */
public class DbConnection {

    private Connection connection;

    private final String userName = "root";
    private final String password = "123root321";
    private final String useSSL = "false";
    private final String dbms = "mysql";
    private final String host = "localhost";
    private final String dbName = "movie_database";

    public DbConnection() {

        Properties connectionProps = new Properties();

        connectionProps.put("user", userName);
        connectionProps.put("password", password);
        connectionProps.put("useSSL", useSSL);
        try {
            connection = DriverManager.getConnection(
                    "jdbc:" + dbms + "://" + host + "/" + dbName, connectionProps);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close(); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection() {
        return connection;
    }

}
