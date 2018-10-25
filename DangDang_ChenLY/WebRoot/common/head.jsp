<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<link href="../css/book_head090107.css" rel="stylesheet" type="text/css" />
<div class="head_container">
	<div class="head_welcome">
		<div class="head_welcome_right">
			<span class="head_welcome_text"> </span>
			<span class="head_welcome_text"> <span class="little_n">
					| <a href="#" name="mydangdang" class="head_black12a">我的当当</a> | <a
					href="#" name="helpcenter" class="head_black12a" target="_blank">帮助</a>
					| </span> </span>
			<div class="cart gray4012">
				<a href="../cart/cart_list.jsp">购物车</a>
			</div>
		</div>
		<span class="head_toutext" id="logininfo">
		<b>您好，欢迎光临当当网</b>
		<s:property value="#session.user.userName"/>
		
		<s:if test="#session.user==null">
			[&nbsp;<a href="<s:url value='/user/login_form.jsp'></s:url>" class="b">登录</a>|
			<a href="<s:url value='/user/register_form.jsp'></s:url>" class="b">注册</a>&nbsp;]
		</s:if>
		<s:else>
			[&nbsp;<a href="<s:url value="/user/user_salfOut"></s:url>" class="b">登出</a>&nbsp;]
		</s:else>
		
		</span>
	</div>
	<div class="head_head_list">
		<div class="head_head_list_left">
			<span class="head_logo"><a href="#" name="backtobook"><img
						src="../images/booksaleimg/book_logo.gif" /> </a> </span>
		</div>
		<div class="head_head_list_right">

			<div class="head_head_list_right_b">
			</div>
		</div>
	</div>
	<div class="head_search_div">

	</div>
	<div class="head_search_bg"></div>
</div>