package com.huyaoban.mybatis3.services;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.huyaoban.mybatis3.domain.Student;
import com.huyaoban.mybatis3.paging.Page;
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
		Page page = service.findAllStudents(1, 4);
		Assert.assertNotNull(page);
		
		for (Object obj : page.getData()) {
			System.out.println((Student) obj);
		}

		// 第二页
		Page page1 = service.findAllStudents(2, 4);
		Assert.assertNotNull(page1);

		for (Object obj : page1.getData()) {
			System.out.println((Student) obj);
		}

		// 第三页
		Page page2 = service.findAllStudents(3, 4);
		Assert.assertNotNull(page2);

		for (Object obj : page2.getData()) {
			System.out.println((Student) obj);
		}

		// 第四页
		Page page3 = service.findAllStudents(4, 4);
		Assert.assertNotNull(page3);

		for (Object obj : page3.getData()) {
			System.out.println((Student) obj);
		}
	}

}
