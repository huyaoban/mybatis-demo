package com.huyaoban.mybatis3.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.huyaoban.mybatis3.domain.Course;
import com.huyaoban.mybatis3.mapper.CourseMapper;
import com.huyaoban.mybatis3.service.CourseService;
import com.huyaoban.mybatis3.util.MyBatisSqlSessionFactory;

public class CourseServiceImpl implements CourseService {

	public void createCourse(Course course) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
			mapper.createCourse(course);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public Course findCourseById(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
			return mapper.findCourseById(id);
		} finally {
			sqlSession.close();
		}
	}

	public List<Course> searchCourses(Map<String, Object> map) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
			return mapper.searchCourses(map);
		} finally {
			sqlSession.close();
		}
	}

	public List<Course> searchCoursesUsingChoose(Map<String, Object> map) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
			return mapper.searchCoursesUsingChoose(map);
		} finally {
			sqlSession.close();
		}
	}

	public List<Course> findCourseByTutorId(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
			return mapper.findCourseByTutorId(id);
		} finally {
			sqlSession.close();
		}
	}

	public List<Course> searchCourseUsingWhere(Map<String, Object> map) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
			return mapper.searchCourseUsingWhere(map);
		} finally {
			sqlSession.close();
		}
	}

	public List<Course> searchCourseUsingTrim(Map<String, Object> map) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
			return mapper.searchCourseUsingTrim(map);
		} finally {
			sqlSession.close();
		}
	}

	public List<Course> searchCourseUsingForeach(Map<String, Object> map) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
			return mapper.searchCourseUsingForeach(map);
		} finally {
			sqlSession.close();
		}
	}

	public List<Course> searchCourseUsingForeachIn(Map<String, Object> map) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
			return mapper.searchCourseUsingForeachIn(map);
		} finally {
			sqlSession.close();
		}
	}

	public void updateCourseUsingSet(Course c) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
			mapper.updateCourseUsingSet(c);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

}
