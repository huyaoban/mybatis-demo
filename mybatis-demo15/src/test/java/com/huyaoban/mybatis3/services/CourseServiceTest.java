package com.huyaoban.mybatis3.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.huyaoban.mybatis3.domain.Course;
import com.huyaoban.mybatis3.service.CourseService;
import com.huyaoban.mybatis3.service.impl.CourseServiceImpl;

public class CourseServiceTest {
	private static CourseService service;

	@BeforeClass
	public static void setUp() {
		service = new CourseServiceImpl();
	}

	@AfterClass
	public static void tearDown() {
		service = null;
	}

	private Course buildCourse() {
		Course course = new Course();
		course.setName("test course");
		course.setDescription("test description");
		course.setStartDate(new Date());
		course.setTutorId(1);

		return course;
	}

	@Test
	public void testCreateCourseAndFindCourseById() {
		Course course = buildCourse();
		service.createCourse(course);
		
		Course newCourse = service.findCourseById(course.getCourseId());
		Assert.assertNotNull(newCourse);
	}

	@Test
	public void testSearchCourse() {
		Course course = buildCourse();
		service.createCourse(course);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1);
		map.put("courseName", "%test%");

		List<Course> courses = service.searchCourses(map);
		Assert.assertNotNull(courses);
	}

	@Test
	public void testSearchCourseUsingWhere() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1);
		map.put("courseName", "%test%");

		List<Course> courses = service.searchCourseUsingWhere(map);
		Assert.assertNotNull(courses);
		Assert.assertTrue(courses.size() > 0);
	}

	@Test
	public void testSearchCourseUsingTrim() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1);
		map.put("courseName", "%test%");

		List<Course> courses = service.searchCourseUsingTrim(map);
		Assert.assertNotNull(courses);
		Assert.assertTrue(courses.size() > 0);
	}

	@Test
	public void testSearchCourseUsingForeach() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> ids = new ArrayList<String>();
		ids.add("1");
		ids.add("2");
		map.put("tutorIds", ids);

		List<Course> courses = service.searchCourseUsingForeach(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			System.out.println(c);
		}
	}

	@Test
	public void testSearchCourseUsingForeachIn() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> ids = new ArrayList<String>();
		ids.add("1");
		ids.add("2");
		map.put("tutorIds", ids);

		List<Course> courses = service.searchCourseUsingForeachIn(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			System.out.println(c);
		}
	}

	@Test
	public void testUpdateCourse() {
		Course c = service.findCourseById(1);
		Assert.assertNotNull(c);

		String newName = "new name";
		String newDescription = "new description";
		c.setName(newName);
		c.setDescription(newDescription);

		service.updateCourseUsingSet(c);

		Course newC = service.findCourseById(c.getCourseId());
		Assert.assertTrue(newName.equals(newC.getName()));
		Assert.assertTrue(newDescription.equals(newC.getDescription()));
	}
}
