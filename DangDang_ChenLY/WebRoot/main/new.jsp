<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">
	<s:iterator value="books">
	<!--热销图书A开始-->
	<div class="second_d_wai">
		<div class="img">
			<a href="<s:url value="/book/book_findByBookId"></s:url>?book.bookId=<s:property value="bookId"/>" target='_blank'>
					<img src="../productImages/<s:property value='productImagePath' />" border=0 class="smallImg" /> </a>
		</div>
		<div class="shuming">
			<a href="<s:url value="/book/book_findByBookId"></s:url>?book.bookId=<s:property value="bookId"/>" target="_blank"><s:property value="bookName"/><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥<s:property value="bookPrice"/>
		</div>
		<div class="price">
			当当价：￥<s:property value="bookDprice"/>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->
	</s:iterator>
</div>
<div class="clear"></div>