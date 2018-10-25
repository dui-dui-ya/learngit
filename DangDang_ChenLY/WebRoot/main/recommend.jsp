<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<div class=second_c_02_b1>
			<s:iterator value="books">
				<div class=second_c_02_b1_1>
					<a href='<s:url value="/book/book_findByBookId"></s:url>?book.bookId=<s:property value="bookId"/>' target='_blank'>
					<img src='../productImages/<s:property value="productImagePath"/>' width=70 border=0 class="smallImg"/> </a>
				</div>
			
				<div class=second_c_02_b1_2>
					<h3>
						<a href='<s:url value="/book/book_findByBookId"></s:url>?book.bookId=<s:property value="bookId"/>' target='_blank' title='输赢'><s:property value="bookName"/></a>
					</h3>
					<h4>
						作者：<s:property value="bookAuthor"/>
						<br />
						出版社：<s:property value="bookPublish"/>&nbsp;&nbsp;&nbsp;&nbsp;
						出版时间：<s:property value="publishTime"/>
					</h4>
					<h5>
						<s:property value="contentIntroduction"/>
					</h5>
					<h6>
						定价：￥<s:property value="bookPrice"/>&nbsp;&nbsp;
						当当价：￥<s:property value="bookDprice"/>
					</h6>
					<div class=line_xx></div>
				</div>
			</s:iterator>
		</div>
		
	</div>
</div>
