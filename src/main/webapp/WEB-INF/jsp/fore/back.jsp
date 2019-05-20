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
		if(message != null && message !=" ")
			document.getElementById('tip').innerHTML = message;
	}
</script>

<meta charset="utf-8">
<title>管理员登陆</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
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
		<h1 class="">你好!管理员</h1>
		<form action="backLogin" method="post" class="loginForm">
			<input type="text" name="adminName" id="adminName" class="name" placeholder="请输入账号">
			<input type="password" name="adminPassword" id="adminPassword"
				placeholder="请输入密码！" >
			<div>
				<button type="submit" class="submit_button"  onclick="check()">登录</button>
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

