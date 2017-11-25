<%@ page language="java" import="java.util.*" import="com.mod.bean.Goods"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/jsp/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>产品搜索页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		
		$("#bt2").click(function(){
		$("#form2").submit();
	
	
		
		
	  });
	
	});
	
	
	
	</script>
  </head>
  
  <body>
  <table border="1">
 <tr>
 <th>&nbsp;商品编号&nbsp;</th> <th>&nbsp;商品名字&nbsp;</th> <th>&nbsp;编号&nbsp;</th> <th>&nbsp;商品价格&nbsp;</th>
   <th>&nbsp;商品图片&nbsp;</th>  <th>&nbsp;商品库存&nbsp;</th>
 
 </tr>
 
 
 <c:forEach var="list" items="${productList}">
<tr>
 
 <td>${list.gid }</td>
  <td>${list.gname }</td>
   <td>${list.tid }</td>
    <td>${list.price }</td>
     <!-- <td>${list.descption }</td> -->
      <td> <a href="../ProInfo?gid=<c:out value="${list.gid }"/>"><img alt="商品图片" style="width: 100px;height: 100px" src="${list.imgpath}"></a></td>
       
        <td>${list.stock }</td>    
 </tr>
 </c:forEach>
</table>
<form action="../search" id="form2" method="get">
 
<input type="submit" value="价格排序" id="bt2">
</form>
  </body>
 
</html>
