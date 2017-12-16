package com.huyaoban.mybatis3.services;

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
	public void testFindAllStudents() {
		List<Student> students = service.findAllStudents();
		Assert.assertNotNull(students);
		
		for(Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testFindStudentById() {
		Student student = service.findStudentById(5);
		Assert.assertNotNull(student);
		System.out.println(student);
	}
}
