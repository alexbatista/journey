package com.webservice.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/journey","root","p5kplam");
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		} 
		
	}
}
