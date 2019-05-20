package com.xzb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzb.mapper.CategoryMapper;
import com.xzb.pojo.Category;
import com.xzb.pojo.CategoryExample;
import com.xzb.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryMapper categoryMapper;
	@Override
	public List<Category> list() {
		// 查询所有分类
		CategoryExample example = new CategoryExample();
		example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);
	}
	@Override
	public void add(Category category) {
		//添加分类
		categoryMapper.insert(category);
		
	}
	@Override
	public void delete(int id) {
		//根据id删除分类
		categoryMapper.deleteByPrimaryKey(id);
		
	}
	@Override
	public Category get(int id) {
		//根据id获取分类
		return categoryMapper.selectByPrimaryKey(id);
	}
	@Override
	public void update(Category category) {
		//更新分类
		categoryMapper.updateByPrimaryKey(category);
		
	}

}
