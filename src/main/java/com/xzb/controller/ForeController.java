package com.xzb.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzb.pojo.FindStatement;
import com.xzb.pojo.InnerLetter;
import com.xzb.pojo.Lost;
import com.xzb.pojo.Review;
import com.xzb.pojo.User;
import com.xzb.service.CategoryService;
import com.xzb.service.FindStatementSerivce;
import com.xzb.service.InnerLetterService;
import com.xzb.service.LostImageService;
import com.xzb.service.LostService;
import com.xzb.service.ReviewService;
import com.xzb.service.UserService;
import com.xzb.util.Page;

//前台控制层
@Controller
public class ForeController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	LostService lostService;
	@Autowired
	UserService userService;
	@Autowired
	LostImageService lostImageService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	FindStatementSerivce findStatementService;
	@Autowired
	InnerLetterService innerLetterService;

	// 日期格式转换
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	// 用户注册
	@RequestMapping("foreregister")
	public String register(Model model, User user) {
		String name = user.getName();
		name = HtmlUtils.htmlEscape(name);
		user.setName(name);
		boolean exist = userService.isExist(name);

		if (exist) {
			String m = "用户名已经被使用,不能使用";
			model.addAttribute("msg", m);
			model.addAttribute("user", null);
			return "fore/register2";
		}
		userService.add(user);

		return "fore/login2";
	}

	// 用户登陆
	@RequestMapping("forelogin")
	public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model,
			HttpSession session) {
		name = HtmlUtils.htmlEscape(name);
		User user = userService.get(name, password);

		if (null == user) {
			model.addAttribute("msg", "账号密码错误");
			return "fore/login2";
		}
		session.setAttribute("user", user);
		return "redirect:forehome";
	}

	// 用户退出
	@RequestMapping("forelogout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:forehome";
	}

	// 首页查询所有失物，按日期排序
	@RequestMapping("forehome")
	public String findLostByDate(Model model, Page page) {
		PageHelper.offsetPage(page.getStart(), page.getCount());
		List<Lost> listbydate = lostService.list();
		int total = (int) new PageInfo<>(listbydate).getTotal();
		page.setTotal(total);
		for (Lost l : listbydate) {
			lostService.setFirstLostImage(l);
		}
		model.addAttribute("page", page);
		model.addAttribute("listbydate", listbydate);
		return "index";
	}

	// 查看失物和评论
	@RequestMapping("foreLostReview")
	public String lookLostAndReview(Model model, @RequestParam("lid") int lid) {
		Lost l = lostService.get(lid);
		lostService.setDetailLostImage(l);
		List<Review> reviews = reviewService.list(lid);
		lostService.setReviewNumber(l);
		model.addAttribute("l", l);
		model.addAttribute("reviews", reviews);
		return "fore/review";
	}

	// 添加评论
	@RequestMapping("foredoreview")
	public String doreview(Model model, @RequestParam("lid") int lid, String content, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Lost l = lostService.get(lid);
		Review review = new Review();
		review.setContent(content);
		review.setLid(l.getId());
		review.setCreateDate(new Date());
		review.setUid(user.getId());
		reviewService.add(review);
		return "redirect:foreLostReview?lid=" + l.getId();
	}

	// 根据用户输入查询
	@RequestMapping("foreSearch")
	public String search(Model model, Page page, @RequestParam("name") String name,
			@RequestParam("pickdate") Date pickdate, @RequestParam("pickplace") String pickplace) {
		PageHelper.offsetPage(page.getStart(), page.getCount());
		List<Lost> listByCondition = lostService.listByCondition(name, pickdate, pickplace);
		int total = (int) new PageInfo<>(listByCondition).getTotal();
		page.setTotal(total);
		for (Lost l : listByCondition) {
			lostService.setFirstLostImage(l);
		}
		model.addAttribute("page", page);
		model.addAttribute("listbydate", listByCondition);
		return "index";
	}
	//用户发布寻物声明
	@RequestMapping("foreFindLostSubmit")
    public String findLost(Model model,@RequestParam("content") String content, HttpSession session){
		if(content == null || content ==" "){
			String msg = "提交内容为空";
			model.addAttribute("statementMsg", msg);
			return "fore/foreFindLost";
		}
		User user = (User) session.getAttribute("user");
		FindStatement findStatement = new FindStatement();
		findStatement.setContent(content);
		findStatement.setCreateDate(new Date());
		findStatement.setUid(user.getId());
		findStatementService.add(findStatement);
		return "redirect:foreLostStatementList";
	}
	
	//展示所有寻物声明
	@RequestMapping("foreLostStatementList")
	public String lostStatementList(Model model, Page page){
		PageHelper.offsetPage(page.getStart(), page.getCount());
		List<FindStatement> list  = findStatementService.list();
		int total = (int) new PageInfo<>(list).getTotal();
		page.setTotal(total);
	    findStatementService.fillUser(list);
		model.addAttribute("page", page);
		model.addAttribute("statements", list);
		return "fore/statementList";
	}
	
	
/*	//检查用户是否登陆
	@RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
 
	@RequestMapping("forefindAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("content") String content,HttpSession session) {
		content = HtmlUtils.htmlEscape(content);
		User user = (User) session.getAttribute("user");
		FindStatement findStatement = new FindStatement();
		findStatement.setContent(content);
		findStatement.setCreateDate(new Date());
		findStatement.setUid(user.getId());
		findStatementService.add(findStatement);
        return "success";
    }*/
 
	//用户认领声明
	@RequestMapping("foreLostClaim")
	public String lostClaim(Model model, @RequestParam("letter") String letter,
			HttpSession session){
		
		if(letter == null || letter.isEmpty()){
			model.addAttribute("error", "请不要输入空值");
			return "fore/foreClaim";
		}
		InnerLetter inletter = new InnerLetter();
		User user = (User) session.getAttribute("user");
	    inletter.setLettercode(0);//表示收件人还为查看回复
	    inletter.setCreatetime(new Date());
	    inletter.setContent(letter);
	    inletter.setFormperson(user.getName());
	    inletter.setToperson(InnerLetterService.Admin);
	    innerLetterService.add(inletter);
		return "redirect:foreLetterList";
	}
	
	//用户展示通信信息
	@RequestMapping("foreLetterList")
	public String letterList(Model model, HttpSession session){
		User user = (User) session.getAttribute("user");
		List<InnerLetter> letterList = innerLetterService.llistBoth(InnerLetterService.Admin, user.getName(),0 );
	/*	List<InnerLetter> letterList = innerLetterService.list(user.getName());*/
	
		model.addAttribute("letterList", letterList);
		model.addAttribute("userName", user.getName());
		return "fore/foreClaim";
	}
	//用户删除山站内信
	@RequestMapping("foredeleteLetter")
	public String delete(Model model, @RequestParam("letterId")int letterId){
		innerLetterService.delete(letterId);
		return "redirect:foreLetterList";
	}

}


