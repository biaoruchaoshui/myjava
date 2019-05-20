<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="container-fluid">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#navbar" aria-expanded="false"
			aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">TJ1.0</a>
	</div>
	<!-- 水平导航栏 -->
	<div id="navbar" class="navbar-collapse collapse">
		<ul class="nav navbar-nav navbar-right">


			<c:if test="${!empty user }">
				<li><a href="#">欢迎你！${user.name }</a></li>
				<li><a href="forelogout">退出</a>
			</c:if>

			<c:if test="${empty user }">
				<li><a href="loginPage">登陆</a></li>
				<li><a href="registerPage">注册</a></li>
			</c:if>
			<!-- <li><a href="#">招物声明</a></li> -->
			<li><a href="#">帮助</a></li>
		</ul>
		<form class="navbar-form navbar-right">
			<input type="text" class="form-control" placeholder="Search...">
		</form>
	</div>
</div>
</nav>
