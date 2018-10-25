package com.baizhi.chenly.service;

import com.baizhi.chenly.dao.OrderDao;
import com.baizhi.chenly.entity.Order;
import com.baizhi.chenly.util.MyBatisUtil;

public class OrderServiceImpl implements OrderService{
	private OrderDao os = (OrderDao) MyBatisUtil.getMapper(OrderDao.class);
	//添加订单并返回订单主键id
	@Override
	public Integer insertOrder(Order order) {
		try{
			//System.out.println(order.getNum()+"!~~~~~~~~~~Service");
			Integer orderId = os.insertOrder(order);
			MyBatisUtil.commit();
			return orderId;
		}catch(Exception e){
			MyBatisUtil.rollback();
			e.printStackTrace();
			throw  new RuntimeException("添加定  单错误！~");
		}finally{
			MyBatisUtil.close();
		}
	}

	@Override
	public void deleteOrderById(Integer orderId) {
		try{
			os.deleteOrderById(orderId);
			
		}catch(Exception e){
			MyBatisUtil.rollback();
			e.printStackTrace();
			throw new RuntimeException("删除订单有误！·");
		}finally{
			MyBatisUtil.close();
		}
	}

	@Override
	public Order selectOrderById(Integer orderId) {
		Order order = os.selectOrderById(orderId);
		return order;
	}

}
