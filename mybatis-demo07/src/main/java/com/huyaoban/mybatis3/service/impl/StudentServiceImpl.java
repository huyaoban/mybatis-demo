package com.huyaoban.mybatis3.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huyaoban.mybatis3.mapper.StudentMapper;
import com.huyaoban.mybatis3.service.StudentService;
import com.huyaoban.mybatis3.util.MyBatisSqlSessionFactory;

public class StudentServiceImpl implements StudentService {
	private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	public Map<String, Object> findStudentById(Integer studId) {
		logger.debug("select student by id :{}", studId);
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			return mapper.findStudentById(studId);
		} finally {
			sqlSession.close();
		}
	}

	public List<Map<String, Object>> findAllStudents() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			return mapper.findAllStudents();
		} finally {
			sqlSession.close();
		}
	}
}
