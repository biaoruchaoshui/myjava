<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/adminHeader.jsp"%>
<%@include file="../include/adminNavigator.jsp"%>

<div class="container">
	<c:forEach items="${listByNames}" var="let">
			<div class="panel panel-primary left ">
				<div class="panel-heading">
					<h3 class="panel-title">
						<fmt:formatDate type="both" value="${let.createtime}" />
						来自${let.formperson}
					</h3>
					<span></span>
				</div>
				<div class="panel-body">${let.content}
					 <%-- <a	class="btn btn-warning pull-right  btn-xs"
						href="admindeleteLetter?letterId=${let.id }" role="button">删除</a> --%>
				    <a	class="btn btn-success pull-right  btn-xs"
						href="admindetailLetter?userName=${let.formperson }"  role="button">查看详情</a>
				</div>
			</div>
	</c:forEach>
</div>
<br>
<br>

<%@include file="../include/adminFooter.jsp"%>