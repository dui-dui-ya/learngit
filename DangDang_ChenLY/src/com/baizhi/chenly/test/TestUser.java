package com.baizhi.chenly.test;

import org.junit.Test;

import com.baizhi.chenly.entity.Address;
import com.baizhi.chenly.entity.User;
import com.baizhi.chenly.service.AddressService;
import com.baizhi.chenly.service.AddressServiceImpl;
import com.baizhi.chenly.service.UserService;
import com.baizhi.chenly.service.UserServiceImpl;

public class TestUser {
	@Test
	public void testUpdate(){
		UserService us = new UserServiceImpl();
		us.updateUser(new User(2,null,null,null,1,null,null));
	}
	@Test
	public void testAddress(){
		AddressService as=new AddressServiceImpl();
		Address address = as.selectAddressById(2);
		System.out.println(address);
	}
}
