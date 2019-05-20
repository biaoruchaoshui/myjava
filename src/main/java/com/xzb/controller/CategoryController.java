package com.xzb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzb.pojo.Category;
import com.xzb.service.CategoryService;
import com.xzb.util.Page;

//后台分类页面controller层
@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	 /*
     * 查询所有分类，利用插件，只需要将查询后的数据列表和总数传给page，保存跳转到页面上就行
     */
    @RequestMapping("admin_category_list")
    public String list(Model model, Page page){
    	PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Category> cs= categoryService.list();
        int total = (int) new PageInfo<>(cs).getTotal();
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }
	
    //添加分类
    @RequestMapping("admin_category_add")
    public String add(Category c){
    	categoryService.add(c);
    	return "redirect:/admin_category_list";
    }
    
    //删除分类方法
    @RequestMapping("admin_category_delete")
    public String delete(int id){
    	categoryService.delete(id);
    	return "redirect:/admin_category_list";
    }
    
    //编辑分类跳转方法
    @RequestMapping("admin_category_edit")
    public String edit(int id, Model model){
    	Category c = categoryService.get(id);
    	model.addAttribute("c", c);
    	return "admin/editCategory";
    }
    
    //更新方法
    @RequestMapping("admin_category_update")
    public String update(Category c){
    	categoryService.update(c);
    	return "redirect:/admin_category_list";
    }
}
