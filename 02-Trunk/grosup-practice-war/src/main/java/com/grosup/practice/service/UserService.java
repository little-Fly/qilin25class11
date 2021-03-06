package com.grosup.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grosup.practice.beans.User;
import com.grosup.practice.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User queryTest(int id) {
		return userDao.queryTest(id);
	}
	
	/**
	 * 人员注册
	 * @param user
	 * @return 变化条数
	 */
	public int userRegister(User user) {
		return userDao.userRegister(user);
	}
}
