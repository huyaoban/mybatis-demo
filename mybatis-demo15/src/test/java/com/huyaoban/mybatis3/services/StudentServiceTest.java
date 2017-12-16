package com.huyaoban.mybatis3.services;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.huyaoban.mybatis3.domain.Gender;
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
	public void testFindAllStudents() {
		List<Student> students = service.findAllStudents();
		Assert.assertNotNull(students);
		
		for(Student student : students) {
			Assert.assertNull(student.getAddress());
		}
	}
	
	@Test
	public void testFindStudentById() {
		Student student = service.findStudentById(5);
		Assert.assertNotNull(student);
		Assert.assertNotNull(student.getAddress());
		System.out.println(student);
	}

	@Test
	public void testCreateStudent() {
		Student s = service.findStudentById(5);
		Student student = new Student();
		student.setName("jerry-test");
		student.setEmail("fset@own.com");
		student.setGender(Gender.MALE);
		student.setDob(new Date());
		student.setAddress(s.getAddress());
		student.setPhone(s.getPhone());
		service.createStudent(student);

		Student newStudent = service.findStudentById(student.getStudId());
		Assert.assertNotNull(newStudent);
	}
}
