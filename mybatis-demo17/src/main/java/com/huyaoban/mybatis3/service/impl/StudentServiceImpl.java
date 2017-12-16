package com.huyaoban.mybatis3.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huyaoban.mybatis3.domain.Student;
import com.huyaoban.mybatis3.mapper.StudentMapper;
import com.huyaoban.mybatis3.service.StudentService;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
	private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentMapper studentMapper;

	public Student findStudentById(Integer studId) {
		logger.debug("select student by id :{}", studId);

		return studentMapper.findStudentById(studId);
	}

	public List<Student> findAllStudents() {
		return studentMapper.findAllStudents();
	}

	public void createStudent(Student student) {
		studentMapper.createStudent(student);
	}
}
