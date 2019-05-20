package com.xzb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzb.mapper.AdminMapper;
import com.xzb.pojo.Admin;
import com.xzb.pojo.AdminExample;
import com.xzb.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminMapper adminMapper;
	@Override
	public Admin get(String adminName, String password) {
		//根据名字密码查询是否有此管理员
	    AdminExample example = new AdminExample();
	    example.createCriteria().andNameEqualTo(adminName).andPasswordEqualTo(password);
	    List<Admin> adminlist = adminMapper.selectByExample(example);
	    System.out.println(adminlist);
	    if(adminlist.size() == 0)
	    	return null;
		return adminlist.get(0);
	}

	
}
