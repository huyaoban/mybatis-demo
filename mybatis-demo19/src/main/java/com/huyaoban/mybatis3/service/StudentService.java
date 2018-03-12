package com.huyaoban.mybatis3.service;

import com.huyaoban.mybatis3.domain.Student;
import com.huyaoban.mybatis3.paging.Page;

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
	public Page findAllStudents(int pageNum, int pageSize);
	public Student findStudentById(Integer id);
	public void createStudent(Student student);
	public void createStudentWithGeneratedKey(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(Integer id);
}
