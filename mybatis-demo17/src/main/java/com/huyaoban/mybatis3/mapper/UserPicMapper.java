package com.huyaoban.mybatis3.mapper;

import java.util.List;

import com.huyaoban.mybatis3.domain.UserPic;

public interface UserPicMapper {
	public UserPic findUserPicById(Integer id);

	public void createUserPic(UserPic userPic);
	
	public List<UserPic> findUserPicByIdAndName(Integer id, String name);
}
