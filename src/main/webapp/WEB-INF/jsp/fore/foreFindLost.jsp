<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../include/foreHeader.jsp"%>
<%@include file="../include/foreHeader2.jsp"%>
<%@include file="../include/foreTop.jsp"%>


<div>${statementMsg }</div>

<h2 class="sub-header">请详细描述的你的失物</h2>
<div class="panel panel-danger">
	<div class="panel-heading">
		<h3 class="panel-title">寻物声明:</h3>
	</div>
	<div class="panel-body">
		<form action="foreFindLostSubmit" method="post">
			<div class="form-group">
				<label for="comment">寻物声明:</label>
				<div class="input-group-lg">
					<input type="text" class="form-control" placeholder="请填写寻物声明"
					 id="content"	name="content">
				</div>
				<div align="right">
					<input type="submit" value="提交">
				</div>
			</div>
		</form>
	</div>
</div>


<%@include file="../include/foreFooter.jsp"%>







