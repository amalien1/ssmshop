package com.zzw.service;

import com.zzw.pojo.User;
/**
 * 用户service
 * @author amalien
 *
 */
public interface UserService {
	//用户登录
	public User login(User user);
	//用户注册
	public boolean register(User user);
	//通过用户名获取用户
	public User selectUserByUsername(String username);
	//用户信息的更新
	public void update(User user);
}	
