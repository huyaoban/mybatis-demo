package com.huyaoban.mybatis3.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huyaoban.mybatis3.domain.Student;
import com.huyaoban.mybatis3.mapper.StudentMapper;
import com.huyaoban.mybatis3.service.StudentService;
import com.huyaoban.mybatis3.util.MyBatisSqlSessionFactory;

public class StudentServiceImpl implements StudentService {
	private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	public Student findStudentById(Integer studId) {
		logger.debug("select student by id :{}", studId);
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentById(studId);
		} finally {
			sqlSession.close();
		}
	}

	public void createStudent(Student student) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.createStudent(student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public List<Student> findAllStudents() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudents();
		} finally {
			sqlSession.close();
		}
	}
}
