package com.huyaoban.mybatis3.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huyaoban.mybatis3.domain.Student;
import com.huyaoban.mybatis3.service.StudentService;
import com.huyaoban.mybatis3.util.MyBatisSqlSessionFactory;

public class StudentServiceImpl implements StudentService {
	private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	public Student findStudentById(Integer studId) {
		logger.debug("select student by id :{}", studId);
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectOne("com.huyaoban.mybatis3.mapper.StudentMapper.findStudentById", studId);
		} finally {
			sqlSession.close();
		}
	}

	public void createStudent(Student student) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			sqlSession.insert("com.huyaoban.mybatis3.mapper.StudentMapper.createStudent", student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public List<Student> findAllStudents() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			return sqlSession.selectList("com.huyaoban.mybatis3.mapper.StudentMapper.findAllStudents");
		} finally {
			sqlSession.close();
		}
	}

	public void createStudentWithGeneratedKey(Student student) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			sqlSession.insert("com.huyaoban.mybatis3.mapper.StudentMapper.createStudentWithGeneratedKey", student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void updateStudent(Student student) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			sqlSession.update("com.huyaoban.mybatis3.mapper.StudentMapper.updateStudent", student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void deleteStudent(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			sqlSession.delete("com.huyaoban.mybatis3.mapper.StudentMapper.deleteStudent", id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
