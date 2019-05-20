package com.xzb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzb.mapper.UserMapper;
import com.xzb.pojo.User;
import com.xzb.pojo.UserExample;
import com.xzb.service.UserService;

//用户管理service层实现
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public void add(User c) {
		//添加用户
	userMapper.insert(c);	
		
	}

	@Override
	public void delete(int id) {
		//删除用户
		userMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void update(User c) {
		//更新用户
		userMapper.updateByPrimaryKey(c);
		
	}

	@Override
	public User get(int id) {
		//根据id获取用户
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> list() {
		//获取用户列表
		UserExample example = new UserExample();
		example.setOrderByClause("id desc");
		return  userMapper.selectByExample(example);
	}

	@Override
	public boolean isExist(String name) {
		//判断用户是否存在
		UserExample example = new UserExample();
	    example.createCriteria().andNameEqualTo(name);
	    List<User> result = userMapper.selectByExample(example);
	    if(!result.isEmpty())
	    	return true;
		return false;
	}

	@Override
	public User get(String name, String password) {
		//根据用户名和密码查询用户
		UserExample example = new UserExample();
		example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
		List<User> result = userMapper.selectByExample(example);
		if(result.isEmpty())
			return null;
		return result.get(0);
	}

}
