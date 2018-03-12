package com.huyaoban.mybatis3.service;

import java.util.List;

import com.huyaoban.mybatis3.domain.Student;
import com.huyaoban.mybatis3.paging.PageInfo;

public interface StudentService {
	/**
	 * 分页查询
	 * 
	 * @param pageNum
	 *            当前页码
	 * @param pageSize
	 *            每页大小
	 * @return
	 */
	public List<Student> findAllStudents(PageInfo pageInfo);
	public Student findStudentById(Integer id);
	public void createStudent(Student student);
	public void createStudentWithGeneratedKey(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(Integer id);
}
