package com.xzb.service;

import java.util.Date;
import java.util.List;

import com.xzb.pojo.Category;
import com.xzb.pojo.Lost;

public interface LostService {

	//失物状态
	String code_unfind = "0" ;//失物未被认领
	String code_adopted = "1";//失物已被认领
	
	//添加失物
	void add(Lost lost);
	//删除失物
	void delete(int id);
	//更新失物
	void update(Lost lost);
	//根据id获取失物
	Lost get(int id);
	//根据id获取失物集合
	List list(int cid);
	
	//为失物设置第一张图片
	void setFirstLostImage(Lost l);
	//为失物设置详细图片
	void setDetailLostImage(Lost l);
	
	//为多个分类设置失物集合
	public void fill(List<Category> categorys);
	//为单个分类设置失物
	public void fill(Category category);
	//为多个分类设置一行失物
	public void fillByRow(List<Category> categorys);
	
	//为失物设置评价数量
	void setReviewNumber(Lost l);
	void setReviewNumber(List<Lost> ls);
	
	//查询所有失物，按日期排序
	List<Lost> list();
	//根据检索条件查询失物
	List<Lost> listByCondition(String name, Date pickdate, String pickplace);
	List<Lost> listByCode(int code);
	//为多个失物设置图片
	void setFirstLostImage(List<Lost> ls);
}
