package com.baizhi.chenly.entity;

import java.io.Serializable;

public class CartItem implements Serializable{
	private Integer bookId;
	private String bookName;
	private Double bookPrice;//市场价
	private Double bookDprice;//当当价
	private Integer Amount;//数量
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(Integer bookId, String bookName, Double bookPrice,
			Double bookDprice, Integer amount) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookDprice = bookDprice;
		Amount = amount;
	}
	@Override
	public String toString() {
		return "Cart [bookId=" + bookId + ", bookName=" + bookName
				+ ", bookPrice=" + bookPrice + ", bookDprice=" + bookDprice
				+ ", Amount=" + Amount + "]";
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Double getBookDprice() {
		return bookDprice;
	}
	public void setBookDprice(Double bookDprice) {
		this.bookDprice = bookDprice;
	}
	public Integer getAmount() {
		return Amount;
	}
	public void setAmount(Integer amount) {
		Amount = amount;
	}
	
}
