package com.xzb.interceptor;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xzb.pojo.User;
import com.xzb.service.CategoryService;


/*
 * 1. 准备字符串数组 noNeedAuthPage，存放哪些不需要登录也能访问的路径
	2. 获取uri
	3. 去掉前缀/ssm
	4. 如果访问的地址是/fore开头
		4.1 取出fore后面的字符串，比如是forecart,那么就取出cart
		4.2 判断cart是否是在noNeedAuthPage 
		4.2 如果不在，那么就需要进行是否登录验证
		4.3 从session中取出"user"对象
		4.4 如果对象不存在，就客户端跳转到login.jsp
		4.5 否则就正常执行
	 */
public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	CategoryService categoryService;
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
    	HttpSession session = request.getSession();
    	String contextPath = session.getServletContext().getContextPath();
    	System.out.println("contextPath:"+contextPath);
    	String[] noNeedAuthPage = new String[]{
    			"register",
    			"login",
    			"lost",
    			"logout",
    			"home",
    			"LostStatementList"
    			
    		    	};
    	String uri = request.getRequestURI();
    	uri = StringUtils.remove(uri, contextPath);
    	System.out.println("uri"+uri);
    	if(uri.startsWith("/fore")){
    		String method = StringUtils.substringAfterLast(uri, "/fore");
    		if(!Arrays.asList(noNeedAuthPage).contains(method)){
    			User user = (User) session.getAttribute("user");
    			if(null == user){
    				response.sendRedirect("loginPage");
    				return false;
    			}
    		}
    		
    	}
    	return true;
    }
    
    /*
     * 在业务处理器处理请求的执行完成后，生成视图之前执行的动作
     * 可在modelAndView中加入数据，比如当前时间
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
    		ModelAndView modelAndView)throws Exception{
    	
    }
    /*
     * 在DispatcherServlet 完全处理玩请求后被调用，可用于清理资源等
     * 当有拦截器抛出异常时，会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
    		Exception ex)throws Exception{
    	
    }
}
