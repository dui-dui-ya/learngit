package com.baizhi.chenly.service;

import java.util.List;

import com.baizhi.chenly.dao.AddressDao;
import com.baizhi.chenly.entity.Address;
import com.baizhi.chenly.util.MyBatisUtil;

public class AddressServiceImpl implements AddressService{
	private AddressDao dao = (AddressDao) MyBatisUtil.getMapper(AddressDao.class);
	//添加地址
	@Override
	public void insertAddress(Address address) {
		try{
			dao.insertAddress(address);
			MyBatisUtil.commit();
		}catch(Exception e){
			MyBatisUtil.rollback();
			e.printStackTrace();
			throw new RuntimeException("添加地址异常！~");
		}finally{
			MyBatisUtil.close();
		}
	}
	//删除地址
	@Override
	public void deleteAddressById(Integer addressId) {
		try{
			dao.deleteAddressById(addressId);
			MyBatisUtil.commit();
		}catch(Exception e){
			MyBatisUtil.rollback();
			e.printStackTrace();
			throw new RuntimeException("删除地址异常");
		}finally{
			MyBatisUtil.close();
		}
	}
	//根据用户id查询用户所有的 地址
	@Override
	public List<Address> selectAllAddress(Integer userId) {
		List<Address> addresses = dao.selectAllAddress(userId);
		return addresses;
	}
	//根据地址id查询某个地址信息
	@Override
	public Address selectAddressById(Integer addressId) {
		Address address = dao.selectAddressById(addressId);
		return address;
	}
	

}
