package com.baizhi.chenly.service;

import java.util.List;

import com.baizhi.chenly.entity.Address;

public interface AddressService {
	//添加订单地址
	void insertAddress(Address address);
	//删除订单
	void deleteAddressById(Integer addressId);
	//根据用户id查询用户所有的地址
	List<Address> selectAllAddress(Integer userId);
	//根据地址id查询某个地址信息
	Address selectAddressById(Integer addressId);
}
