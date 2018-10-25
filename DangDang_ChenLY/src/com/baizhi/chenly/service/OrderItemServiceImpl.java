package com.baizhi.chenly.service;

import java.util.List;


import javax.persistence.criteria.CriteriaBuilder.In;

import com.baizhi.chenly.dao.OrderItemDao;
import com.baizhi.chenly.entity.OrderItem;
import com.baizhi.chenly.util.MyBatisUtil;

public class OrderItemServiceImpl implements OrderItemService{
	
	//添加一个订单项
	@Override
	public Integer insertOrderItem(OrderItem orderItem) {
		//增删改必须加入事物控制
		try{
			OrderItemDao dao = (OrderItemDao) MyBatisUtil.getMapper(OrderItemDao.class);
			Integer shopId = dao.insertOrderItem(orderItem);
			MyBatisUtil.commit();
			return shopId;
		}catch(Exception e){
			MyBatisUtil.rollback();
			e.printStackTrace();
			throw new RuntimeException("添加订单项错误");
		}finally{
			MyBatisUtil.close();
		}
	}
	//删除一个订单项
	@Override
	public void delectOrderItem(Integer shopId) {
		try{
			OrderItemDao dao = (OrderItemDao) MyBatisUtil.getMapper(OrderItemDao.class);
			dao.deleteOrderItemById(shopId);
			MyBatisUtil.commit();
		}catch(Exception e){
			MyBatisUtil.rollback();
			e.printStackTrace();
			throw new RuntimeException("删除一个订单项有误！~");
		}finally{
			MyBatisUtil.close();
		}
	}
	//查询所有订单项
	@Override
	public List<OrderItem> selectAllOrderItem(Integer userId) {
		OrderItemDao dao = (OrderItemDao) MyBatisUtil.getMapper(OrderItemDao.class);
		List<OrderItem> orderItems = dao.selectAllOrderItem(userId);
		return orderItems;
	}
	@Override
	public OrderItem selectOrderItemById(Integer shopId) {
		OrderItemDao dao = (OrderItemDao) MyBatisUtil.getMapper(OrderItemDao.class);
		//System.out.println(shopId);
		OrderItem orderItem = dao.selectOrderItemById(shopId);
		//System.out.println(orderItem);
		return orderItem;
	}
	
}
