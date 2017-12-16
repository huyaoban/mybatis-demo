package com.huyaoban.mybatis3.mapper;

import java.util.List;

import com.huyaoban.mybatis3.domain.Student;

public interface StudentMapper {
	public Student findStudentById(Integer studId);
	public List<Student> findAllStudents();
}
