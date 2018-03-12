package com.huyaoban.mybatis3.services;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.huyaoban.mybatis3.domain.Student;
import com.huyaoban.mybatis3.paging.PageInfo;
import com.huyaoban.mybatis3.service.StudentService;
import com.huyaoban.mybatis3.service.impl.StudentServiceImpl;

import junit.framework.Assert;

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
	
	/**
	 * 测试分页查询
	 */
	@Test
	public void testFindAllStudents() {
		// 第一页
		List<Student> students1 = service.findAllStudents(new PageInfo(1, 4));
		Assert.assertNotNull(students1);
		
		for (Student obj : students1) {
			System.out.println(obj);
		}

		// 第二页
		List<Student> students2 = service.findAllStudents(new PageInfo(2, 4));
		Assert.assertNotNull(students2);

		for (Student obj : students2) {
			System.out.println(obj);
		}

		// 第三页
		List<Student> students3 = service.findAllStudents(new PageInfo(3, 4));
		Assert.assertNotNull(students3);

		for (Student obj : students3) {
			System.out.println(obj);
		}

		// 第四页
		List<Student> students4 = service.findAllStudents(new PageInfo(4, 4));
		Assert.assertNotNull(students4);

		for (Student obj : students4) {
			System.out.println(obj);
		}
	}

}
