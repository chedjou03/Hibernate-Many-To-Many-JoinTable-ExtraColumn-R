package com.hibernate.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJdbc {

	public static void main(String[] args) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false";
		String user = "student";		
		String pass = "student";
		try 
		{
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			System.out.println("Connection successful ! ! ");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
