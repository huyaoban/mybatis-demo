package com.huyaoban.mybatis3.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huyaoban.mybatis3.domain.Course;
import com.huyaoban.mybatis3.service.CourseService;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:applicationContext.xml" })
// @ContextConfiguration({ "classpath:spring/spring-dao.xml",
// "classpath:spring/spring-service.xml" })
public class CourseServiceTest {
	@Autowired
	private CourseService courseService;

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
		courseService.createCourse(course);
		
		Course newCourse = courseService.findCourseById(course.getCourseId());
		Assert.assertNotNull(newCourse);
	}

	@Test
	public void testSearchCourse() {
		Course course = buildCourse();
		courseService.createCourse(course);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1);
		map.put("courseName", "%test%");

		List<Course> courses = courseService.searchCourses(map);
		Assert.assertNotNull(courses);
	}

	@Test
	public void testSearchCourseUsingWhere() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1);
		map.put("courseName", "%test%");

		List<Course> courses = courseService.searchCourseUsingWhere(map);
		Assert.assertNotNull(courses);
		Assert.assertTrue(courses.size() > 0);
	}

	@Test
	public void testSearchCourseUsingTrim() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1);
		map.put("courseName", "%test%");

		List<Course> courses = courseService.searchCourseUsingTrim(map);
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

		List<Course> courses = courseService.searchCourseUsingForeach(map);
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

		List<Course> courses = courseService.searchCourseUsingForeachIn(map);
		Assert.assertNotNull(courses);
		for (Course c : courses) {
			System.out.println(c);
		}
	}

	@Test
	public void testUpdateCourse() {
		Course c = courseService.findCourseById(1);
		Assert.assertNotNull(c);

		String newName = "new name";
		String newDescription = "new description";
		c.setName(newName);
		c.setDescription(newDescription);

		courseService.updateCourseUsingSet(c);

		Course newC = courseService.findCourseById(c.getCourseId());
		Assert.assertTrue(newName.equals(newC.getName()));
		Assert.assertTrue(newDescription.equals(newC.getDescription()));
	}
}
