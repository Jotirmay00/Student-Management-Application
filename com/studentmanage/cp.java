package com.studentmanage;

import java.sql.Connection;
import java.sql.DriverManager;

public class cp {
	
	
	 static Connection con;
	
	
	public static Connection createC() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String user = "root";
			String password ="Hadapsar00#";
			String url ="jdbc:mysql://localhost:3306/student_manage";
			
			con = DriverManager.getConnection(url,user,password);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
