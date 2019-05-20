<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../include/foreHeader.jsp"%>
<%@include file="../include/foreHeader2.jsp"%>

<%@include file="../include/foreTop.jsp"%>

    <div>
    <img  src="img/lostSingle/${l.id}.jpg">
    </div>
    
	<table class="table table-bordered">
		<caption>失物详情</caption>
		<thead>
			<tr>
				<th>失物名称</th>
				<th>捡到日期</th>
				<th>捡到地点</th>
				<th>拾到者</th>
				<td>失物状态
			</tr>
		</thead>
		<tbody>
			<tr>
				<td hidden="hidden">${l.id}</td>
				<td>${l.name }</td>
				<td><%-- <fmt:formatDate value="${l.pickDate}" pattern="yyyy-MM-dd" /> --%>
					<fmt:formatDate type="date"  value="${l.pickDate}" />
				</td>
				<td>${l.pickplace}</td>
				<td>${l.pickperson}</td>
				<c:if test="${l.code == 0 }">
					<td>未被领取</td>
				</c:if>

				<c:if test="${l.code == 1 }">
					<td>已领取</td>
				</c:if>
			</tr>
		</tbody>

		
			<%-- <c:forEach items="${l.lostDetailImages }" var="li">
				<img width="40px" src="img/lostDetail/${li.id}.jpg">
			</c:forEach>
 --%>
	</table>
	<div class="reviewStasticsDiv label-info">
		<div class="reviewStasticsLeft">
			<div class="reviewStasticsLeftTop"></div>
			<div class="reviewStasticsLeftContent">
				累计评价 <span class="reviewStasticsNumber"> ${l.reviewCount}</span>
			</div>
			<div class="reviewStasticsLeftFoot"></div>
		</div>
		<div class="reviewStasticsRight">
			<div class="reviewStasticsRightEmpty"></div>
			<div class="reviewStasticsFoot"></div>
		</div>
	</div>
<br>
	<%-- <c:if test="${param.showonly==true}"> --%>
		<div class="reviewDivlistReviews">
			<c:forEach items="${reviews}" var="r">
				<div class="reviewDivlistReviewsEach">
					<div class="reviewDate text-warning">
						<fmt:formatDate value="${r.createDate}" pattern="yyyy-MM-dd" />
					</div>
					<div class="reviewContent">${r.content}</div>
					<div class="reviewUserInfo pull-right">${r.user.anonymousName}<span
							class="reviewUserInfoAnonymous">(匿名)</span>
					</div>
					<br>
					<br>
				</div>
			</c:forEach>
		</div>
	<%-- </c:if> --%>

<br>
	<%-- <c:if test="${param.showonly==true}"> --%>
		<div class="makeReviewDiv">
			<form method="post" action="foredoreview">
				<label for="comment">我要评论:</label>
				<table class="makeReviewTable">
					<tr>
					<!-- 	<td class="makeReviewTableFirstTD">请评论</td> -->
						<td><textarea name="content"></textarea></td>
					</tr>
				</table>
				<div class="makeReviewButtonDiv">
					<input type="hidden" name="lid" value="${l.id}">
					<button type="submit" class="bg-warning">提交评价</button>
				</div>
			</form>
		</div>
	<%-- </c:if>
 --%>
<%@include file="../include/foreFooter.jsp"%>







