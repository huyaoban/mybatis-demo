package com.huyaoban.mybatis3;

import java.util.Date;

import com.huyaoban.mybatis3.domain.Student;
import com.huyaoban.mybatis3.service.StudentService;
import com.huyaoban.mybatis3.service.impl.StudentServiceImpl;

public class JdbcMain {
	public static void main(String[] args) {
		Student student = new Student();
		student.setStudId(1);
		student.setName("jerry.hu");
		student.setEmail("jerry.hu@oceanwing.com");
		student.setDob(new Date());
		
		StudentService service = new StudentServiceImpl();
		service.createStudent(student);
	}
}
