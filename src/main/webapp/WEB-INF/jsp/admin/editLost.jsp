<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/adminHeader.jsp"%>
<%@include file="../include/adminNavigator.jsp"%>

<title>编辑失物</title>

<script>
	$(function() {
		$("#editForm").submit(function() {
			if (!checkEmpty("name", "失物名称"))
				return false;
			if (!checkDate("pickDate", "认领日期"))
				return false;
			if (!checkEmpty("pickperson", "认领者"))
				return false;
		/* 	if (!checkEmpty("pickplace", "捡到地点"))
				return false; */

			return true;
		});
	});
</script>

<div class="workingArea">
	<ol class="breadcrumb">
		<li><a href="admin_category_list">所有分类</a></li>
		<li><a href="admin_lost_list?lid=${l.category.id}">${l.category.name}</a></li>
		<li class="active">${l.name}</li>
		<li class="active">编辑失物</li>
	</ol>

	<div class="panel panel-warning editDiv">
		<div class="panel-heading">编辑失物</div>
		<div class="panel-body">
			<form method="post" id="editForm" action="admin_lost_update">
				<table class="editTable">
					<tr>
						<td>失物名称</td>
						<td><input id="name" name="name" value="${l.name}"
							type="text" class="form-control"></td>
					</tr>
					<tr>
						<td>认领日期</td>
				        <td><input id="claimdate" name="claimdate"  type="date" "
							class="form-control"></td>
					</tr>
					<tr>
						<td>认领者</td>
						<td><input id="claimperson" "
							name="claimperson" type="text" class="form-control"></td>
					</tr>
					<%-- <tr>
						<td>地点</td>
						<td><input id="pickplace" value="${l.pickplace}"
							name="pickplace" type="text" class="form-control"></td>
					</tr> --%>
					<tr>
						<td><label for="name">失物状态</label></td>
						<td>
						     <label class="radio-inline"> <input type="radio"
								name="code" id="code" value="0"
								checked> 未领取
							</label> <label class="radio-inline"> <input type="radio"
								name="code" id="code" value="1">
						             已被领取
							</label>
						</td>
					</tr>
					<tr class="submitTR">
						<td colspan="2" align="center">
						<input type="hidden" name="lid"	value="${l.id}"> 
						<input type="hidden" name="cid"  value="${l.category.id}">
							<button type="submit" class="btn btn-success">提 交</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>