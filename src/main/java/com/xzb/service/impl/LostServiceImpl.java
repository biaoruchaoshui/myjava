package com.xzb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzb.mapper.LostMapper;
import com.xzb.pojo.Category;
import com.xzb.pojo.Lost;
import com.xzb.pojo.LostExample;
import com.xzb.pojo.LostImage;
import com.xzb.service.CategoryService;
import com.xzb.service.LostImageService;
import com.xzb.service.LostService;
import com.xzb.service.ReviewService;
//后台失物service层实现
@Service
public class LostServiceImpl implements LostService {

	@Autowired
	LostMapper lostMapper;
	@Autowired
	LostImageService lostImageService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ReviewService reviewService;
	
	@Override
	public void add(Lost lost) {
		//添加失物
       lostMapper.insert(lost);		
	}

	@Override
	public void delete(int id) {
		//删除失物
		lostMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void update(Lost lost) {
		//更新失物
		lostMapper.updateByPrimaryKey(lost);
		
	}

	@Override
	public Lost get(int id) {
		//根据id获取失物
		Lost l = lostMapper.selectByPrimaryKey(id);
		setFirstLostImage(l);
		setCategory(l);
		return l;
	}

	@Override
	public List list(int cid) {
		//根据分类id获取失物集合
		LostExample example = new LostExample();
		example.createCriteria().andCidEqualTo(cid);
		example.setOrderByClause("id desc");
		List result = lostMapper.selectByExample(example);
		setCategory(result);
		setFirstLostImage(result);
		return result;
	}

	//为单个失物设置分类
	public void setCategory(Lost l){
		int cid = l.getCid();
		Category c = categoryService.get(cid);
		l.setCategory(c);
	}
	//为所有失物设置分类
	public void setCategory(List<Lost> ls){
		for(Lost l: ls){
			setCategory(l);
		}
	}
	
	
	//根据lid和图片类型查询出所有的单个图片，然后把第一个取出来放在firstLostImage上。
    @Override
    public void setFirstLostImage(Lost l) {
        List<LostImage> lis = lostImageService.list(l.getId(), LostImageService.type_single);
        if (!lis.isEmpty()) {
            LostImage li = lis.get(0);
            l.setFirstLostImage(li);
        }
    }
 
	
	//根据lid和图片类型查询出所有的详细图片，设置在失物上
    @Override
    public void setDetailLostImage(Lost l) {
        List<LostImage> lis = lostImageService.list(l.getId(), LostImageService.type_detail);
        if (!lis.isEmpty()) {
            l.setLostDetailImages(lis);
        }
    }
   //给多个失物设置图片
    public void setFirstLostImage(List<Lost> ls) {
        for (Lost l :ls) {
            setFirstLostImage(l);
        }
    }

	@Override
	public void fill(List<Category> categorys) {
		// 为多个分类设置失物
		for(Category category: categorys){
			fill(category);
		}
		
	}

	@Override
	public void fill(Category c) {
		//为单个分类设置失物
		List<Lost> ls = list(c.getId());
		c.setLosts(ls);
		
	}

	@Override
	public void fillByRow(List<Category> cs) {
		//为多个分类设置一行失物
        int lostNumberEachRow = 8;
        for (Category c : cs) {
            List<Lost> losts =  c.getLosts();
            List<List<Lost>> lostsByRow =  new ArrayList<>();
            for (int i = 0; i < losts.size(); i+=lostNumberEachRow) {
                int size = i+lostNumberEachRow;
                size= size>losts.size()?losts.size():size;
                List<Lost> lostsOfEachRow =losts.subList(i, size);
                lostsByRow.add(lostsOfEachRow);
            }
          c.setLostByRow(lostsByRow);
        }
		
	}

	@Override
	public void setReviewNumber(Lost l) {
		//为单个失物设置评价数
		int reviewCount = reviewService.getCount(l.getId());
		l.setReviewCount(reviewCount);
		
	}

	@Override
	public void setReviewNumber(List<Lost> ls) {
		//为多个失物设置评价数
		for(Lost l: ls){
			setReviewNumber(l);
		}
		
	}

	@Override
	public List<Lost> list() {
		// 查询所有失物按日期排序
        LostExample example = new LostExample();
        example.createCriteria().andCodeEqualTo(0);
        example.setOrderByClause("pickdate desc");
        List<Lost> lostdates = lostMapper.selectByExample(example);
		return lostdates;
	}

	@Override
	public List<Lost> listByCondition(String name, Date pickdate, String pickplace) {
		//根据检索条件查询所有失物
		LostExample example = new LostExample();
		if(name != null && name !="")
		    example.createCriteria().andNameLike(name);
		if(pickdate != null)
			example.createCriteria().andPickDateEqualTo(pickdate);
		if(pickplace != null && pickplace !="")
			example.createCriteria().andPickplaceLike(pickplace);
	    List<Lost> listByCondition = lostMapper.selectByExample(example);
		
		return listByCondition;
	}

	@Override
	public List<Lost> listByCode(int code) {
		//根据状态检索失物
		LostExample example = new LostExample();
		example.createCriteria().andCodeEqualTo(code);
		List<Lost> list = lostMapper.selectByExample(example);
		return list;
	}

}
