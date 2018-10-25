package com.baizhi.chenly.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.stream.events.StartDocument;

import com.baizhi.chenly.entity.Book;
import com.baizhi.chenly.entity.Category;
import com.baizhi.chenly.service.CategoryService;
import com.baizhi.chenly.service.CategoryServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport{
	//用对象类型的成员变量接受零散数据
	//private Category cateBooks;
	private Integer allCateId;
	//统计书籍数量
	//key是cateId，value是类别中书的数量
	private Map<Integer,Integer> counts;
	//private Integer sum;
	//获取排序的方式0或1
	private Integer shengOrJiang;
	//获取当前页数
	private Integer currentPage;
	private Integer maxPage;
	private List<Category> cateBooks;
	//集合类型的成员变量用来封装图书的类别,一级展示所有的图书
	private List<Category> cates;
	private CategoryService cs = new CategoryServiceImpl();
	
	//查询所有图书分类
	public String findAllCate(){
		List<Category> allcates = cs.queryAllCate(null);
		cates = new ArrayList<Category>();
		for(int i=0;i<allcates.size();i++){
			int id=allcates.get(i).getCateId();
			if(id<10){
				cates.add(allcates.get(i));
			}
		}
		
		/*cates = cs.queryAllCate(null);
		for (Category c : cates) {
			System.out.println(c.getCateName());
		}*/
		return "category";
	}
	//根据一个图书类别查询所有的图书类别
	public String findBookByCateId(){
		//System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>");
		List<Category> cate = cs.queryAllCate(allCateId);
		cates=new ArrayList<Category>();
		cates.add(cate.get(0));
		/*for (Category c : cates) {
			System.out.println(c);
		}*/
		
		//根据图书类别查询图书数量,一二级分类展示分别的图书数量
				counts = cs.queryBookCount();
				//用于分页最大图书数量
				//当前类别书籍总数量
				System.out.println(allCateId);
				System.out.println(currentPage);
				Integer maxCount= counts.get(allCateId);
				//System.out.println("????????????????????????????????");
				if(maxCount%3==0){
					maxPage = maxCount/3;
				}else{
					maxPage = maxCount/3+1;
				}
		
		//所有图书，不管是父类别还是子类别
		if(currentPage==null){
			currentPage=1;
		}
		System.out.println(currentPage+"<<<<<<<<<<>>>>>>>>>>");
		Page<Category> startPage = PageHelper.startPage(currentPage,3);
		//紧跟查询方法
		cs.queryBookByCateId(allCateId,null);
		cateBooks = startPage.getResult();
		/*UserDAO ud = (UserDAO) MyBatisUtil.getMapper(UserDAO.class);
		Page<User> startPage = PageHelper.startPage(0, 6);
		//下面紧跟查询方法  不需要返回值		
		ud.queryAll();
		List<User> list = startPage.getResult();
		for (User user : list) {
			System.out.println(user);
		}
		int size = startPage.size();
		System.out.println(size);*/
		
		//返回值跳转
		return "book_list";
	}
	//根据上架时间将图书排序
	public String orderByShelvesTime(){
		cateBooks = cs.queryBookByCateId(allCateId, shengOrJiang);
		return "book_list";
	}
	
	public Integer getAllCateId() {
		return allCateId;
	}
	public void setAllCateId(Integer allCateId) {
		this.allCateId = allCateId;
	}
	public List<Category> getCateBooks() {
		return cateBooks;
	}
	public void setCateBooks(List<Category> cateBooks) {
		this.cateBooks = cateBooks;
	}
	public List<Category> getCates() {
		return cates;
	}
	public void setCates(List<Category> cates) {
		this.cates = cates;
	}
	
	
	public Map<Integer, Integer> getCounts() {
		return counts;
	}
	public void setCounts(Map<Integer, Integer> counts) {
		this.counts = counts;
	}
	public Integer getShengOrJiang() {
		return shengOrJiang;
	}
	public void setShengOrJiang(Integer shengOrJiang) {
		this.shengOrJiang = shengOrJiang;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
	
}
