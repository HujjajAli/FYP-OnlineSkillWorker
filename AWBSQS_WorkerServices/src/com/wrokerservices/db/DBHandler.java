package com.wrokerservices.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHandler {
	
	private Connection con;
	
	
	//Constant Variable for Connection
	private final String URL      = "jdbc:mysql://localhost:3306/workerservicesdb";
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	
	public  DBHandler(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
		    con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("Connection Created");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getDBConnection() {
		return con;
	}

	
	

}
