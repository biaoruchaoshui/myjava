<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../include/foreHeader.jsp"%>
<%@include file="../include/foreHeader2.jsp"%>
<%@include file="../include/foreTop.jsp"%>

<div class="red">${error }</div>


<div class="container">
	<c:forEach items="${letterList}" var="let">
		<c:if test="${let.toperson ==  userName }">
			<div class="panel panel-info left">
				<div class="panel-heading">
					<h3 class="panel-title">
						<fmt:formatDate type="both" value="${let.createtime}" />
						来自${let.formperson}
					</h3>
				</div>
				<div class="panel-body">${let.content}</div>
				<div>
					 <a	class="btn btn-warning pull-right  btn-xs"
						href="foredeleteLetter?letterId=${let.id }" role="button">删除</a>
				</div>
			</div>
		</c:if>
		<c:if test="${let.toperson != userName}">
		<div class="panel panel-success right ">
			<div class="panel-heading">
				<h3 class="panel-title">
					<fmt:formatDate type="both" value="${let.createtime}" />
					来自${let.formperson}
				</h3>
				<span></span>
			</div>
			<div class="panel-body">${let.content}
			<a class="btn btn-warning pull-right  btn-xs" href="foredeleteLetter?letterId=${let.id }" role="button">删除</a>
			</div>
	   </div>
	</c:if>
		
	</c:forEach>
</div>
<br>
<br>

<h2 class="sub-header">向管理员认领</h2>
<div class="panel panel-warning">
	<div class="panel-heading">
		<h3 class="panel-title">向管理员认领</h3>
	</div>
	<div class="panel-body">
		<form action="foreLostClaim" method="post">
			<div class="form-group">
				<label for="comment">认领声明:</label>
				<div class="input-group-lg">
					<input type="text" class="form-control" placeholder="请填写认领声明"
						id="letter" name="letter">
				</div>
				<div align="right">
					<input type="submit" value="提交">
				</div>
			</div>
		</form>
	</div>
</div>





<%@include file="../include/foreFooter.jsp"%>







