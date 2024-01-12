package com.salescope.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection  con= null;
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/salescope", "root", "database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnectionObject() {
		return con;
	}
	
	public static Connection getUserDBConnectionObject(String uname) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+uname, "root", "database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
