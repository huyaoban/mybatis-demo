package com.huyaoban.mybatis3.service;

import com.huyaoban.mybatis3.domain.Student;

public interface StudentService {
	public Student findStudentById(Integer studId);
	
	public void createStudent(Student student);
}
