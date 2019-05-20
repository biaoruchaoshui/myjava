<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../include/foreHeader.jsp"%>
<%@include file="../include/foreHeader2.jsp"%>
<%-- <%@include file="../include/foreHeader3.jsp"%> --%>
<%@include file="../include/foreTop.jsp"%>

	<c:forEach items="${ statements}" var="stm" >
	<div class="panel panel-default pull-left ">
		<div class="panel-heading ">
		 <span class="label label-info center-block" >${stm.user.anonymousName}</span>
		</div>
	     <textarea class="form-control" rows="7" id="content">${stm.content }</textarea>
	    <div>
	     <span class="label label-default center-block"> 
	     <%-- <fmt:formatDate value="${stm.createDate}" pattern="yyyy-MM-dd" />--%>
	    	<fmt:formatDate type="date"  value="${stm.createDate}" />
	    	</span> 
	    </div>
	</div>
</c:forEach> 

   
	<div class="pageDiv clearfix" align="center">
				<%@include file="../include/adminPage.jsp"%>
	</div>


