package com.huyaoban.mybatis3.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.huyaoban.mybatis3.domain.UserPic;

public interface UserPicService {
	public UserPic findUserPicById(Integer id);

	public void createUserPic(UserPic userPic);
	
	public List<UserPic> findUserPicByIdAndName(Integer id, String name);

	public Map<Integer, UserPic> findAllUserPics();

	public List<UserPic> findAllUserPics(RowBounds rowBounds);

	public Map<Integer, String> getUserPicIdAndNameMap();
}
