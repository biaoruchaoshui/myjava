package com.xzb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzb.mapper.FindStatementMapper;
import com.xzb.pojo.FindStatement;
import com.xzb.pojo.FindStatementExample;
import com.xzb.service.FindStatementSerivce;
import com.xzb.service.UserService;
@Service
public class FindStatementServiceImpl implements FindStatementSerivce{

	@Autowired
	FindStatementMapper findStatementMapper;
	@Autowired
	UserService userService;
	
	@Override
	public void add(FindStatement findStatement) {
		// 插入寻物声明
	   findStatementMapper.insert(findStatement);
		
	}
	@Override
	public List<FindStatement> list() {
		//查询所有寻物声明，按日期降序
		FindStatementExample example = new FindStatementExample();
        example.setOrderByClause("createDate desc");
       List<FindStatement> list = findStatementMapper.selectByExample(example);
		return list;
	}
	@Override
	public void fillUser(List<FindStatement> list) {
		//为多个寻物声明填充用户
		for(FindStatement statement:list){
			fillUser(statement);
		}
		
	}
	public void fillUser(FindStatement statement){
		//为单个寻物声明填充用户
		statement.setUser(userService.get(statement.getUid()));
	}

}
