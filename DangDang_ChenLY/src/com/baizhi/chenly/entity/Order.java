package com.baizhi.chenly.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable{
	private Integer orderId;
	private String num;//订单编号
	private Date createDate;//生成订单的时间
	private Double price;//订单总价
	//关系属性，关联地址id
	private Address address;//地址id
	//关系属性，关联用户id
	private User user;
	//状态属性
	private Integer status;
	//关系属性，关联订单项
	private List<OrderItem> orderItems;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", num=" + num + ", createDate="
				+ createDate + ", price=" + price + ", address=" + address
				+ ", user=" + user + ", status=" + status + ", orderItems="
				+ orderItems + "]";
	}


	public Order(Integer orderId, String num, Date createDate, Double price,
			Address address, User user, Integer status,
			List<OrderItem> orderItems) {
		super();
		this.orderId = orderId;
		this.num = num;
		this.createDate = createDate;
		this.price = price;
		this.address = address;
		this.user = user;
		this.status = status;
		this.orderItems = orderItems;
	}


	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
}
