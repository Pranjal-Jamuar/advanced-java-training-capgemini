package com.lpu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteOperation {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/LPU";
		String user = "postgres";
		String password = "lilly@2808";
		// TODO Auto-generated method stub
		try {
			// Step 1: load the driver			
			Class.forName("org.postgresql.Driver");
			System.out.println("Databse loaded");
			
			// Step 2: create connection			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println(con);
			
			// Step 3			
			Statement stm = con.createStatement();
			
			// Step 4			
			stm.execute("delete from student where id = 11");
			
			// Step 5			
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

	}

}
