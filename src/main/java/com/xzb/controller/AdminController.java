package com.xzb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xzb.pojo.Admin;
import com.xzb.service.AdminService;

@Controller
@RequestMapping("")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	//管理员登陆
	@RequestMapping("backLogin")
	public String adminLogin(Model model, @RequestParam("adminName")String adminName, 
			@RequestParam("adminPassword")String adminPassword, HttpSession session){
		System.out.println( adminName+adminPassword);
	    Admin admin = adminService.get(adminName, adminPassword);
	    if(admin != null){
	    	System.out.println(admin);
	    	session.setAttribute("admin", admin);
	    	return "redirect:admin_category_list";
	    }else{
	    	model.addAttribute("msg", "用户名或密码错误");
	    	return "fore/back";
	    }
	}
}
