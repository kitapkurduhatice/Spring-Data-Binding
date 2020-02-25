package com.hatice.springdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
	
	public static String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	public static Connection myConn;

	public static Employees getEmployees(int employeesId) {
	
		
		try {
			
			myConn = DriverManager.getConnection(dbUrl,"hr","hr");
			PreparedStatement stmt = myConn.prepareStatement(
					"Select *" 
					+" from employees where employee_id=?");
			
			stmt.setInt(1,employeesId);
		
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return new Employees(employeesId,
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getInt("salary"));
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
				
	}

	
	
		



}
