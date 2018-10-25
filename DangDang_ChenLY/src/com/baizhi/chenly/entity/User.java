package com.baizhi.chenly.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	private Integer userId;
	private String userEmail;
	private String userPassword;
	private String userName;
	private Integer userStatus;
	//关系属性
	private List<Order> userOrders;
	private List<Address> addresses;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer userId, String userEmail, String userPassword,
			String userName, Integer userStatus, List<Order> userOrders,
			List<Address> addresses) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userStatus = userStatus;
		this.userOrders = userOrders;
		this.addresses = addresses;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userStatus=" + userStatus + ", userOrders=" + userOrders
				+ ", addresses=" + addresses + "]";
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	public List<Order> getUserOrders() {
		return userOrders;
	}
	public void setUserOrders(List<Order> userOrders) {
		this.userOrders = userOrders;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
}
