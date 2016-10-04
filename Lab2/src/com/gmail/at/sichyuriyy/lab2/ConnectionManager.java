package com.gmail.at.sichyuriyy.lab2;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {

	private static ConnectionManager connectionManager;
	private static final String DATA_SOURCE_NAME = "java:/MySqlDSLabs";

	private DataSource ds;

	private ConnectionManager() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DATA_SOURCE_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionManager getInastance() {
		if (connectionManager == null) {
			connectionManager = new ConnectionManager();
		}
		return connectionManager;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("Connection is not avaible");
		}
		return conn;
	}

}
