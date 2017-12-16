package com.huyaoban.mybatis3.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.huyaoban.mybatis3.domain.UserPic;
import com.huyaoban.mybatis3.mapper.UserPicMapper;
import com.huyaoban.mybatis3.util.MyBatisSqlSessionFactory;

public class UserPicServiceImpl implements UserPicService {

	public UserPic findUserPicById(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			UserPicMapper mapper = sqlSession.getMapper(UserPicMapper.class);
			return mapper.findUserPicById(id);
		} finally {
			sqlSession.close();
		}
	}

	public void createUserPic(UserPic userPic) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			UserPicMapper mapper = sqlSession.getMapper(UserPicMapper.class);
			mapper.createUserPic(userPic);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public List<UserPic> findUserPicByIdAndName(Integer id, String name) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			UserPicMapper mapper = sqlSession.getMapper(UserPicMapper.class);
			return mapper.findUserPicByIdAndName(id, name);
		} finally {
			sqlSession.close();
		}
	}

	public Map<Integer, UserPic> findAllUserPics() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			return sqlSession.selectMap("com.huyaoban.mybatis3.mapper.UserPicMapper.findAllUserPics", "id");
		} finally {
			sqlSession.close();
		}
	}

	public List<UserPic> findAllUserPics(RowBounds rowBounds) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			return sqlSession
					.selectList(
							"com.huyaoban.mybatis3.mapper.UserPicMapper.findAllUserPics",
							null, rowBounds);
		} finally {
			sqlSession.close();
		}
	}

	public Map<Integer, String> getUserPicIdAndNameMap() {
		final Map<Integer, String> map = new HashMap<Integer, String>();
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			sqlSession.select("com.huyaoban.mybatis3.mapper.UserPicMapper.findAllUserPics", new ResultHandler() {

				public void handleResult(ResultContext context) {
					UserPic pic = (UserPic)context.getResultObject();
					map.put(pic.getId(), pic.getName());
				}
				
			});
		} finally {
			sqlSession.close();
		}
		return map;
	}

}
