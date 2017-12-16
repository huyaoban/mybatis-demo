package com.huyaoban.mybatis3.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huyaoban.mybatis3.domain.Course;
import com.huyaoban.mybatis3.mapper.CourseMapper;
import com.huyaoban.mybatis3.service.CourseService;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseMapper courseMapper;

	public void createCourse(Course course) {
		courseMapper.createCourse(course);
	}

	public Course findCourseById(Integer id) {
		return courseMapper.findCourseById(id);
	}

	public List<Course> searchCourses(Map<String, Object> map) {
		return courseMapper.searchCourses(map);
	}

	public List<Course> searchCoursesUsingChoose(Map<String, Object> map) {
		return courseMapper.searchCoursesUsingChoose(map);
	}

	public List<Course> findCourseByTutorId(Integer id) {
		return courseMapper.findCourseByTutorId(id);
	}

	public List<Course> searchCourseUsingWhere(Map<String, Object> map) {
		return courseMapper.searchCourseUsingWhere(map);
	}

	public List<Course> searchCourseUsingTrim(Map<String, Object> map) {
		return courseMapper.searchCourseUsingTrim(map);
	}

	public List<Course> searchCourseUsingForeach(Map<String, Object> map) {
		return courseMapper.searchCourseUsingForeach(map);
	}

	public List<Course> searchCourseUsingForeachIn(Map<String, Object> map) {
		return courseMapper.searchCourseUsingForeachIn(map);
	}

	public void updateCourseUsingSet(Course c) {
		courseMapper.updateCourseUsingSet(c);
	}

}
