package com.xzb.service;

import java.util.List;

import com.xzb.pojo.LostImage;

//图片管理service层
public interface LostImageService {

	//图片类型
	String type_single = "type_single";//单个图片，用于在首页展示
	String type_detail = "type_detail";//详细图片，用于在失物详情页面展示
	
	void add(LostImage li);
	void delete(int id);
	void update(LostImage li);
	LostImage get(int id);
	//根据图片失物id和图片类型查询
	List list(int lid, String type);
}
