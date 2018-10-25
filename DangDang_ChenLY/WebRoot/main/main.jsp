<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.8.3.min.js" ></script>
		<script type="text/javascript">
			$(function(){
				$('.smallImg').mouseover(
					function chengeBig(){
						//console.log($(this)[0]);
						//获取小图路径赋值给大图
						//console.log($('#bigImg')[0].style.display);
						 $('#bigImg')[0].style.display='';
						$('#bigImg')[0].src=$(this)[0].src;	
						 /*console.log($('#bigImg')[0].style.display); */
						//console.log($('#bigImg')[0].src);
				});
				$('.smallImg').mouseout(
					function chengeSmall(){
						$('#bigImg')[0].style.display='none';
				});
				//给整张页面绑定鼠标移动事件e，用于整张页面都能获取鼠标位置
				$('body').mousemove(
					function(e){
						//将鼠标的x轴设置为大图的左边
						$('#bigImg')[0].style.left = e.pageX+20+'px';
						//将鼠标的y轴设置伟大图的上边
						$('#bigImg')[0].style.top = e.pageY+20+'px';
					}		
				);
			});
		</script>
	</head>
	<body>
		<img src="" id="bigImg" style="width:144px;height:206px;display:none; position: absolute;top: 200px;left:50px;" />
		<!-- <img src="" id="bigImg" style="width:144px;height:206px;display:none;" /> -->
		&nbsp;
		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->
		<div style="width: 962px; margin: auto;">
			<a href="#" target="_blank"><img
					src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<s:action name="findAllCate" namespace="/category" executeResult="true">
					<!--如果想将目标action执行结果包含到当前页面，那么目标的action必须是请求转发不能是重定向  -->
				</s:action>
			</div>
			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--推荐图书开始-->
				<div class=second_c_border1 id="recommend">
					<%-- <%@include file="recommend.jsp"%> --%>
					<s:action name="book_findEditorRecom" namespace="/book" executeResult="true"></s:action>
				</div>

				<!--推荐图书结束-->

				<!--热销图书开始-->
				<div class="book_c_border2" id="hot">
					<s:action name="book_findBySales" namespace="/book" executeResult="true"></s:action>
				</div>
				<!--热销图书结束-->

				<!--最新上架图书开始-->
				<div class="book_c_border2" id="new">
					<s:action name="book_findByShelvesTime" namespace="/book" executeResult="true"></s:action>
				</div>

				<!--最新上架图书结束-->

				<div class="clear">
					
				</div>
			</div>
			<!--中栏结束-->



			<!--右栏开始-->
			<div class="book_right">
				<div class="book_r_border2" id="__XinShuReMai">
					<div class="book_r_b2_1x" id="new_bang">
						<!-- <h2 class="t_xsrm">
							新书热卖榜
						</h2> -->
						<s:action name="book_findByShTimeAndSales" namespace="/book" executeResult="true"></s:action>
						<%-- <div id="NewProduct_1_o_t" onmouseover="">
							<h3 class="second">
								<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
							</h3>
						</div> --%>
					</div>
				</div>
			</div>
			<!--右栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
