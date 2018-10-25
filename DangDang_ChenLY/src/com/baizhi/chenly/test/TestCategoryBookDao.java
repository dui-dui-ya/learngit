package com.baizhi.chenly.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.baizhi.chenly.dao.BookDao;
import com.baizhi.chenly.dao.CategoryDao;
import com.baizhi.chenly.entity.Book;
import com.baizhi.chenly.entity.Category;
import com.baizhi.chenly.service.CategoryService;
import com.baizhi.chenly.service.CategoryServiceImpl;
import com.baizhi.chenly.util.MyBatisUtil;

public class TestCategoryBookDao {

	@Test
	public void testSelectAllCate() {
		CategoryDao dao = (CategoryDao) MyBatisUtil.getMapper(CategoryDao.class);
		List<Category> cates = dao.selectAllCate(1);
		for (Category cate : cates) {
			System.out.println(cate);
			
		}
	}
	private BookDao dao = (BookDao) MyBatisUtil.getMapper(BookDao.class);
	@Test
	public void testSelectEditorRecom() {
		List<Book> books = dao.selectEditorRecom();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	@Test
	public void testSelectBySales() {
		List<Book> books = dao.selectBySales();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	@Test
	public void testSelectByShelvesTime() {
		List<Book> books = dao.selectByShelvesTime();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	@Test
	public void testSelectByShTimeAndSales() {
		List<Book> books = dao.selectByShTimeAndSales();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	@Test
	public void testSelectByCateId() {
		CategoryDao dao = (CategoryDao) MyBatisUtil.getMapper(CategoryDao.class);
		List<Category> cateBooks = dao.selectBookByCateId(11,null);
		for (Category book : cateBooks) {
			System.out.println(book);
		}
	}
	@Test
	public void testSelectBookCount() {
		CategoryService cs = new CategoryServiceImpl();
		Map<Integer, Integer> counts = cs.queryBookCount();
		Set<Integer> cateIds = counts.keySet();
		for (Integer id : cateIds) {
			Integer count = counts.get(id);
			System.out.println(id+"~~~~~"+count);
		}
	}
}
