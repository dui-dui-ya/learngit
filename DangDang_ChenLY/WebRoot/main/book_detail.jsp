<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<html>
	<head>
		<title>图书详情</title>
		<link rel="stylesheet" type="text/css" href="../css/book_detail.css"/>
		<link href="../css/public_footer.css" rel="stylesheet" type="text/css" />

	</head>
	<body style="background-color: #F0F0F0;">
		<br/>
		<div><h1><s:property value="book.bookName"/></h1></div>
		丛书名：<s:property value="book.seriesName"/>
		<hr/>
		<table width="80%" border="0" align="center" cellspacing="0" cellpadding="5">
			<tr>
				<td rowspan="9" width="20%" valign="top"><img src="../productImages/<s:property value='book.productImagePath'/> " width="120px" height="170px" /></td>
				<td colspan="2">作者：<s:property value="book.bookAuthor"/></td>
			</tr>
			<tr>
				<td colspan="2">出版社：<s:property value="book.bookPublish"/></td>
			</tr>
			<tr>
				<td>出版时间： <s:property value="book.publishTime"/> </td>
				<td>字数：<s:property value="book.wordCount"/> </td>
			</tr>
			<tr>
				<td>版次：<s:property value="book.revision"/> </td>
				<td>页数：<s:property value="book.pageCount"/> </td>
			</tr>
			<tr>
				<td>印刷时间：<s:property value="book.printingTime"/> </td>
				<td>开本：<s:property value="book.openType"/> </td>
			</tr>
			<tr>
				<td>印次：<s:property value="book.impression"/> </td>
				<td>纸张：<s:property value="book.bookPaper"/> </td>
			</tr>
			<tr>
				<td>ISBN：<s:property value="book.bookIsbn"/> </td>
				<td>包装：<s:property value="book.bookWrapper"/> </td>
			</tr>
			<tr>
				<td colspan="2">定价：￥<s:property value="book.bookPrice"/> &nbsp;&nbsp;&nbsp;&nbsp;
				<font color="red">当当价：￥<s:property value="book.bookDprice"/> </font>&nbsp;&nbsp;&nbsp;&nbsp;
				节省：￥<s:property value="book.bookPrice-book.bookDprice"/> </td>
			</tr>
			<tr>
				<td colspan="2"><a href='<s:url value="/cart/cart_addCartItem"></s:url>?bookId=<s:property value="book.bookId"/>'"><img src="../images/buttom_goumai.gif"/></a></td>
			</tr>
		</table>
		<hr style="border:1px dotted #666"/>
		<h2>编辑推荐</h2>
		<p>&nbsp;&nbsp;<s:property value="book.editorRecommendation"/> </p>
		<hr style="border:1px dotted #666"/>
		<h2>内容简介</h2>
		<p>&nbsp;&nbsp;<s:property value="book.contentIntroduction"/> </p>
		<hr style="border:1px dotted #666"/>
		<h2>作者简介</h2>
		<p>&nbsp;&nbsp;<s:property value="book.authorIntroduction"/> </p>
		<hr style="border:1px dotted #666"/>
		<h2>目录</h2>
		<p>&nbsp;&nbsp;<s:property value="book.menu"/> </p>
		<hr style="border:1px dotted #666"/>
		<h2>媒体评论</h2>
		<p>&nbsp;&nbsp;<s:property value="book.mediaReview"/> </p>
		<hr style="border:1px dotted #666"/>
		<h2>书摘插图</h2>
		<p>&nbsp;&nbsp;<s:property value="book.digestImagePath"/> </p>
		<!--页尾开始 -->
		<div class="public_footer">
			<div class="public_footer_bottom">
				<div class="public_footer_icp" style="line-height: 48px;">
					Copyright (C) 当当网 2004-2008, All Rights Reserved
					<a href="#" target="_blank"><img src="../images/bottom/validate.gif" border="0" align="middle" /> </a>
					<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
				</div>
			</div>
		</div>
		<!--页尾结束 -->
	</body>
</html>
