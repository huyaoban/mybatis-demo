package com.huyaoban.mybatis3.services;

import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.huyaoban.mybatis3.domain.Course;
import com.huyaoban.mybatis3.domain.Tutor;
import com.huyaoban.mybatis3.service.TutorService;
import com.huyaoban.mybatis3.service.impl.TutorServiceImpl;

public class TutorServiceTest {
	private static TutorService service;

	@BeforeClass
	public static void setUp() {
		service = new TutorServiceImpl();
	}

	@AfterClass
	public static void tearDown() {
		service = null;
	}

	@Test
	public void testFindTutorById() {
		Tutor tutor = service.findTutorById(2);
		Assert.assertNotNull(tutor);
		Assert.assertNotNull(tutor.getCourses());

		List<Course> courses = tutor.getCourses();
		Iterator<Course> itr = courses.iterator();
		while (itr.hasNext()) {
			Course c = itr.next();
			System.out.println(c);
		}
	}

}
