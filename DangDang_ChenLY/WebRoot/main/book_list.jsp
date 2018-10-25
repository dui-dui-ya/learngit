<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>当当图书 – 全球最大的中文网上书店</title>
	<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<%-- 	<script type="text/javascript" src="../js/prototype-1.6.0.3.js"></script> --%>
	<script type="text/javascript">
		$(function(){
			$('#paiXu').change(
				function PaiXu(){
					//获取option的value值
					var index = this.selectedIndex;
					//console.log(index);
					//降序是0，升序是1
					if(index==0){
						//按照上架时间降序排列
						
					}else{
						//升序排列
					}
				}		
			);
			
		});
	</script>
<link href="../css/book.css" rel="stylesheet" type="text/css" />
<link href="../css/second.css" rel="stylesheet" type="text/css" />
<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
<link href="../css/list.css" rel="stylesheet" type="text/css" />
</head>
<body>
	&nbsp;

	<!-- 头部开始 -->
	<%@include file="../common/head.jsp"%>
	<!-- 头部结束 -->

	<div style="width: 962px; margin: auto;">
		<a href="#"><img src="../images/default/book_banner_081203.jpg"
			border="0" /> </a>
	</div>
	<div class='your_position'>
		您现在的位置:&nbsp; <a href='../main/main.jsp'>当当图书</a>
		<s:iterator value="cates">
			<%-- <font style='color: #cc3300'><strong>小说</strong> </font> --%>
			<s:if test="allCateId==cateId">
				<a
					href='<s:url value="/category/findBookByCateId"></s:url>?allCateId=<s:property value="cateId"/>'><font
					color="red"> &gt;&gt; <s:property value="cateName" /> &nbsp;
				</font></a>
			</s:if>
			<s:if test="allCateId!=cateId">
				<a
					href='<s:url value="/category/findBookByCateId"></s:url>?allCateId=<s:property value="cateId"/>'>
					&gt;&gt; <s:property value="cateName" /> &nbsp;
				</a>
			</s:if>
			<s:iterator value="children">
				<s:if test="allCateId==cateId">
					<a
						href='<s:url value="/category/findBookByCateId"></s:url>?allCateId=<s:property value="cateId"/>'><font
						color="red"> &gt;&gt;<s:property value="cateName" /> &nbsp;
					</font></a>
				</s:if>
			</s:iterator>
		</s:iterator>
	</div>

	<div class="book">

		<!--左栏开始-->
		<div id="left" class="book_left">
			<div id="__fenleiliulan">
				<div class=second_l_border2>
					<h2>分类浏览</h2>

					<s:iterator value="cates">
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
										<!--变红  -->
										<!-- <font color="red">小说</font> -->
										<s:if test="allCateId==cateId">
											<a
												href='<s:url value="/category/findBookByCateId"></s:url>?allCateId=<s:property value="cateId"/>'><font
												color="red"> <s:property value="cateName" /> &nbsp; <!--显示图书数量  -->
													<s:iterator value="counts">
														<s:if test="key==cateId">(<s:property value="value" />)</s:if>
													</s:iterator>
											</font></a>

										</s:if>

										<s:if test="allCateId!=cateId">
											<a
												href='<s:url value="/category/findBookByCateId"></s:url>?allCateId=<s:property value="cateId"/>'><s:property
													value="cateName" /> &nbsp; <s:iterator value="counts">
													<s:if test="key==cateId">(<s:property value="value" />)</s:if>
												</s:iterator> </a>
										</s:if>
									</div>
								</div>
							</li>
							<div class="clear"></div>

							<!--2级分类开始-->
							<s:iterator value="children">
								<li>
									<%-- <s:property value="cardId"/> --%>
									<div>
										<div class=second_fenlei>&middot;</div>
										<div class=second_fenlei>
											<s:if test="allCateId==cateId">
												<a
													href='<s:url value="/category/findBookByCateId"></s:url>?allCateId=<s:property value="cateId"/>'><font
													color="red"> <s:property value="cateName" /> &nbsp;
														<s:iterator value="counts">
															<s:if test="key==cateId">
																(<s:property value="value" />)
															</s:if>
															
														</s:iterator>
												</font></a>
											</s:if>
											<s:if test="allCateId!=cateId">
												<a
													href='<s:url value="/category/findBookByCateId"></s:url>?allCateId=<s:property value="cateId"/>'><s:property
														value="cateName" /> &nbsp; <s:iterator value="counts"
														id="cateId">
														<s:if test="key==cateId">(<s:property value="value" />)</s:if>
													</s:iterator> </a>
											</s:if>

										</div>
									</div>
								</li>
								<div class="clear"></div>
							</s:iterator>
					</s:iterator>
					<li>
						<div></div>
					</li>
					</ul>
				</div>
			</div>
		</div>

		<!--左栏结束-->

		<!--中栏开始-->
		<div class="book_center">

			<!--图书列表开始-->
			<div id="divRight" class="list_right">

				<div id="book_list" class="list_r_title">
					<div class="list_r_title_text">排序方式</div>
						<select id="paiXu" name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="1">按上架时间 降序</option>
							<option value="0">按上架时间 升序</option>
						</select>
					<div id="divTopPageNavi" class="list_r_title_text3">

						<!--分页导航开始-->
							
							
							
						<s:if test="currentPage>1">
							<div class='list_r_title_text3a'>
								<a name=link_page_next href='<s:url value="/category/findBookByCateId"></s:url>?allCateId=<s:property  value="allCateId"/>&currentPage=<s:property value="currentPage-1"/>'> 
									<!-- 上一页 -->
									<img src='../images/page_up.gif' />
								</a>
							</div>
						</s:if>
						<!-- <div class='list_r_title_text3a'>
							<img src='../images/page_up_gray.gif' />
						</div> -->

						<div class='list_r_title_text3b'>
								第<font color="red" style="font-size: 18px;"><s:property value="currentPage"/></font>页|
								<s:iterator begin="1" end="maxPage" status="stu">
									<s:if test="#stu.count==currentPage">
										<a href='<s:url value="/category/findBookByCateId"></s:url>?allCateId=<s:property  value="allCateId"/>&currentPage=<s:property />'>
											<font color="red" style="font-size: 18px;"><s:property /></font>
										</a>
									</s:if>
									<s:if test="#stu.count!=currentPage">
										<a href='<s:url value="/category/findBookByCateId"></s:url>?allCateId=<s:property  value="allCateId"/>&currentPage=<s:property />'>
											<font style="font-size: 16px;"><s:property /></font>
										</a>
									</s:if>
								</s:iterator>
								|共<font color="red" style="font-size: 18px;"><s:property value="maxPage"/></font>页
						</div>
						<s:if test="currentPage<maxPage">
							<div class='list_r_title_text3a'>
								<a name=link_page_next href='<s:url value="/category/findBookByCateId"></s:url>?allCateId=<s:property  value="allCateId"/>&currentPage=<s:property value="currentPage+1"/>'>
									<!-- 下一页 -->
									 <img src='../images/page_down.gif' />
								</a>
							</div>
						</s:if>
						<!-- <div class='list_r_title_text3a'>
							<img src='../images/page_down_gray.gif' />
						</div> -->

						<!--分页导航结束-->
					</div>
				</div>

				<!--商品条目开始-->
				<s:iterator value="cateBooks">
					<s:iterator value="books">
						<div class="list_r_line"></div>
						<div class="clear"></div>

						<div class="list_r_list">
							<span class="list_r_list_book">
								<a name="link_prd_img" href='<s:url value="/book/book_findByBookId"></s:url>?book.bookId=<s:property value="bookId"/>'> 
									<img src="../productImages/<s:property value='productImagePath' />" class="smallImg" />
									<%-- <img src="../productImages/<s:property value='productImagePath' />" border=0 class="smallImg" /> --%>
							</a> </span>
							<h2>
								<a name="link_prd_name" href='<s:url value="/book/book_findByBookId"></s:url>?book.bookId=<s:property value="bookId"/>'>
								<s:property value="bookName" /> </a>
							</h2>
							<h3>
								顾客评分：
								<s:property value="customerSocre" />
							</h3>
							<h4 class="list_r_list_h4">
								作 者: <a href='#' name='作者'><s:property value="bookAuthor" />
								</a>
							</h4>
							<h4>
								出版社： <a href='#' name='出版社'><s:property value="bookPublish" />
								</a>
							</h4>
							<h4>
								出版时间：
								<s:property value="publishTime" />
							</h4>
							<h5>
								<!-- 这是一本好书，描述了Struts、Hibernate和Spring等框架的整合应用！ -->
								<s:property value="mediaReview" />
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥<s:property value="bookPrice" />
								</span> <span class="red">￥<s:property value="bookDprice" />
								</span> 节省：￥
								<s:property value="bookPrice-bookDprice" />
							</h6>
							<span class="list_r_list_button">
								<a href="<s:url value='/cart/cart_addCartItem'></s:url>?bookId=<s:property value='bookId'/>"> 
									<img src='../images/buttom_goumai.gif' />
								</a> 
							<span id="cartinfo"></span>
						</div>
						<div class="clear"></div>
					</s:iterator>
				</s:iterator>

				<!--商品条目结束-->

				<div class="clear"></div>
				<div id="divBottomPageNavi" class="fanye_bottom"></div>

			</div>
			<!--图书列表结束-->

		</div>
		<!--中栏结束-->
		<div class="clear"></div>
	</div>

	<!--页尾开始 -->
	<%@include file="../common/foot.jsp"%>
	<!--页尾结束 -->
</body>
</html>
