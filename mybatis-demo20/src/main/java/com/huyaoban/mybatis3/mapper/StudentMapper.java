package com.huyaoban.mybatis3.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huyaoban.mybatis3.domain.Student;
import com.huyaoban.mybatis3.paging.PageInfo;

public interface StudentMapper {
	public Student findStudentById(Integer studId);
	public void createStudent(Student student);

	public List<Student> findAllStudentsByPage(@Param("pageInfo") PageInfo pageInfo);
	public void createStudentWithGeneratedKey(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(Integer id);
}
