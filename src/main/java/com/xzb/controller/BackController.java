package com.xzb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xzb.pojo.Admin;
import com.xzb.pojo.InnerLetter;
import com.xzb.service.InnerLetterService;

@Controller
public class BackController {

	@Autowired
	InnerLetterService innerLetterService;

	// 列举所有信件
	@RequestMapping("admin_letter_list")
	public String backLetterList(Model model, HttpSession session) {
		List<InnerLetter> list = innerLetterService.list("管理员", 0);
		HashSet<String> set = new HashSet<String>();//用set集合去重
		for(InnerLetter inner: list ){
			set.add(inner.getFormperson());
		}
	  //这里存储的是各个用户发给管理员信息的第一条
       List<InnerLetter> listByNames = new ArrayList<InnerLetter>();
	   for(String userName:set){
		   listByNames.add(innerLetterService.getSingleLetters(userName, InnerLetterService.Admin, 0).get(0));
	   }
		Admin admin = (Admin) session.getAttribute("admin");
		model.addAttribute("admin", admin);
		model.addAttribute("listByNames", listByNames);
		return "admin/listLetter";

	}

	// 管理员删除站内信
	// 管理员可直接删除
	@RequestMapping("admindeleteLetter")
	public String delete(Model model, @RequestParam("letterId") int letterId) throws Exception {
		InnerLetter in = innerLetterService.getById(letterId);
		String str = in.getFormperson();
		if(str.equals(InnerLetterService.Admin)){
			str= in.getToperson();
		}
		//传给站内信详情的是用户信名
		innerLetterService.delete(letterId);
		String userName3 = new String(str.getBytes("UTF-8"),"ISO8859-1");
		return "redirect:admindetailLetter?userName="+userName3;
	}
	//查看站内信详情,即查看单个用户的消息
	@RequestMapping("admindetailLetter")
	public String letterdetail(Model model,  @RequestParam("userName") String  userName) throws Exception{
		String userName2 = new String(userName.getBytes("ISO8859-1"), "UTF-8");
		System.out.println("userName2"+userName2);
		List<InnerLetter> listwithUser = innerLetterService.llistBoth(userName2, InnerLetterService.Admin, 0);
		for(InnerLetter in: listwithUser){
			System.out.println("在listwithUser中："+ in.toString());
		}
		model.addAttribute("listwithUser", listwithUser);
		model.addAttribute("AdminName", InnerLetterService.Admin);
		model.addAttribute("UserName", userName2);
		return "admin/listLetterDetail";
	}
	//回复用户信件
	@RequestMapping("adminanswerLetter")
	public String answer(Model model, @RequestParam("UserName")String UserName,
			@RequestParam("letter")String letter) throws Exception{
		String userName2 = new String(UserName.getBytes("ISO8859-1"), "UTF-8");
		System.out.println("在adminanswerLetter中"+ userName2);
		InnerLetter inle = new InnerLetter();
		inle.setContent(letter);
		inle.setFormperson(InnerLetterService.Admin);
		inle.setToperson(userName2);
		inle.setLettercode(0);
		inle.setCreatetime(new Date());
		innerLetterService.add(inle);
		String userName3 = new String(userName2.getBytes("UTF-8"),"ISO8859-1");
		return "redirect:admindetailLetter?userName="+ userName3;
	}
	
	//管理员退出
	@RequestMapping("admin_logout")
	public String logout(Model model, HttpSession session){
		session.removeAttribute("admin");
		return "fore/back";
		
	}

}
