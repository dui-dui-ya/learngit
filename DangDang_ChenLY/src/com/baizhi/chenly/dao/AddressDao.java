package com.baizhi.chenly.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.baizhi.chenly.entity.Address;

public interface AddressDao {
	//添加地址
	void insertAddress(Address address);
	//根据地址id删除地址
	void deleteAddressById(Integer addressId);
	//根据用户id查询用户所有地址信息
	List<Address> selectAllAddress(Integer userId);
	//根据id查询地址信息
	Address selectAddressById(Integer addressId);
}
