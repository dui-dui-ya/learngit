package com.baizhi.chenly.service;

import java.util.List;

import com.baizhi.chenly.entity.OrderItem;

public interface OrderItemService {
	//添加订单项
	Integer insertOrderItem(OrderItem orderItem);
	//删除订单项
	void delectOrderItem(Integer shopId);
	//查询用户所有订单项
	List<OrderItem> selectAllOrderItem(Integer userId);
	//根据shopId查询订单项
	OrderItem selectOrderItemById(Integer shopId);
}
