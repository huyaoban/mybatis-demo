package com.huyaoban.mybatis3.services;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.huyaoban.mybatis3.domain.Student;
import com.huyaoban.mybatis3.service.StudentService;
import com.huyaoban.mybatis3.service.impl.StudentServiceImpl;

public class StudentServiceTest {
	public static StudentService service;
	
	@BeforeClass
	public static void setUp() {
		service = new StudentServiceImpl();
	}

	@AfterClass
	public static void tearDown() {
		service = null; 
	}
	
	@Test
	public void testCreateStudent() {
		Student student = new Student();
		int id = 3;
		student.setStudId(id);
		student.setName("student_" + id);
		student.setEmail("student_" + id + "@gmail.com");
		student.setDob(new Date());
		
		service.createStudent(student);
		
		Student newStudent = service.findStudentById(id);
		Assert.assertNotNull(newStudent);
		System.out.println(student);
	}
	
	@Test
	public void testFindAllStudents() {
		List<Student> students = service.findAllStudents();
		Assert.assertNotNull(students);
		
		for(Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindStudentById() {
		Student student = service.findStudentById(3);
		Assert.assertNotNull(student);
		System.out.println(student);
	}
}
