package com.baizhi.chenly.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.chenly.entity.Address;
import com.baizhi.chenly.entity.OrderItem;
import com.baizhi.chenly.service.AddressService;
import com.baizhi.chenly.service.AddressServiceImpl;
import com.baizhi.chenly.service.OrderItemService;
import com.baizhi.chenly.service.OrderItemServiceImpl;

public class TestOrderDao {
	OrderItemService os = new OrderItemServiceImpl();
	@Test
	public void testAll() {
		List<OrderItem> orderItems = os.selectAllOrderItem(001);
		for (OrderItem item : orderItems) {
			System.out.println(item);
		}
	}
	@Test
	public void testAllAddress() {
		AddressService as = new AddressServiceImpl();
		List<Address> adds = as.selectAllAddress(1);
		for (Address add : adds) {
			System.out.println(add);
		}
	}
	@Test
	public void testInsert() {
		List<OrderItem> orderItems = os.selectAllOrderItem(001);
		for (OrderItem item : orderItems) {
			System.out.println(item);
		}
	}

	@Test
	public void testSelectOrderItem() {
		OrderItem orderItem = os.selectOrderItemById(25);
		System.out.println(orderItem);
		
	}
}
