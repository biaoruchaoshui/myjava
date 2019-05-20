package com.xzb.service;

import java.util.List;

import com.xzb.pojo.Category;

public interface CategoryService {
 
	//查询所有分类列表
	List<Category> list();
	//添加分类
	void add(Category category);
	//删除分类
	void delete(int id);
	//根据id获取分类
	Category get(int id);
	//更新分类
	void update(Category category);
}
