<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page language="java" import="java.util.*"  import="com.mod.bean.Goods" pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" import="com.mod.mapper.GoodsMapper"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/jsp/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>goods</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="../js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../js/jquery.form.js"></script>
<script type="text/javascript" src="../js/ajaxfileupload.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
     $("#num").on("keyup",function(){
    		if($(this).val() == null||$(this).val() ==0){
    			$("a[name='buy']").attr("href","#");
    		}else{
    		src="buy?"+$(this).val()+"&&gid="+$("#gid").val();
    		$("a[name='buy']").attr("href",src);
    		}
    		});	
    });</script>
  </head>
  
  <body>
  <center>
    <div style="width:900px;height:auto;border: double 5px #0033CC">
    <% Goods g = (Goods)request.getAttribute("goods");
    ObjectMapper mapper = new ObjectMapper();
    String temp = g.getDescption();
    temp = temp.replaceAll("\\]", "");
   	temp = temp.replaceAll("\\[", "");
    HashMap<String,String> h = mapper.readValue(temp, HashMap.class);
    %>
    商品名称：<%=g.getGname() %><br/><hr/>
    价格：<%=g.getPrice() %><br/><hr/>
    库存：<%=g.getStock() %><br/><hr/>
    <% for (String s:h.keySet()){
    	%>
    	<%=s%><-----:-----><%=h.get(s)%><br/>
    		
   <% }%><br/><hr/>
    商品图片:<img alt="数据库炸了？？？" src="<%=g.getImgpath()%>" style="width: 300px;height:auto"/><br/><hr/>
    购买数量：<input type="text" id="num"/>
    
    <input id="gid" value="<%=g.getGid()%>" type="hidden"/>
    <a  href="#" name="buy">购买</a>
    <a  href="#" name="car">加入购物车</a>
    
    </div>
    </center>
  </body>
</html>
