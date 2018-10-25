package com.baizhi.chenly.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.baizhi.chenly.dao.BookDao;
import com.baizhi.chenly.entity.Book;
import com.baizhi.chenly.util.MyBatisUtil;

public class BookServiceImpl implements BookService{
	//private BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
	//编辑推荐
	@Override
	public List<Book> queryEditorRecom() {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		List<Book> books = bd.selectEditorRecom();
		//获取两个随机数，作为获取books集合图书的下标
		int a = 0;
		int b = 0;
		while(a==b){
			a=new Random().nextInt(books.size());
			b=new Random().nextInt(books.size());
		}
		//将随机的两个图书放入新的集合中返回
		List<Book> book = new ArrayList<Book>();
		book.add(books.get(a));
		book.add(books.get(b));
		return book;
	}

	@Override
	public List<Book> queryBySales() {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		List<Book> books = bd.selectBySales();
		return books;
	}

	@Override
	public List<Book> queryByShelvesTime() {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		List<Book> books = bd.selectByShelvesTime();
		return books;
	}

	@Override
	public List<Book> queryByShTimeAndSales() {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		List<Book> books = bd.selectByShTimeAndSales();
		return books;
	}

	@Override
	public Book queryByBookId(Integer bookId) {
		BookDao bd = (BookDao) MyBatisUtil.getMapper(BookDao.class);
		Book book = bd.selectByBookId(bookId);
		return book;
	}

}
