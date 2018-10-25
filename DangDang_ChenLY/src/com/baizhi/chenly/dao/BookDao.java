package com.baizhi.chenly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.chenly.entity.Book;

public interface BookDao {
	//查询编辑推荐图书
	List<Book> selectEditorRecom();
	//查询热销图书
	List<Book> selectBySales();
	//查询最新上架图书Z
	List<Book> selectByShelvesTime();
	//查询新书热卖
	List<Book> selectByShTimeAndSales();
	//根据图书id查询图书
	Book selectByBookId(Integer bookId);
	//根据图书类别查询所欲图书
/*	List<Book> selectByCateId(
			@Param(value="cateId")Integer cateId);*/
}
