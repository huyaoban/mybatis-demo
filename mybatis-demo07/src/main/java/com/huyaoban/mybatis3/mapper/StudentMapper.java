package com.huyaoban.mybatis3.mapper;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
	public Map<String, Object> findStudentById(Integer studId);
	public List<Map<String, Object>> findAllStudents();
}
