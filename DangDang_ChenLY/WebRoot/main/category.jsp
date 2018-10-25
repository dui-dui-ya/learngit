<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		
		<!--1级分类开始-->
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<s:iterator value="cates">
					<h3>
						[<a href='<s:url value="/category/findBookByCateId"></s:url>?allCateId=<s:property value="cateId"/>'><s:property value="cateName"/></a>]
					</h3>
					<ul class="ul_left_list">
						<s:iterator value="children">
							<li>
								<a href='<s:url value="/category/findBookByCateId"></s:url>?allCateId=<s:property value="cateId"/>'><s:property value="cateName"/></a>
							</li>
						</s:iterator>
						<div class="empty_left">
						</div>
						<div class="more2">
						</div>
					</ul>
				</s:iterator>
				<!-- <h3>
					[<a href='#'>小说</a>]
				</h3> -->
				<!-- <ul class="ul_left_list">

						2级分类开始
						<li>
							<a href='book_list.jsp'>武侠小说</a>
						</li>
						<li>
							<a href='book_list.jsp'>近现代小说</a>
						</li>
						<li>
							<a href='book_list.jsp'>武侠小说</a>
						</li>
						<li>
							<a href='book_list.jsp'>近现代小说</a>
						</li> 
						2级分类结束

				</ul>-->
				<!-- <div class="empty_left">
				</div> -->
			</div>

			<div class="more2">
			</div>
			<!--1级分类结束-->
		<!--1级分类开始-->
			<!-- <div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='#'>小说</a>]
				</h3>
				<ul class="ul_left_list">

						2级分类开始
						<li>
							<a href='book_list.jsp'>武侠小说</a>
						</li>
						<li>
							<a href='book_list.jsp'>近现代小说</a>
						</li>
						<li>
							<a href='book_list.jsp'>武侠小说</a>
						</li>
						<li>
							<a href='book_list.jsp'>近现代小说</a>
						</li>
						2级分类结束

				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
			1级分类结束 -->


		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
