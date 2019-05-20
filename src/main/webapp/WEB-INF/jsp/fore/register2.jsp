<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt'%>
<html>
<head>
<script type="text/javascript">
	function check() {
	/* 	var confirmpassword = document.getElementById('confirmpassword').value;
		var password = document.getElementById('password').value;      
		if(password != confirmpassword){
			document.getElementById('tip').innerHTML = "两次密码不一致"
			return false;
		} */
	    var message = "${msg}";
		if(message != null && message !=" ")
			document.getElementById('tip').innerHTML = message;
	}
</script>

<meta charset="utf-8">
<title>用户注册</title>
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
		<h1>你好！请注册</h1>
		<form action="foreregister" " method="post" class="loginForm">
			<input type="text" name="name" class="name" placeholder="请输入用户名！">
			<input type="password" name="password" class="password" id = "password"
				placeholder="请输入用户密码！" >
				<button onclick="check()">注册</button>
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

