package com.huyaoban.mybatis3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huyaoban.mybatis3.domain.Tutor;
import com.huyaoban.mybatis3.mapper.TutorMapper;
import com.huyaoban.mybatis3.service.TutorService;

@Service("tutorService")
@Transactional
public class TutorServiceImpl implements TutorService {
	@Autowired
	private TutorMapper tutorMapper;

	public Tutor findTutorById(Integer id) {
		return tutorMapper.findTutorById(id);
	}

}
