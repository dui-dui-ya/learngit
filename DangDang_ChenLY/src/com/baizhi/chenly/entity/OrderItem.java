package com.baizhi.chenly.entity;

import java.io.Serializable;


public class OrderItem implements Serializable{
	private Integer shopId;
	//关系属性，关系书籍表
	private Book book;
	//关系属性，关联订单
	private Order order;
	private Integer shopNum;
	private Double totalPrice;//小计
	
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Integer getShopNum() {
		return shopNum;
	}
	public void setShopNum(Integer shopNum) {
		this.shopNum = shopNum;
	}
	

	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "OrderItem [shopId=" + shopId + ", book=" + book + ", order="
				+ order + ", shopNum=" + shopNum + ", totalPrice=" + totalPrice
				+ "]";
	}
	public OrderItem(Integer shopId, Book book, Order order, Integer shopNum,
			Double totalPrice) {
		super();
		this.shopId = shopId;
		this.book = book;
		this.order = order;
		this.shopNum = shopNum;
		this.totalPrice = totalPrice;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
