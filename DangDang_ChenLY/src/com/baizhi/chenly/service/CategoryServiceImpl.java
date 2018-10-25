package com.baizhi.chenly.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baizhi.chenly.dao.CategoryDao;
import com.baizhi.chenly.entity.Category;
import com.baizhi.chenly.util.MyBatisUtil;

public class CategoryServiceImpl implements CategoryService{
	private CategoryDao dao = (CategoryDao) MyBatisUtil.getMapper(CategoryDao.class);
	//查询类别
	@Override
	public List<Category> queryAllCate(Integer cateId) {
		List<Category> cates = dao.selectAllCate(cateId);
		return cates;
	}
	@Override
	public List<Category> queryBookByCateId(Integer cateId,Integer shengOrJiang) {
		List<Category> cateBooks = dao.selectBookByCateId(cateId,shengOrJiang);
		return cateBooks;
	}
	@Override
	public Map<Integer,Integer> queryBookCount() {
		List<Category> cates = dao.selectAllCate(null);
		Map<Integer,Integer> counts = new HashMap<Integer, Integer>();
		for (Category cate : cates) {
			Integer bookCount = dao.selectBookCount(cate.getCateId());
			counts.put(cate.getCateId(), bookCount);
		}
		return counts;
	}
	

}
