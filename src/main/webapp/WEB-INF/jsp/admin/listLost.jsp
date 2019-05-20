<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/adminHeader.jsp"%>
<%@include file="../include/adminNavigator.jsp"%>

<script>
	$(function() {
		$("#addForm").submit(function() {
			$("#editForm").submit(function() {
				if (!checkEmpty("name", "失物名称"))
					return false;
				if (!checkDate("pickDate", "捡到日期"))
					return false;
				if (!checkEmpty("pickperson", "捡到者"))
					return false;
				if (!checkEmpty("pickplace", "捡到地点"))
					return false;

				return true;
			});
		});
	});
</script>

<title>失物管理</title>

<div class="workingArea">

	<ol class="breadcrumb">
		<li><a href="admin_category_list">所有分类</a></li>
		<li><a href="admin_lost_list?cid=${c.id}">${c.name}</a></li>
		<li class="active">失物管理</li>
	</ol>

	<div class="listDataTableDiv">
		<table
			class="table table-striped table-bordered table-hover  table-condensed">
			<thead>
				<tr class="success">
					<th>ID</th>
					<th width="253px">图片</th>
					<th width="253px" >失物名称</th>
					<th width="253px">捡到日期</th>
					<th width="253px">捡到者</th>
					<th width="280px">捡到地点</th>
					<th width="280px">失物状态</th>
					<th width="280px">认领人</th>
					<th width="280px">认领日期</th>
					<th width="280px">图片管理</th>
					<th width="100px">编辑</th>
					<th width="100px">删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ls}" var="l">
					<tr>
						<td>${l.id}</td>
						<td>
							<c:if test="${!empty l.firstLostImage}">
							<img width="40px" src="img/lostSingle/${l.firstLostImage.id}.jpg">
							</c:if>
						</td>
						<td>${l.name}</td>
						<td><fmt:formatDate value="${l.pickDate}"
								pattern="yyyy-MM-dd" /></td>
						<td>${l.pickperson}</td>
						<td>${l.pickplace}</td>
						<c:if test="${l.code == 0 }">
						   <td>未被领取</td>
						</c:if>
						
					    <c:if test="${l.code == 1 }">
						   <td>已领取</td>
						</c:if>
					 
					    <c:if test="${l.claimperson == null }">
						   <td>无</td>
						</c:if>
						
						 <c:if test="${l.claimperson != null }">
						   <td>${l.claimperson}</td>
						</c:if>
						
						 <c:if test="${l.claimdate == null }">
						   <td>无</td>
						</c:if>
						 <c:if test="${l.claimdate != null }">
						  <td><fmt:formatDate value="${l.claimdate}"
								pattern="yyyy-MM-dd" /></td>
						</c:if>
						
						<td><a href="admin_lostImage_list?lid=${l.id}"><span
								class="glyphicon glyphicon-picture"></span></a></td>
						<td><a href="admin_lost_edit?id=${l.id}"><span
								class="glyphicon glyphicon-edit"></span></a></td>
						<td><a deleteLink="true"
							href="admin_lost_delete?id=${l.id}"><span
								class="     glyphicon glyphicon-trash"></span></a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="pageDiv">
		<%@include file="../include/adminPage.jsp"%>
	</div>

	<div class="panel panel-warning addDiv">
		<div class="panel-heading">新增失物</div>
		<div class="panel-body">
			<form method="post" id="addForm" action="admin_lost_add">
				<table class="addTable">
					<tr>
						<td>失物名称</td>
						<td><input id="name" name="name" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>捡到日期</td>
						<td><input id="pickdate" name="pickdate"  type="date"
							class="form-control"></td>
					</tr>
					<tr>
						<td>捡到者</td>
						<td><input id="pickperson" 
							name="pickperson" type="text" class="form-control"></td>
					</tr>
					<tr>
						<td>捡到地点</td>
						<td><input id="pickplace" 
							name="pickplace" type="text" class="form-control"></td>
					</tr>
					<tr class="submitTR">
						<td colspan="2" align="center"><input type="hidden"
							name="cid" value="${c.id}">
							<button type="submit" class="btn btn-success">提 交</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</div>

<%@include file="../include/adminFooter.jsp"%>