package com.baizhi.chenly.dao;

import org.apache.ibatis.annotations.Param;

import com.baizhi.chenly.entity.User;

public interface UserDao {
	//根据email密码查询用户信息
	User selectByEmailAndPassword(
			@Param(value="userEmail")String userEmail,
			@Param(value="userPassword")String userPassword); 
	//添加用户，注册
	void insertUser(
			@Param(value="user")User user);
	//更改用户状态信息
	void updateUser(
			@Param(value="user")User user);
	
}
