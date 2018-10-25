package com.baizhi.chenly.entity;

import java.io.Serializable;
import java.util.HashMap;

public class Cart implements Serializable{
	private Double totalPrice;//总价
	private Double savePrice;//节省价
	private HashMap<String,CartItem> showCartMap;//用于展示的购物车集合
	private HashMap<String,CartItem> removeCartMap;//用于删除保存的购物车集合
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Cart [totalPrice=" + totalPrice + ", savePrice=" + savePrice
				+ ", showCartMap=" + showCartMap + ", removeCartMap="
				+ removeCartMap + "]";
	}


	public Cart(Double totalPrice, Double savePrice,
			HashMap<String, CartItem> showCartMap,
			HashMap<String, CartItem> removeCartMap) {
		super();
		this.totalPrice = totalPrice;
		this.savePrice = savePrice;
		this.showCartMap = showCartMap;
		this.removeCartMap = removeCartMap;
	}


	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Double getSavePrice() {
		return savePrice;
	}
	public void setSavePrice(Double savePrice) {
		this.savePrice = savePrice;
	}
	public HashMap<String, CartItem> getShowCartMap() {
		return showCartMap;
	}
	public void setShowCartMap(HashMap<String, CartItem> showCartMap) {
		this.showCartMap = showCartMap;
	}
	public HashMap<String, CartItem> getRemoveCartMap() {
		return removeCartMap;
	}
	public void setRemoveCartMap(HashMap<String, CartItem> removeCartMap) {
		this.removeCartMap = removeCartMap;
	}
	
}
