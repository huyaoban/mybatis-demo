package com.huyaoban.mybatis3.service;

import java.util.List;
import java.util.Map;

import com.huyaoban.mybatis3.domain.Course;

public interface CourseService {
	public void createCourse(Course course);

	public Course findCourseById(Integer id);

	public List<Course> findCourseByTutorId(Integer id);

	public List<Course> searchCourses(Map<String, Object> map);

	public List<Course> searchCoursesUsingChoose(Map<String, Object> map);

	public List<Course> searchCourseUsingWhere(Map<String, Object> map);

	public List<Course> searchCourseUsingTrim(Map<String, Object> map);

	public List<Course> searchCourseUsingForeach(Map<String, Object> map);

	public List<Course> searchCourseUsingForeachIn(Map<String, Object> map);

	public void updateCourseUsingSet(Course c);
}
