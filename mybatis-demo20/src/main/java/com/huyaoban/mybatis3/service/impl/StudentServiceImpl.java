package com.huyaoban.mybatis3.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huyaoban.mybatis3.domain.Student;
import com.huyaoban.mybatis3.mapper.StudentMapper;
import com.huyaoban.mybatis3.paging.PageInfo;
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

	public List<Student> findAllStudents(PageInfo pageInfo) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

			return mapper.findAllStudentsByPage(pageInfo);
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
