package com.huyaoban.mybatis3.services;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.huyaoban.mybatis3.domain.PhoneNumber;
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
		
		PhoneNumber phone = new PhoneNumber("+86", "0746", "18942511014");
		//PhoneNumber phone = new PhoneNumber();
		student.setPhone(phone);
		
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
	
	@Test
	public void testCreateStudentWithGeneratedKey() {
		Student student = new Student();
		student.setName("liuxiarong");
		student.setEmail("liuxiarong@gmail.com");
		student.setDob(new Date());
		
		PhoneNumber phone = new PhoneNumber("86", "0594", "13459488471");
		student.setPhone(phone);
		
		Integer oldId = student.getStudId();
		service.createStudentWithGeneratedKey(student);
		System.out.println("oldStudId = " + oldId);
		System.out.println("newStudId = " + student.getStudId());
		Assert.assertFalse(oldId == student.getStudId());
		
		Student newStudent = service.findStudentById(student.getStudId());
		Assert.assertNotNull(newStudent);
		System.out.println(newStudent);
	}
	
	@Test
	public void testUpdateStudent() {
		Student student = service.findStudentById(3);
		Assert.assertNotNull(student);
		
		String newName = "new name for update student";
		student.setName(newName);
		
		service.updateStudent(student);
		
		Student newStudent = service.findStudentById(student.getStudId());
		Assert.assertEquals(newName, newStudent.getName());
		Assert.assertTrue(newName.equals(newStudent.getName()));
		
	}
	
	@Test
	public void testDeleteStudent() {
		int id = 3;
		service.deleteStudent(id);
		
		Student student = service.findStudentById(id);
		Assert.assertNull(student);
	}
}
