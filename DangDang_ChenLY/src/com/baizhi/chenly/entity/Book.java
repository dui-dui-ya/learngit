package com.baizhi.chenly.entity;

import java.io.Serializable;

import java.sql.Date;

public class Book implements Serializable {
	private Integer bookId;
	private String bookName;
	private String bookAuthor;
	private String bookPublish;//出版商
	
	private Date publishTime;//出版时间
	private Integer revision;
	private String bookIsbn;
	private String wordCount;
	private Integer pageCount;
	private String openType;
	private String bookPaper;//book_paper           VARCHAR2(64),
	private String bookWrapper;//book_wrapper         varchar2(64),
	//关系属性
	private Category category;
	//private Integer bookCategory;//book_category        NUMBER(11),
	private Double bookPrice;//book_price           NUMBER(10,2),
	private Double bookDprice;//book_dprice          NUMBER(10,2),
	private String editorRecommendation;//editor_recommendation varchar2(2000),
	private String contentIntroduction;//content_introduction varchar2(2000),
	private String authorIntroduction;//author_introduction  varchar2(2000),
	private String menu;//menu                 varchar2(2000),
	private String mediaReview;//media_review         varchar2(2000),
	private String digestImagePath;//digest_image_path    varchar2(2000),
	private String productImagePath;//product_image_path   varchar2(2000),
	private String seriesName;//series_name          varchar2(128),
	private Date printingTime;//printing_time        date,印刷时间
	private String impression;//impression           varchar2(64),
	private Integer stock;//stock                integer,
	private Date shelvesDate;//shelves_date         date,上架时间
	private Double customerSocre;//customer_socre       number(3,2),
	private Integer bookStatus;//book_status          NUMBER(1),
	private Integer sales;//sales                NUMBER(10),
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Integer bookId, String bookName, String bookAuthor,
			String bookPublish, Date publishTime, Integer revision,
			String bookIsbn, String wordCount, Integer pageCount,
			String openType, String bookPaper, String bookWrapper,
			Category category, Double bookPrice, Double bookDprice,
			String editorRecommendation, String contentIntroduction,
			String authorIntroduction, String menu, String mediaReview,
			String digestImagePath, String productImagePath, String seriesName,
			Date printingTime, String impression, Integer stock,
			Date shelvesDate, Double customerSocre, Integer bookStatus,
			Integer sales) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublish = bookPublish;
		this.publishTime = publishTime;
		this.revision = revision;
		this.bookIsbn = bookIsbn;
		this.wordCount = wordCount;
		this.pageCount = pageCount;
		this.openType = openType;
		this.bookPaper = bookPaper;
		this.bookWrapper = bookWrapper;
		this.category = category;
		this.bookPrice = bookPrice;
		this.bookDprice = bookDprice;
		this.editorRecommendation = editorRecommendation;
		this.contentIntroduction = contentIntroduction;
		this.authorIntroduction = authorIntroduction;
		this.menu = menu;
		this.mediaReview = mediaReview;
		this.digestImagePath = digestImagePath;
		this.productImagePath = productImagePath;
		this.seriesName = seriesName;
		this.printingTime = printingTime;
		this.impression = impression;
		this.stock = stock;
		this.shelvesDate = shelvesDate;
		this.customerSocre = customerSocre;
		this.bookStatus = bookStatus;
		this.sales = sales;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName
				+ ", bookAuthor=" + bookAuthor + ", bookPublish=" + bookPublish
				+ ", publishTime=" + publishTime + ", revision=" + revision
				+ ", bookIsbn=" + bookIsbn + ", wordCount=" + wordCount
				+ ", pageCount=" + pageCount + ", openType=" + openType
				+ ", bookPaper=" + bookPaper + ", bookWrapper=" + bookWrapper
				+ ", category=" + category + ", bookPrice=" + bookPrice
				+ ", bookDprice=" + bookDprice + ", editorRecommendation="
				+ editorRecommendation + ", contentIntroduction="
				+ contentIntroduction + ", authorIntroduction="
				+ authorIntroduction + ", menu=" + menu + ", mediaReview="
				+ mediaReview + ", digestImagePath=" + digestImagePath
				+ ", productImagePath=" + productImagePath + ", seriesName="
				+ seriesName + ", printingTime=" + printingTime
				+ ", impression=" + impression + ", stock=" + stock
				+ ", shelvesDate=" + shelvesDate + ", customerSocre="
				+ customerSocre + ", bookStatus=" + bookStatus + ", sales="
				+ sales + "]";
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
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublish() {
		return bookPublish;
	}
	public void setBookPublish(String bookPublish) {
		this.bookPublish = bookPublish;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Integer getRevision() {
		return revision;
	}
	public void setRevision(Integer revision) {
		this.revision = revision;
	}
	public String getBookIsbn() {
		return bookIsbn;
	}
	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
	public String getWordCount() {
		return wordCount;
	}
	public void setWordCount(String wordCount) {
		this.wordCount = wordCount;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public String getOpenType() {
		return openType;
	}
	public void setOpenType(String openType) {
		this.openType = openType;
	}
	public String getBookPaper() {
		return bookPaper;
	}
	public void setBookPaper(String bookPaper) {
		this.bookPaper = bookPaper;
	}
	public String getBookWrapper() {
		return bookWrapper;
	}
	public void setBookWrapper(String bookWrapper) {
		this.bookWrapper = bookWrapper;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
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
	public String getEditorRecommendation() {
		return editorRecommendation;
	}
	public void setEditorRecommendation(String editorRecommendation) {
		this.editorRecommendation = editorRecommendation;
	}
	public String getContentIntroduction() {
		return contentIntroduction;
	}
	public void setContentIntroduction(String contentIntroduction) {
		this.contentIntroduction = contentIntroduction;
	}
	public String getAuthorIntroduction() {
		return authorIntroduction;
	}
	public void setAuthorIntroduction(String authorIntroduction) {
		this.authorIntroduction = authorIntroduction;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getMediaReview() {
		return mediaReview;
	}
	public void setMediaReview(String mediaReview) {
		this.mediaReview = mediaReview;
	}
	public String getDigestImagePath() {
		return digestImagePath;
	}
	public void setDigestImagePath(String digestImagePath) {
		this.digestImagePath = digestImagePath;
	}
	public String getProductImagePath() {
		return productImagePath;
	}
	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	public Date getPrintingTime() {
		return printingTime;
	}
	public void setPrintingTime(Date printingTime) {
		this.printingTime = printingTime;
	}
	public String getImpression() {
		return impression;
	}
	public void setImpression(String impression) {
		this.impression = impression;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Date getShelvesDate() {
		return shelvesDate;
	}
	public void setShelvesDate(Date shelvesDate) {
		this.shelvesDate = shelvesDate;
	}
	public Double getCustomerSocre() {
		return customerSocre;
	}
	public void setCustomerSocre(Double customerSocre) {
		this.customerSocre = customerSocre;
	}
	public Integer getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(Integer bookStatus) {
		this.bookStatus = bookStatus;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	
}
