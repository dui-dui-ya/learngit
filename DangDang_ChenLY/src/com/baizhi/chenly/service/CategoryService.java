package com.baizhi.chenly.service;

import java.util.List;
import java.util.Map;

import com.baizhi.chenly.entity.Category;

public interface CategoryService {
	//查询所有类别
	List<Category> queryAllCate(Integer cateId);
	//根据类别查询所有图书
	List<Category> queryBookByCateId(Integer cateId,Integer shengOrJiang);
	//查询所有类别的所有数量
	//Integer queryBookCount(Integer cateId);
	Map<Integer,Integer> queryBookCount();
}
