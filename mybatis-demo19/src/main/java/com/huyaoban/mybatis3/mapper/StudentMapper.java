package com.huyaoban.mybatis3.mapper;

import java.util.List;

import com.huyaoban.mybatis3.domain.Student;

public interface StudentMapper {
	public Student findStudentById(Integer studId);
	public void createStudent(Student student);
	public List<Student> findAllStudents();
	public void createStudentWithGeneratedKey(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(Integer id);
}
