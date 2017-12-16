package com.huyaoban.mybatis3.service;

import java.util.List;

import com.huyaoban.mybatis3.domain.Student;

public interface StudentService {
	public List<Student> findAllStudents();
	public Student findStudentById(Integer id);
	public void createStudent(Student student);
}
