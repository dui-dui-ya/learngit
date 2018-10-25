package com.baizhi.chenly.entity;


import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
	private Integer cateId;
	private String cateName;
	private Integer bookCount;
	//类别表之间自连接的关系属性
	private List<Category> children;
	private Category parent;
	
	//类别表与图书之间连接的关系属性
	private List<Book> books; 
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Category [cateId=" + cateId + ", cateName=" + cateName
				+ ", bookCount=" + bookCount + ", children=" + children
				+ ", parent=" + parent + ", books=" + books + "]";
	}

	public Category(Integer cateId, String cateName, Integer bookCount,
			List<Category> children, Category parent, List<Book> books) {
		super();
		this.cateId = cateId;
		this.cateName = cateName;
		this.bookCount = bookCount;
		this.children = children;
		this.parent = parent;
		this.books = books;
	}

	public Integer getCateId() {
		return cateId;
	}
	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public Integer getBookCount() {
		return bookCount;
	}
	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}
	public List<Category> getChildren() {
		return children;
	}
	public void setChildren(List<Category> children) {
		this.children = children;
	}
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	
}
