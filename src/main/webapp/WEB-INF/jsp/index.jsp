<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt'%>
<html>
<head>
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="dist/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="assets/js/ie10-viewport-bug-workaround.js"></script>
	
	
	
<!--     <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<!-- <meta name="description" content="">
    <meta name="author" content="">
 -->
<title>失物管理系统</title>

<!-- Bootstrap core CSS -->
<link href="dist/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="dashboard.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
    
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
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
					<!-- <li><a href= "#" id="findstatement" >我要寻物</li> -->
					<li><a href="#">帮助</a></li>
				</ul>
				
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>
	
    <!--引入模态窗 -->
	<%-- <%@include file="../jsp/include/fore/modal.jsp"%> --%>
	
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">失物服务 <span class="sr-only">(current)</span></a></li>
					<li><a href="forehome">失物展示</a></li>
					<li><a href="foreLostStatementList">招物启示</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">用户服务 <span class="sr-only">(current)</span></a></li>
					<li><a href="foreFindLost">我要寻物</a></li>
					<li><a href="foreLetterList">我要认领</a></li>
				</ul>

			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">欢迎来到TJ1.0失物招领系统</h1>

				<!-- <div class="row placeholders">
					<div class="col-xs-6 col-sm-3 placeholder">
						<img
							src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
							width="200" height="200" class="img-responsive"
							alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<img
							src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
							width="200" height="200" class="img-responsive"
							alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<img
							src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
							width="200" height="200" class="img-responsive"
							alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<img
							src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
							width="200" height="200" class="img-responsive"
							alt="Generic placeholder thumbnail">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
				</div> -->

				<h2 class="sub-header">失物列表</h2>
				<br>
				<form class="form-inline" role="form" method="post" action="foreSearch">
					<div class="form-group">
						<label class="bg-info" for="name">检索名称</label> 
						<input type="text"
							class="form-control" id="name" name="name" placeholder="请输入名称">
					</div>
					<div class="form-group">
						<label class="bg-info" for="pickplace">检索地点</label> <input
							type="text" id="pickplace"  name="pickplace" placeholder="请输入地点">
					</div>
				    <div class="form-group">
						<label class="bg-info" for="pickdate">检索日期</label> <input
							type="date" id="pickdate" name="pickdate" >
					</div>
					<button type="submit" class="btn btn-primary">提交</button>
				</form>


				<br> <br>
				<table
					class="table table-striped table-bordered table-hover  table-condensed">
					<thead>
						<tr class="success">
							<!-- 	<th>ID</th> -->
							<th>捡到日期</th>
							<th>图片</th>
							<th>失物名称</th>
							<th width="253px">捡到者</th>
							<th width="280px">捡到地点</th>
							<th width="280px">失物状态</th>
							<th width="280px">查看详情</th>
							<!-- <th width="80px">设置属性</th> -->
							<!-- <th width="100px">编辑</th>
					<th width="100px">删除</th> -->
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listbydate}" var="l">
							<tr>

								<td hidden="hidden">${l.id}</td>
								<td><fmt:formatDate value="${l.pickDate}"
										pattern="yyyy-MM-dd" /></td>
								<td><c:if test="${!empty l.firstLostImage}">
										<img width="40px"
											src="img/lostSingle/${l.firstLostImage.id}.jpg">
									</c:if></td>
								<td>${l.name}</td>
								<td>${l.pickperson}</td>
								<td>${l.pickplace}</td>
								<c:if test="${l.code == 0 }">
									<td>未被领取</td>
								</c:if>

								<c:if test="${l.code == 1 }">
									<td>已领取</td>
								</c:if>

								<td><a href="foreLostReview?lid=${l.id}"><span
										class="glyphicon  glyphicon-credit-card"></span></a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>

			<div class="pageDiv">
				<%@include file="../jsp/include/adminPage.jsp"%>
			</div>

		</div>
	</div>
	

	
</body>
</html>
