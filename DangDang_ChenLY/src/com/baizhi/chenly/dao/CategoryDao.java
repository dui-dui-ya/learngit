package com.baizhi.chenly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.chenly.entity.Book;
import com.baizhi.chenly.entity.Category;

public interface CategoryDao {
	//查询所有类别，根据类别id查询其所有的父类别和子类别
	List<Category> selectAllCate(
			@Param(value="cateId")Integer cateId);
	//根据类别名查询所有图书
	List<Category> selectBookByCateId(
			@Param(value="cateId")Integer cateId,
			@Param(value="shengOrJiang")Integer shengOrJiang);
	//查询所有二级分类下的图书数量
	Integer selectBookCount(
			@Param(value="cateId")Integer cateId);
}
