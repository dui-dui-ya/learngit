<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			$(function(){
				//判断邮箱是否合法
				$('#txtEmail').blur(
					function checkEmail(){
						var emailVal = $(this).val();
						console.log(emailVal);
						/* @之前必须有内容且只能是字母（大小写）、数字、下划线(_)、减号（-）、点（.）

						@和最后一个点（.）之间必须有内容且只能是字母（大小写）、数字、点（.）、减号（-），且两个点不能挨着

						最后一个点（.）之后必须有内容且内容只能是字母（大小写）、数字且长度为大于等于2个字节，小于等于6个字节 */
						
						//console.log(/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/.test(emailVal));
						//if(/(^[a~zA~Z0~9]{5,15}@[a~zA~Z0~9]{1,10}\.[c][o][m]$)/.test(emailVal)){
						if(/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/.test(emailVal)){
							$('#emailHid').css('display','none');
							
						}else{
							$('#emailHid').css('display','');
						}
					}
				);
				//密码是否合法
				$('#txtPassword').blur(
					function checkPassword(){
						var pwdVal=$(this).val();
						//console.log(pwdVal);
						//console.log(/^(?=.*[0-9])(?=.*[a-z])([0-9a-z]{6,18})$/.test(pwdVal));
						if(/^(?=.*[0-9])([0-9]{6,18})$/.test(pwdVal)){
							//如果密码有包含数字和字母，则红字消失
							//console.log(/^(?=.*[0-9])(?=.*[a-z])([0-9a-z]{6,18})$/.test(pwdVal));
							$('#pwdHid').css('display','none');
						}else{
							$('#pwdHid').css('display','');
						}
					}		
				);
				//再次判断密码是否合法
				$('#txtPassword1').blur(
					function checkPassword(){
						var pwdVal1=$(this).val();
						//console.log(pwdVal);
						//console.log(/^(?=.*[0-9])(?=.*[a-z])([0-9a-z]{6,18})$/.test(pwdVal));
						if(/^(?=.*[0-9])([0-9]{6,18})$/.test(pwdVal1)){
							//如果密码有包含数字和字母，则红字消失
							//console.log(/^(?=.*[0-9])(?=.*[a-z])([0-9a-z]{6,18})$/.test(pwdVal1));
							$('#pwdHid1').css('display','none');
						}else{
							$('#pwdHid1').css('display','');
						}
					}		
				);
				 //判断名称是否合法
				$('#txtNickName').blur(
					function checkNickName(){   
						var nickNameVal = $(this).val();
						if(/(^[a-zA-Z0-9]{4,}$)/.test(nickNameVal)){
							//console.log(usernameVal);
							$('#nickNameHid').css('display','none');
						}else{
							$('#nickNameHid').css('display','');
						}
					}
				);
				
			});
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
		<%-- <s:url value='/user/user_regist'></s:url> --%>
			<form name="ctl00" method="post" action="<s:url value='/user/user_register'></s:url>" id="f">
				<h2>
					以下均为必填项
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="userEmail" type="text" id="txtEmail" class="text_input"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
									
								</p>
									<span id="emailHid" style="display:;color:red;font-size:12px;">*请输入合法的邮箱</span>
									<span id="email.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="userName" type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="nickNameHid" style="display:;color:red;font-size:12px;">*请输入至少四位用户名账号!</span>
								<span id="name.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="userPassword" type="password" id="txtPassword"
								class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
									
								</p>
								<span id="pwdHid" style="color:red;font-size:12px;">*请输入6-18位字母加数字密码</span>
								<span id="password.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" type="password" id="txtPassword1"
								class="text_input"/>
							<div class="text_left" id="repeatPassValidMsg">
							<span id="pwdHid1" style="color:red;font-size:12px;">*请输入6-18位字母加数字密码</span>
							<span id="password1.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="<s:url value='/user/Security'></s:url>" />
							<input name="number" type="text" id="txtVerifyCode"
								class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									
									<span id="number.info" style="color:red"></span>
									<a href="" >看不清楚？换个图片</a>
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

