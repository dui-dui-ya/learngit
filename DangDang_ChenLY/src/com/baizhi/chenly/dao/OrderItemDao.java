package com.baizhi.chenly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.chenly.entity.OrderItem;

public interface OrderItemDao {
	//添加订单项，并返回订单的id
	Integer insertOrderItem(
			@Param(value="orderItem")OrderItem orderItem);
	//删除订单项
	void deleteOrderItemById(
			@Param(value="shopId")Integer shopId);
	//根据订单表id查询所有订单项
	List<OrderItem> selectAllOrderItem(
			@Param(value="orderId")Integer orderId);
	//根据订单项id查询订单
	OrderItem selectOrderItemById(
			@Param(value="shopId")Integer shopId);
	
}
