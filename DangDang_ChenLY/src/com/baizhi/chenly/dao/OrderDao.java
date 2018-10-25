package com.baizhi.chenly.dao;

import org.apache.ibatis.annotations.Param;

import org.junit.runners.Parameterized.Parameters;

import com.baizhi.chenly.entity.Order;

public interface OrderDao {
	//添加订单
	Integer insertOrder(
			@Param(value="order")Order order);
	//删除订单
	void deleteOrderById(
			@Param(value="orderId")Integer orderId);
	//根据orderId查询订单
	Order selectOrderById(
			@Param(value="orderId")Integer orderId);
	
}
