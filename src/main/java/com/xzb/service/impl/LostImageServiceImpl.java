package com.xzb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzb.mapper.LostImageMapper;
import com.xzb.pojo.LostImage;
import com.xzb.pojo.LostImageExample;
import com.xzb.service.LostImageService;

//图片管理的service层实现
@Service
public class LostImageServiceImpl implements LostImageService{

	@Autowired
	LostImageMapper lostImageMapper;
	
	@Override
	public void add(LostImage li) {
		//添加失物图片
		lostImageMapper.insert(li);
	}

	@Override
	public void delete(int id) {
		//删除失物图片
		lostImageMapper.deleteByPrimaryKey(id);
	}

	@Override
	public LostImage get(int id) {
		// 通过id得到失物图片
		return lostImageMapper.selectByPrimaryKey(id);
	}

	@Override
	public List list(int lid, String type) {
		// 通过指向失物的id和图片类型查询图片列表
	    LostImageExample example = new LostImageExample();
	    example.createCriteria().andLidEqualTo(lid).andTypeEqualTo(type);
	    example.setOrderByClause("id desc");
		return lostImageMapper.selectByExample(example);
	}

	@Override
	public void update(LostImage li) {
		// 更新图片
		lostImageMapper.updateByPrimaryKey(li);
	}

}
