<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
		<h2 class="t_xsrm">
			新书热卖榜
		</h2>
		<div id="NewProduct_1_o_t" onmouseover="">
<ul>
	<s:iterator value="books">
		<li><a  target='_blank' href="<s:url value="/book/book_findByBookId"></s:url>?book.bookId=<s:property value="bookId"/>"><s:property value="bookName"/> </a></li>
	</s:iterator>
</ul>
	<h3 class="second">
		<span class="dot_r"> </span><a href="#" target="_blank">更多&gt;&gt;</a>
	</h3>
</div>