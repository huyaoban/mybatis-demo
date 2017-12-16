package com.huyaoban.mybatis3.services;

import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huyaoban.mybatis3.domain.Course;
import com.huyaoban.mybatis3.domain.Tutor;
import com.huyaoban.mybatis3.service.TutorService;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class TutorServiceTest {
	@Autowired
	private TutorService tutorService;

	@Test
	public void testFindTutorById() {
		Tutor tutor = tutorService.findTutorById(2);
		Assert.assertNotNull(tutor);
		Assert.assertNotNull(tutor.getCourses());

		List<Course> courses = tutor.getCourses();
		Iterator<Course> itr = courses.iterator();
		while (itr.hasNext()) {
			Course c = itr.next();
			System.out.println(c);
		}
	}

}
