<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt'%>
<html>
<head>
<script type="text/javascript">
	function check() {
		var message = "${msg}";
		if (message != null && message != " ")
			document.getElementById('tip').innerHTML = message;
	}
</script>

<meta charset="utf-8">
<title>用户登陆</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<script src="js/jquery/2.0.0/jquery.min.js"></script>
<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
<link href="css/back/style.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/reset.css">
<link rel="stylesheet" href="assets/css/supersized.css">
<link rel="stylesheet" href="assets/css/style.css">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="assets/js/html5.js"></script>
        <![endif]-->

<script>
	
</script>
</head>

<body>
	<div class="page-container">

		<div type="button" class="btn btn-primary btn-lg"
			style="text-shadow: black 5px 3px 3px;">
			<span class="glyphicon glyphicon-user"></span> User
		</div>
		<form action="forelogin" " method="post" class="loginForm">
			<input type="text" name="name" class="name" placeholder="请输入您的用户名！">
			<input type="password" name="password" class="password"
				placeholder="请输入您的用户密码！">
			<div>
				<button type="submit" class="submit_button" onclick="check()">登录</button>
				<br> <br> <a href="registerPage" color="red">免费注册</a>
			</div>
			<div class="error">
				<span>+</span>
			</div>
			<span id="tip"></span>
		</form>
	</div>

	<!-- Javascript -->
	<script src="assets/js/jquery-1.8.2.min.js"></script>
	<script src="assets/js/supersized.3.2.7.min.js"></script>
	<script src="assets/js/supersized-init.js"></script>
	<script src="assets/js/scripts.js"></script>


</body>
</html>

