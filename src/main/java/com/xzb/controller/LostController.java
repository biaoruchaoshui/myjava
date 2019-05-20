package com.xzb.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
//失物管理的控制层
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzb.pojo.Category;
import com.xzb.pojo.Lost;
import com.xzb.service.CategoryService;
import com.xzb.service.LostService;
import com.xzb.util.Page;
@Controller
@RequestMapping("")
public class LostController {
	//日期格式转换
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@Autowired
	CategoryService categroyService;
	@Autowired
	LostService lostService;
	
	//查询失物列表
	@RequestMapping("admin_lost_list")
	public String list(int cid, Model model, Page page){
		Category c = categroyService.get(cid);
		//设置分页参数
		PageHelper.offsetPage(page.getStart(), page.getCount());
		List<Lost> ls = lostService.list(cid);
		
		int total = (int) new PageInfo<>(ls).getTotal();
		page.setTotal(total);
		page.setParam("&cid="+ c.getId());
        
		model.addAttribute("ls", ls);
		model.addAttribute("c", c);
		model.addAttribute("page", page);
	    return "admin/listLost";
	}
	//添加失物
	@RequestMapping("admin_lost_add")
	public String add(Model model, Lost lost, @RequestParam("pickdate") Date pickdate) throws ParseException{
		System.out.println(pickdate);
		lost.setCode(0);
		lost.setPickDate(pickdate);
	    lostService.add(lost);
	    return "redirect:admin_lost_list?cid="+ lost.getCid();
	}

	//删除失物
	@RequestMapping("admin_lost_delete")
	public String delete(int id){
		Lost lost =  lostService.get(id);
		lostService.delete(id);
		return "redirect:admin_lost_list?cid="+ lost.getCid();
	}
	//编辑失物，先获取失物，跳转到编辑页面
	@RequestMapping("admin_lost_edit")
	public String edit(Model model, int id){
		Lost l = lostService.get(id);
	    Category c = categroyService.get(l.getCid());
	    l.setCategory(c);
	    model.addAttribute("l", l);
	    return "admin/editLost";
	}
	//更新失物
	@RequestMapping("admin_lost_update")
	public String update(@RequestParam("lid") int lid, @RequestParam("code") int code, @RequestParam("cid")int cid,@RequestParam("claimdate") Date claimdate,
			@RequestParam("claimperson") String claimperson){
		Lost lost = lostService.get(lid);
		lost.setCode(code);
		lost.setClaimdate(claimdate);
		lost.setClaimperson(claimperson);
		lost.setCid(cid);
		lostService.update(lost);
		return "redirect:admin_lost_list?cid="+ lost.getCid();
	}
	
	
	
	//以下是对失物进行总的操作
	@RequestMapping("admin_lost2_list")
    public String list2(Model model, Page page){
		PageHelper.offsetPage(page.getStart(), page.getCount());
		List<Lost> ls = lostService.list();
		
		int total = (int) new PageInfo<>(ls).getTotal();
		page.setTotal(total);
        lostService.setFirstLostImage(ls);
		model.addAttribute("ls", ls);
		model.addAttribute("page", page);
	    return "admin/listLost2";
	}
	//检索未领取和已领取
	@RequestMapping("admin_lostSearch2")
    public String lostSearch(Model model, Page page, @RequestParam("code") int code){
		PageHelper.offsetPage(page.getStart(), page.getCount());
		List<Lost> ls = lostService.listByCode(code);
		int total = (int) new PageInfo<>(ls).getTotal();
		page.setTotal(total);
		lostService.setFirstLostImage(ls);
		model.addAttribute("ls", ls);
		model.addAttribute("page", page);
	    return "admin/listLost2";
	}
	
}
