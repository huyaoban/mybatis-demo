package com.huyaoban.mybatis3.services;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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
		List<Map<String, Object>> students = service.findAllStudents();
		Assert.assertNotNull(students);
		
		for (Map<String, Object> student : students) {
			Iterator<String> itr = student.keySet().iterator();
			while (itr.hasNext()) {
				String key = itr.next();
				System.out.print(key + " = " + student.get(key).toString()
						+ ",");
			}
			System.out.println("\n");
		}
	}
	
	@Test
	public void testFindStudentById() {
		Map<String, Object> student = service.findStudentById(5);
		Assert.assertNotNull(student);
		Iterator<String> itr = student.keySet().iterator();
		while (itr.hasNext()) {
			String key = itr.next();
			System.out.print(key + " = " + student.get(key).toString());
		}
		System.out.println("\n");
	}
}
