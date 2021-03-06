package com.huyaoban.mybatis3.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huyaoban.mybatis3.domain.Student;
import com.huyaoban.mybatis3.mapper.StudentMapper;
import com.huyaoban.mybatis3.paging.Page;
import com.huyaoban.mybatis3.paging.PageInterceptor;
import com.huyaoban.mybatis3.service.StudentService;
import com.huyaoban.mybatis3.util.MyBatisSqlSessionFactory;

public class StudentServiceImpl implements StudentService {
	private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	public Student findStudentById(Integer studId) {
		logger.debug("select student by id :{}", studId);
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			return mapper.findStudentById(studId);
		} finally {
			sqlSession.close();
		}
	}

	public void createStudent(Student student) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			mapper.createStudent(student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public Page findAllStudents(int pageNum, int pageSize) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			PageInterceptor.startPage(pageNum, pageSize);
			mapper.findAllStudents();
			return PageInterceptor.endPage();
		} finally {
			sqlSession.close();
		}
	}

	public void createStudentWithGeneratedKey(Student student) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			mapper.createStudentWithGeneratedKey(student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void updateStudent(Student student) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			mapper.updateStudent(student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void deleteStudent(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			mapper.deleteStudent(id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
