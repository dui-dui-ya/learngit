package com.baizhi.chenly.action;

import java.util.List;

import com.baizhi.chenly.entity.Book;
import com.baizhi.chenly.service.BookService;
import com.baizhi.chenly.service.BookServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{
	//定义一个Book类型的成员变量用来收集零散数据
	private Book book;
	private List<Book> books;
	private BookService bs = new BookServiceImpl();
	//编辑推荐
	public String findEditorRecom(){
		books = bs.queryEditorRecom();
		
		return "recommend";
	}
	//热销图书
	public String findBySales(){
		books = bs.queryBySales();
		return "hot";
	}
	//最新上架
	public String findByShelvesTime(){
		books = bs.queryByShelvesTime();
		return "new";
	}
	//新书热卖
	public String findByShTimeAndSales(){
		books = bs.queryByShTimeAndSales();
		/*for (Book b : books) {
			System.out.println(b);
		}*/
		return "hotBoard";
	}
	//二级页面，根据图书id查询图书信息
	public String findByBookId(){
		//System.out.println(book.getBookId());
		book = bs.queryByBookId(book.getBookId());
		return "book_detail";
	} 
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}
