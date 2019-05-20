<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/adminHeader.jsp"%>
<%@include file="../include/adminNavigator.jsp"%>
 
<script>
$(function(){
     
    $("#addForm").submit(function(){
        if(!checkEmpty("name","分类名称"))
            return false;
      
        return true;
    });
});
 
</script>
 
<title>分类管理</title>
 
<div class="workingArea">
    <h1 class="label label-info" >分类管理</h1>
    <br>
    <br>
     
    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
                <tr class="success">
                    <th>ID</th>
                    <th>分类名称</th>
                    <th>失物管理</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cs}" var="c">
                 
                <tr>
                    <td>${c.id}</td>
                    <!-- 保存分类时只是保存分类的id和名称，并没有保存分类的图片到数据库中，而是将每一个图片根据分类id命名，显示时直接访问图片 -->
                    <td>${c.name}</td>
                    <td><a href="admin_lost_list?cid=${c.id}"><span class="glyphicon glyphicon-shopping-cart"></span></a></td>                  
                    <td><a href="admin_category_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" href="admin_category_delete?id=${c.id}"><span class="   glyphicon glyphicon-trash"></span></a></td>
     
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
     <!-- 当前处在admin_categroy_list页面，把adminPage.jsp包含进来，只要改变start参数的就可以刷新访问页面 -->
    <div class="pageDiv">
        <%@include file="../include/adminPage.jsp" %>
    </div>
     
    <div class="panel panel-warning addDiv">
      <div class="panel-heading">新增分类</div>
      <div class="panel-body">
           <!--    1. method="post" 用于保证中文的正确提交
									2. 必须有enctype="multipart/form-data"，这样才能上传文件
									3. accept="image/*" 这样把上传的文件类型限制在了图片 -->
									
            <form method="post" id="addForm" action="admin_category_add" >
                <table class="addTable">
                    <tr>
                        <td>分类名称</td>
                        <td><input  id="name" name="name" type="text" class="form-control"></td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
      </div>
    </div>
     
</div>
<%@include file="../include/adminFooter.jsp"%>