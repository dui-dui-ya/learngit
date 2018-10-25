package com.baizhi.chenly.entity;

import java.io.Serializable;

public class Address implements Serializable{
	private Integer addressId;
	private String name;//收件人姓名
	private String detailAddress;//地址
	private String zipcode;
	private String telphone;
	private String addrMobile;
	//关系属性
	private User user;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(Integer addressId, String name, String detailAddress,
			String zipcode, String telphone, String addrMobile, User user) {
		super();
		this.addressId = addressId;
		this.name = name;
		this.detailAddress = detailAddress;
		this.zipcode = zipcode;
		this.telphone = telphone;
		this.addrMobile = addrMobile;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", name=" + name
				+ ", detailAddress=" + detailAddress + ", zipcode=" + zipcode
				+ ", telphone=" + telphone + ", addrMobile=" + addrMobile
				+ ", user=" + user + "]";
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getAddrMobile() {
		return addrMobile;
	}
	public void setAddrMobile(String addrMobile) {
		this.addrMobile = addrMobile;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
