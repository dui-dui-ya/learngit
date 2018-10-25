package com.baizhi.chenly.service;

import com.baizhi.chenly.entity.Order;

public interface OrderService {
	//添加订单，并返回订单的主键id
	Integer insertOrder(Order order);
	//根据id删除订单
	void deleteOrderById(Integer orderId);
	//根据id查询订单信息
	Order selectOrderById(Integer orderId);
}
