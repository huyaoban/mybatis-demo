package com.huyaoban.mybatis3.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.huyaoban.mybatis3.domain.Tutor;
import com.huyaoban.mybatis3.mapper.TutorMapper;
import com.huyaoban.mybatis3.service.TutorService;
import com.huyaoban.mybatis3.util.MyBatisSqlSessionFactory;

public class TutorServiceImpl implements TutorService {

	public Tutor findTutorById(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			TutorMapper mapper = sqlSession.getMapper(TutorMapper.class);
			return mapper.findTutorById(id);
		} finally {
			sqlSession.close();
		}
	}

}
