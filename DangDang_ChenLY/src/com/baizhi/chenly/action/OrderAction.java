package com.baizhi.chenly.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.baizhi.chenly.entity.Address;
import com.baizhi.chenly.entity.Cart;
import com.baizhi.chenly.entity.CartItem;
import com.baizhi.chenly.entity.Order;
import com.baizhi.chenly.entity.OrderItem;
import com.baizhi.chenly.entity.User;
import com.baizhi.chenly.service.AddressService;
import com.baizhi.chenly.service.AddressServiceImpl;
import com.baizhi.chenly.service.BookService;
import com.baizhi.chenly.service.BookServiceImpl;
import com.baizhi.chenly.service.OrderItemService;
import com.baizhi.chenly.service.OrderItemServiceImpl;
import com.baizhi.chenly.service.OrderService;
import com.baizhi.chenly.service.OrderServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class OrderAction extends ActionSupport{
	private Integer newAddressId;
	//获取地址信息
	//private Address address;
	private String uuid;
	//所有的订单项
	private List<OrderItem> orderItems= new ArrayList<OrderItem>();
	private OrderItemService ois = new OrderItemServiceImpl();
	private BookService bs = new BookServiceImpl();
	private OrderService os = new OrderServiceImpl();
	private AddressService as = new AddressServiceImpl(); 
	private ValueStack vs = ActionContext.getContext().getValueStack();
	//添加订单项
	public String addOrderItem(){
		//从session中获取showMap
		Cart cart = (Cart) vs.findValue("#session.cart");
		//新生成一个订单
		/*UUID uuid = UUID.randomUUID();
		Integer orderId = os.insertOrder(new Order(null,uuid,));*/
		HashMap<String,CartItem> showCartMap = cart.getShowCartMap();
		//将showCartMap中的购物项添加入订单项中
		Set<String> keys = showCartMap.keySet();
		//List<Integer> shopIds = new ArrayList<Integer>();
		//for (Integer index : shopIds) {
		for (String k : keys) {
			CartItem cartItem = showCartMap.get(k);
			OrderItem orderItem = new OrderItem(null, bs.queryByBookId(cartItem.getBookId()),null ,cartItem.getAmount() , cartItem.getBookDprice()*cartItem.getAmount());
			//将所有的订单项添加入订单项表
			Integer shopId = ois.insertOrderItem(orderItem);
			//将所有的订单项id存入list集合中
			orderItems.add(orderItem);
		}
		return "order_info";
	}
	//生成订单
	public String addOrder(){
		//获取值栈用来获取总价
		Cart cart = (Cart) vs.findValue("#session.cart");
		User user = (User) vs.findValue("#session.user");
		//用uuid生成订单号
		uuid = UUID.randomUUID().toString();
		//根据用户id查询所有的订单项
		List<OrderItem> orderItems = ois.selectAllOrderItem(user.getUserId());
		//生成订单
		//System.out.println(uuid+"!~~~~~~~Action");
		//System.out.println(newAddressId);
		Address address2 = as.selectAddressById(newAddressId);
		//System.out.println(address2);
		Integer orderId = os.insertOrder(new Order(null,uuid,new Date(),cart.getTotalPrice(),address2,user,null,orderItems));
		//删除showmap集合中的数据
		Set<String> keys = cart.getShowCartMap().keySet();
		for (String k : keys) {
			cart.getShowCartMap().remove(k);
		}
		//删除订单项表中的数据
		//保留
		return "order_ok";
	}
	//删除订单
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public Integer getNewAddressId() {
		return newAddressId;
	}
	public void setNewAddressId(Integer newAddressId) {
		this.newAddressId = newAddressId;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
}
