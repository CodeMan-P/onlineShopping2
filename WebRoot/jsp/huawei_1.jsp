<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/jsp/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>华为P10</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>


  </head>
  
  <body>
  <video controls="controls" style="position:absolute; left:100px; top:440px; width:430px; height:auto;" autoplay="autoplay"
loop="loop">
  <source src="goods/img/huawei_1/MP4/华为手机.mp4"  type="video/mp4" />
</video>
<img style="position:absolute; left:0px; top:0px; width:100%; height:auto; z-index:-1" src="goods/img/huawei_1/huaweiIndex.png" />
<a href="order2.html" target="_blank">
<img style="position:absolute; left:617px; top:1237px; height:44px; width:183px; ;"  src="goods/img/huawei_1/立即购买.png" />
</a>
<img style="position:absolute; left:807px; top:1237px; height:45px; width:184px; ;" src="goods/img/huawei_1/加入购物车.png" />
 
 <select va></select>
  </body>
</html>
