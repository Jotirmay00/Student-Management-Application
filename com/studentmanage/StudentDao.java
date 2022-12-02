package com.studentmanage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	public static boolean InsertStudentToDb(Student st) 
	{
		boolean f =false;
		try {
			
			Connection con =cp.createC();
			String q = "insert into students(sname,sphone,scity) value(?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(q);
			
			
			pstmt.setString(1,st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			pstmt.executeUpdate();
			f =true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int userId) {
		boolean f =false;
		try {
			
			Connection con =cp.createC();
			String q = "delete from students where sid=?";
			PreparedStatement pstmt=con.prepareStatement(q);
			
			
			pstmt.setInt(1,userId);
			
			
			pstmt.executeUpdate();
			f =true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

	public static void showAllStudents() {
		
		
		try {
			
			Connection con =cp.createC();
			String q = "select * from students;";
			Statement stmt =con.createStatement();
			
			ResultSet set=stmt.executeQuery(q);
			
			while(set.next()) {
				int id =set.getInt(1);
				String name = set.getString(2);
				String phone =set.getString(3);
				String city = set.getString("scity");
			
				
				System.out.println("Id : "+id);
				System.out.println("Name : "+name);
				System.out.println("Phone : "+phone);
				System.out.println("City : "+city);
				System.out.println("*********************************");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static boolean updateStudent(int userId,String name,String phone,String city) {
		boolean f =false;
		try {
			
			Connection con =cp.createC();
			String q = "update students set sname=?,sphone=?,scity=? where sid=?";
			
			PreparedStatement stmt = con.prepareStatement(q);
			
			stmt.setString(1, name);
			stmt.setString(2, phone);
			stmt.setString(3, city);
			stmt.setInt(4,userId);
			
			stmt.executeUpdate();
			f =true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
}
