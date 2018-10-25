package com.baizhi.chenly.service;

import com.baizhi.chenly.entity.User;

public interface UserService {
	//登录
	User selectUserByEmailAndPassword(String userEmail,String userPassword);
	//注册
	void insertUser(User user);
	//更新用户状态
	void updateUser(User user);
}
