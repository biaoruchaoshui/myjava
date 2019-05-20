<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt'%>
<div class="navitagorDiv">
	<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
		<!-- <img style="margin-left:10px;margin-right:0px" class="pull-left" src="img/site/schoolhui2.png" height="45px"> -->
		<a class="navbar-brand" href="#nowhere">系统后台</a> <a
			class="navbar-brand" href="admin_category_list">分类管理</a> <a
			class="navbar-brand" href="admin_user_list">用户管理</a> <a
			class="navbar-brand" href="admin_lost2_list">失物管理</a> <a
			class="navbar-brand" href="admin_letter_list">站内信</a> <a
			class="navbar-brand" href="#">欢迎你！${sessionScope.admin.name }</a><a
			class="navbar-brand" href="admin_logout">退出</a>



	</nav>
</div>