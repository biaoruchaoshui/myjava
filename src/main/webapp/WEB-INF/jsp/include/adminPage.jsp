<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

	
<script>
$(function(){
	$("ul.pagination li.disabled a").click(function(){
		return false;
	});
});

</script>


<nav>
  <ul class="pagination">
    <!-- 存在上一页 -->
    <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
      <a  href="?start=0${page.param}" aria-label="Previous" >
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>

    <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
      <a  href="?start=${page.start-page.count}${page.param}" aria-label="Previous" >
        <span aria-hidden="true">&lsaquo;</span>
      </a>
    </li>    

    <c:forEach begin="0"  end="${page.totalPage}" varStatus="status">
      <!-- status 为循环当前的下标 -->
    	
		    <li <c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
		    	<a  
		    	href="?start=${status.index*page.count}${page.param}"
		    	<c:if test="${status.index*page.count==page.start}">class="current"</c:if>
		    	>${status.count}</a>
		    </li>
		
    </c:forEach> 
    <!-- 存在下一页 -->
    <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
      <a href="?start=${page.start+page.count}${page.param}" aria-label="Next">
        <span aria-hidden="true">&rsaquo;</span>
      </a>
    </li>
    <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
      <a href="?start=${page.last}${page.param}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>

 