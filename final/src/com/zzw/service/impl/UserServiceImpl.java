package com.zzw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzw.dao.UserDao;
import com.zzw.pojo.User;
import com.zzw.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	//用户登录
	@Override
	public User login(User user) {
		return userDao.login(user);
	}
	//用户注册
	@Override
	public boolean register(User user) {
		if(null==userDao.selectUserByUsername(user.getUsername())){
			userDao.register(user);
			return true;
		}
		return false;
	}
	//通过用户名查询user
	@Override
	public User selectUserByUsername(String username) {
		return userDao.selectUserByUsername(username);
	}
	//更新用户信息
	@Override
	public void update(User user) {
		userDao.update(user);
	}
	
}	
