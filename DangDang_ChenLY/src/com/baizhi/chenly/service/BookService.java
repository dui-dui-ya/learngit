package com.baizhi.chenly.service;

import java.util.List;

import com.baizhi.chenly.entity.Book;

public interface BookService {
	//查询编辑推荐图书
	List<Book> queryEditorRecom();
	//查询热销图书
	List<Book> queryBySales();
	//查询最新上架图书Z
	List<Book> queryByShelvesTime();
	//查询新书热卖
	List<Book> queryByShTimeAndSales();
	//根据图书id查询图书
	Book queryByBookId(Integer bookId);
}
