package com.huyaoban.mybatis3.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.huyaoban.mybatis3.domain.Student;
import com.huyaoban.mybatis3.service.StudentService;

public class StudentServiceImpl implements StudentService {

	public Student findStudentById(Integer studId) {
		Student student = null;
		Connection connection = null;
		
		try {
			connection = this.getDatabaseConnection();
			
			String sql = "select * from students where stud_id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, studId);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				student = new Student();
				student.setStudId(rs.getInt("stud_id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				student.setDob(rs.getDate("dob"));
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch(SQLException e) {
					
				}
			}
		}
		
		return student;
	}

	public void createStudent(Student student) {
		Connection connection = null;
		try {
			connection = this.getDatabaseConnection();
			
			String sql = "insert into students (stud_id, name, email, dob) values (?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, student.getStudId());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getEmail());
			pstmt.setDate(4, new java.sql.Date(student.getDob().getTime()));
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch(SQLException e) {
					
				}
			}
		}

	}

	protected Connection getDatabaseConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://192.168.119.10:3306/mybatis", "root", "root.123");
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
