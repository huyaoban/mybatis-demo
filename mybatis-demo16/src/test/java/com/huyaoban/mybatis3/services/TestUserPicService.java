package com.huyaoban.mybatis3.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huyaoban.mybatis3.domain.UserPic;
import com.huyaoban.mybatis3.service.UserPicService;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class TestUserPicService {
	@Autowired
	private UserPicService userPicService;

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

		userPicService.createUserPic(userPic);
		UserPic newPic = userPicService.findUserPicById(userPic.getId());
		Assert.assertNotNull(newPic);
	}

	@Test
	public void testFindUserPicByIdAndName() {
		Integer id = 1;
		String name = "UserName";

		List<UserPic> pics = userPicService.findUserPicByIdAndName(id, name);
		Assert.assertNotNull(pics);
		Assert.assertTrue(pics.size() > 0);
	}
}
