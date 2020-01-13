package com.cognizant.moviecrusier.dao;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

	static Connection getConnection() {

		// Read the property from property file -> connection.properties
		BufferedInputStream bufferedInputStream = (BufferedInputStream) ConnectionHandler.class.getClassLoader()
				.getResourceAsStream("connection.properties");
		Properties prop = new Properties();
		try {
			prop.load(bufferedInputStream);
		} catch (IOException e) {
			System.out.println("Unable to load/find connection.properties file");
		}
		String driver = (String) prop.get("driver");
		//System.out.println("Driver Name->" + driver);
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load the mysql driver" + e.getMessage());
		}
		String user = (String) prop.get("user");
		String password = (String) prop.getProperty("password");
		String url = (String) prop.get("connection-url");
		Connection connection = null;
		try {
			// A Connection (session) with a specified database
			// DriverrManager class will attempt to load the driver classes
			connection = DriverManager.getConnection(url, user, password);
		//	System.out.println(connection);
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
		}
		return connection;
	}

	public static void main(String[] args) {

	}
}
