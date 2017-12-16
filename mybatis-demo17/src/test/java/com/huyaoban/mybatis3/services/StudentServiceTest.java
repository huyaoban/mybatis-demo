package com.huyaoban.mybatis3.services;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huyaoban.mybatis3.domain.Gender;
import com.huyaoban.mybatis3.domain.Student;
import com.huyaoban.mybatis3.service.StudentService;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:applicationContext.xml",
		"classpath:mybatis-spring.xml" })
public class StudentServiceTest {
	@Autowired
	private StudentService studentService;

	@Test
	public void testFindAllStudents() {
		List<Student> students = studentService.findAllStudents();
		Assert.assertNotNull(students);
		
		for(Student student : students) {
			Assert.assertNull(student.getAddress());
		}
	}
	
	@Test
	public void testFindStudentById() {
		Student student = studentService.findStudentById(5);
		Assert.assertNotNull(student);
		Assert.assertNotNull(student.getAddress());
		System.out.println(student);
	}

	@Test
	public void testCreateStudent() {
		Student s = studentService.findStudentById(5);
		Student student = new Student();
		student.setName("jerry-test");
		student.setEmail("fset@own.com");
		student.setGender(Gender.MALE);
		student.setDob(new Date());
		student.setAddress(s.getAddress());
		student.setPhone(s.getPhone());
		studentService.createStudent(student);

		Student newStudent = studentService
				.findStudentById(student.getStudId());
		Assert.assertNotNull(newStudent);
	}
}
