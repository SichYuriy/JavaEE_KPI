package com.gmail.at.sichyuriyy.lab2;

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
	
	private static DbConnection dbConnection;

	private Connection connection;

	private final String userName = "root";
	private final String password = "123root321";
	private final String useSSL = "false";
	private final String dbms = "mysql";
	private final String host = "localhost";
	private final String port = "3306";
	private final String dbName = "movie_database";
	
	public static DbConnection getInstance() {
		if (dbConnection == null) {
			dbConnection = new DbConnection();
		}
		return dbConnection; 
	}

	private DbConnection() {

		Properties connectionProps = new Properties();
		
		connectionProps.put("user", userName);
		connectionProps.put("password", password);
		connectionProps.put("useSSL", useSSL);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:" + dbms + "://" + host + ":" + port + "/" + dbName, connectionProps);
		} catch (SQLException ex) {
			Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
