package com.xzb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzb.pojo.User;
import com.xzb.service.UserService;
import com.xzb.util.Page;

//用户管理的controller层
@Controller
public class UserController {

	@Autowired
	UserService userService;
 
	//查询用户列表
	@RequestMapping("admin_user_list")
	public String list(Model model, Page page) {
		PageHelper.offsetPage(page.getStart(), page.getCount());

		List<User> us = userService.list();

		int total = (int) new PageInfo<>(us).getTotal();
		page.setTotal(total);

		model.addAttribute("us", us);
		model.addAttribute("page", page);

		return "admin/listUser";
	}
	
	//添加用户交由前台用户注册功能
	//删除不提供，修改不提供，均由前台用户自己完成
}
