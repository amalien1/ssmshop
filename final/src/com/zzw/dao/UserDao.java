package com.zzw.dao;

import com.zzw.pojo.User;
/**
 * 用户dao
 * @author amalien
 *
 */
public interface UserDao {
	//用户登录
	public User login(User user);
	//通过用户名获取用户
	public User selectUserByUsername(String username);
	//通过id获取用户
	public User selectUserById(Integer id);
	//用户注册
	public void register(User user);
	//用户信息更新
	public void update(User user);
}
