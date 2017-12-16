package com.huyaoban.mybatis3.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.apache.ibatis.session.RowBounds;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.huyaoban.mybatis3.domain.UserPic;
import com.huyaoban.mybatis3.service.UserPicService;
import com.huyaoban.mybatis3.service.UserPicServiceImpl;

public class TestUserPicService {
	private UserPicService service;

	@Before
	public void setUp() {
		service = new UserPicServiceImpl();
	}

	@After
	public void tearDown() {
		service = null;
	}

	@Test
	public void testCreateUserPic() {
		byte[] pic = null;
		try {
			File file = new File("D:\\test.png");
			InputStream is = new FileInputStream(file);
			pic = new byte[is.available()];
			is.read(pic);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String name = "UserName";
		String bio = "test this is bio";
		UserPic userPic = new UserPic();
		userPic.setName(name);
		userPic.setPic(pic);
		userPic.setBio(bio);

		service.createUserPic(userPic);
		UserPic newPic = service.findUserPicById(userPic.getId());
		Assert.assertNotNull(newPic);
	}

	@Test
	public void testFindUserPicByIdAndName() {
		Integer id = 1;
		String name = "UserName";

		List<UserPic> pics = service.findUserPicByIdAndName(id, name);
		Assert.assertNotNull(pics);
		Assert.assertTrue(pics.size() > 0);
	}

	@Test
	public void testFindAllUserPics() {
		Map<Integer, UserPic> pics = service.findAllUserPics();
		Assert.assertNotNull(pics);
		Assert.assertTrue(pics.size() > 0);
	}

	@Test
	public void testFindAllUserPicsByPage() {
		int offset = 0; // 表示开始位置
		int limit = 5; // 表示每页的记录数
		System.out.println("offset = " + offset + ", limit = " + limit);
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<UserPic> page1 = service.findAllUserPics(rowBounds);
		Assert.assertNotNull(page1);
		Assert.assertTrue(page1.size() == 5);

		RowBounds rowBounds1 = new RowBounds(5, 10);
		List<UserPic> page2 = service.findAllUserPics(rowBounds);
		Assert.assertNotNull(page2);
		Assert.assertTrue(page2.size() == 5);
	}

	@Test
	public void testFindUserPicMap() {
		Map<Integer, String> map = service.getUserPicIdAndNameMap();
		Assert.assertNotNull(map);
		Set<Integer> keys = map.keySet();
		Iterator<Integer> itr = keys.iterator();
		while (itr.hasNext()) {
			Integer id = itr.next();
			String name = map.get(id);
			System.out.println("id = " + id + ", name = " + name);
		}
	}
}
