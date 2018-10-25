package com.baizhi.chenly.service;

import com.baizhi.chenly.dao.UserDao;
import com.baizhi.chenly.entity.User;
import com.baizhi.chenly.util.MyBatisUtil;

public class UserServiceImpl implements UserService{
	
	@Override
	public User selectUserByEmailAndPassword(String userEmail,
			String userPassword) {
		UserDao dao = (UserDao) MyBatisUtil.getMapper(UserDao.class);
		User user = dao.selectByEmailAndPassword(userEmail, userPassword);
		return user;
	}

	@Override
	public void insertUser(User user) {
		try{
			UserDao dao = (UserDao) MyBatisUtil.getMapper(UserDao.class);
			dao.insertUser(user);
			MyBatisUtil.commit();
		}catch(Exception e){
			MyBatisUtil.rollback();
			e.printStackTrace();
		}finally{
			MyBatisUtil.close();
		}
		
	}

	@Override
	public void updateUser(User user) {
		try{
			UserDao dao = (UserDao) MyBatisUtil.getMapper(UserDao.class);
			//System.out.println(user);
			dao.updateUser(user);
			MyBatisUtil.commit();
		}catch(Exception e){
			MyBatisUtil.rollback();
			e.printStackTrace();
		}finally{
			MyBatisUtil.close();
		}
		
	}
	
}
