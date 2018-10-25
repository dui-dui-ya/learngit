package com.baizhi.chenly.action;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.baizhi.chenly.entity.Cart;
import com.baizhi.chenly.entity.User;
import com.baizhi.chenly.service.UserService;
import com.baizhi.chenly.service.UserServiceImpl;
import com.baizhi.chenly.util.SecurityCode;
import com.baizhi.chenly.util.SecurityImage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport{
	private String userEmail;
	private String userPassword;
	private String password1;
	private String userName;
	//获取用户输入的验证码
	private String number;
	//private User user;
	//获取用户激活邮箱的码
	private String emailNumber;
	private UserService us = new UserServiceImpl();
	private ValueStack vs = ActionContext.getContext().getValueStack(); 
	//登录
	public String login(){
		//密码加密
		//MD5Util.getStringMD5(number).
		User user = us.selectUserByEmailAndPassword(userEmail, userPassword);
		if(user==null){//说明登录失败，跳回登录页面
			return "login";
		}
		//登录成功则将用户放入session作用域中
		vs.setValue("#session.user", user);
		Cart cart = (Cart) vs.findValue("#session.cart");
		if(cart!=null){//session不为空，说明是强制登录
			return "findAllAddress";
		}else{
			return "main";
		}
	}
	//注册
	public String register(){
		//判断验证码是否正确.获取验证码随机数
		String code = (String) vs.findValue("#session.CAPTCHA_CODE");
		//判断两次密码是否一致
		//判断数据库中是否有相同的邮箱和密码
		if(code.equalsIgnoreCase(number)){
			//如果相同则继续判断
			if(userPassword.equals(password1)){
				//相同则查询数据库中是否存在相同的邮箱和密码、
				//System.out.println(userEmail);
				User oldUser = us.selectUserByEmailAndPassword(userEmail, userPassword);
				if(oldUser==null){
					//如果为空则，证明数据库中没有这条信息，添加
					//System.out.println(userName);
					us.insertUser(new User(null, userEmail, userPassword, userName, null, null, null));
					//将user对象放入session中
					User user = us.selectUserByEmailAndPassword(userEmail, userPassword);
					//System.out.println(user);
					vs.setValue("#session.user", user);
					//vs.setValue("#session.EMAIL_CODE", emailCode);
					//注册成功，跳入验证邮页面
					return "EmailSecurity";
				}else{
					//否则，若不为空，跳转回注册页面
					return "register_form";
				}
			}else{
				//相同的，跳转回注册页面，提示邮箱密码已存在
				return "register_form";
			}
		}else{
			//验证码错误，返回注册页面，提示验证码错误
			return "register_form";
		}
	}
	//验证邮箱是否激活
	public String openEmial(){
		String emailCode = (String) vs.findValue("#session.EMAIL_CODE");
		if(emailCode.equalsIgnoreCase(emailNumber)){
			//激活成功
			//调用set方法将user表的状态设为1
			User oldUser = (User) vs.findValue("#session.user");
			//System.out.println(oldUser);
			us.updateUser(new User(oldUser.getUserId(),oldUser.getUserEmail(),oldUser.getUserPassword(),oldUser.getUserName(),1,null,null));
			User user = us.selectUserByEmailAndPassword(oldUser.getUserEmail(), oldUser.getUserPassword());
			//查询新的user再次放入session中
			//System.out.println(user);
			vs.setValue("#session.user", user);
			System.out.println(vs.findValue("#session.user"));
			//返回
			return "register_ok";
		}
		return "verify_form";
	}
	//生成邮箱激活验证码
		public String EmailSecurity(){
			String emailCode = SecurityCode.getSecurityCode();
			vs.setValue("#session.EMAIL_CODE", emailCode);
			
			return "verify_form";
		}
	//生成验证码
	public String Security() throws Exception{
		//生成验证码随机数
		String code = SecurityCode.getSecurityCode();
		//将随机数存入session:便于登录时做验证码的校验
		vs.setValue("#session.CAPTCHA_CODE", code);
		//使用验证码随机数创建验证码图片
		BufferedImage image = SecurityImage.createImage(code);
		//响应到客户端
		OutputStream out = ServletActionContext.getResponse().getOutputStream();
		/*
		 * 参数一：验证码图片对象
		 * 参数二：响应图片格式
		 * 参数三：输出字节流
		 */
		ImageIO.write(image, "png", out);
		//return null表示没有任何跳转
		return null;
	}
	
	//安全退出
	public String salfOut(){
		//需要将session中的user移除
		vs.setValue("#session.user", null);
		//清空购物车中的session
		vs.setValue("#session.cart", null);
		//跳回主页面
		return "main";
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
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmailNumber() {
		return emailNumber;
	}
	public void setEmailNumber(String emailNumber) {
		this.emailNumber = emailNumber;
	}
	
	
}
