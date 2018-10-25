package com.baizhi.chenly.action;

import java.util.List;

import com.baizhi.chenly.entity.Address;
import com.baizhi.chenly.entity.User;
import com.baizhi.chenly.service.AddressServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class AddressAction extends ActionSupport{
	private Integer userId;
	private Integer userAddressId;
	private Address address;
	private List<Address> addresses;
	private AddressServiceImpl as = new AddressServiceImpl(); 
	private ValueStack vs = ActionContext.getContext().getValueStack();
	//查询用户所有的地址
	public String findAllAddress(){
		//先判断session中是否有user，强制登录
		//获取用户的id
		User user = (User) vs.findValue("#session.user");
		if(user==null){
			//未登录则跳入登录界面
			return "login";
		}else{
			addresses = as.selectAllAddress(user.getUserId());
			/*for (Address address : addresses) {
				System.out.println(address);
			}*/
			vs.setValue("#session.addresses", addresses);
			return "address_form";
		}
	}
	//根据地址id查询某一条地址信息
	public String findAddressById(){
		//System.out.println(userAddressId);
		if(userAddressId!=0){
			//address前面再写Address我吃屎！！！！！！！！！！！！
			address = as.selectAddressById(userAddressId);
			//System.out.println(address);
			//不知道为啥， jsp死活取不到address中的值，不得已只能放入session中传输
			//ActionContext.getContext().getValueStack().setValue("#session.address", address);
		}
		
		return "address_form2";
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public Integer getUserAddressId() {
		return userAddressId;
	}
	public void setUserAddressId(Integer userAddressId) {
		this.userAddressId = userAddressId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
