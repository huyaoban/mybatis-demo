package com.huyaoban.mybatis3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huyaoban.mybatis3.domain.UserPic;
import com.huyaoban.mybatis3.mapper.UserPicMapper;
import com.huyaoban.mybatis3.service.UserPicService;

@Service("userPicService")
@Transactional
public class UserPicServiceImpl implements UserPicService {
	@Autowired
	private UserPicMapper userPicMapper;

	public UserPic findUserPicById(Integer id) {
		return userPicMapper.findUserPicById(id);
	}

	public void createUserPic(UserPic userPic) {
		userPicMapper.createUserPic(userPic);
	}

	public List<UserPic> findUserPicByIdAndName(Integer id, String name) {
		return userPicMapper.findUserPicByIdAndName(id, name);
	}

}
