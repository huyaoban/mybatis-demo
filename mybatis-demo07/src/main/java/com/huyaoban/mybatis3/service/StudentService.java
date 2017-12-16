package com.huyaoban.mybatis3.service;

import java.util.List;
import java.util.Map;

public interface StudentService {
	public List<Map<String, Object>> findAllStudents();
	public Map<String, Object> findStudentById(Integer id);
}
