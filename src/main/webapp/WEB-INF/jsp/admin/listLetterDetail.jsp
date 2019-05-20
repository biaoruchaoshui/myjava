<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/adminHeader.jsp"%>
<%@include file="../include/adminNavigator.jsp"%>

<div class="container">
	<c:forEach items="${listwithUser}" var="let">
		<c:if test="${let.toperson != AdminName }">
			<div class="panel panel-success left">
				<div class="panel-heading">
					<h3 class="panel-title">
						<fmt:formatDate type="both" value="${let.createtime}" />
					</h3>
				</div>
				<div class="panel-body">${let.content}</div>
				<div>
				 <a	class="btn btn-warning pull-right  btn-xs"
						href="admindeleteLetter?letterId=${let.id }" role="button">删除</a>
				</div>
			</div>
		</c:if>
		
		<c:if test="${let.toperson == AdminName}">
			<div class="panel panel-primary right ">
				<div class="panel-heading">
					<h3 class="panel-title">
						<fmt:formatDate type="both" value="${let.createtime}" />
						来自${let.formperson}
					</h3>
					<span></span>
				</div>
				<div class="panel-body">${let.content}
					 <a	class="btn btn-warning pull-right  btn-xs"
						href="admindeleteLetter?letterId=${let.id }" role="button">删除</a>
				</div>
			</div>
		</c:if>
	</c:forEach>
</div>
<br>
<br>


<div class="panel panel-warning">
	<div class="panel-heading">
		<h3 class="panel-title">回复</h3>
	</div>
	<div class="panel-body">
		<form action="adminanswerLetter?UserName=${UserName }" method="post">
			<div class="form-group">
				<div class="input-group-lg">
					<input type="text" class="form-control" placeholder="回复"
						id="letter" name="letter">
				</div>
				<div align="right">
					<input type="submit" value="提交">
				</div>
			</div>
		</form>
	</div>
</div>

<%@include file="../include/adminFooter.jsp"%>