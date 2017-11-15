<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/jsp/";
%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"
	import="com.mod.bean.ShoppingCar"
	import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>全部订单页面</title>
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
	$("input[type=button]").click(function(){
		var str = $(this).val();
		if(str !== "付款"){
			return;
		}
		var oid = $(this).attr("id");
		$("input[name=oid]").val(oid);
		alert($("input[name=oid]").val());
		$("#frm").submit();
	});
	$("input[type=button][value=删除]").hide();
});
</script>
  </head>
  <body>
  <form action="../Order" id="frm">
<input type="hidden" name="flag" value="payOrder"> 
<input type="hidden" name="oid"> 
</form>
<%
String json = (String)request.getSession().getAttribute("ogJson"); 
%>

<%
ObjectMapper mapper = new ObjectMapper();
@SuppressWarnings("unchecked")
LinkedList<LinkedHashMap<String, Object>> list = mapper.readValue(json, LinkedList.class);
SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<center>
<div style="width:1200px;height:auto;border: double 5px #0033CC;margin: 20px;padding: 20px">
   <!------- 最外层for ---------------->
<% 
for(LinkedHashMap<String, Object> temp : list){
	String oid = (String)temp.get("oid");
	String state =(String)temp.get("state");
%>
    <div style="width:900px;height:auto;border: double 5px #0033CC">
    订单号：<%=oid%><br/><hr/>
下单日期：<%=sdf2.format(sdf.parse(oid))%><br><hr>
收件地址：<%=temp.get("address")%><br><hr>
订单状态：<font style="color:<%=state.equals("已付款")?"blue":"red"%>;"><%=state %></font><input type="button" id="<%=oid%>" onclick="" value="<%=state.equals("已付款")?"删除":"付款"%>">
<br><hr>

订单金额：<font style="color:red;">￥<%=temp.get("sum") %></font><br><hr>
		   <!-- 子元素（商品详情）for -->
		<%
		@SuppressWarnings("unchecked")	
		ArrayList <HashMap<String,Object>> goods =(ArrayList <HashMap<String,Object>>)temp.get("goods");
		for(HashMap<String,Object> m:goods){
			%>
			<div style="width:700px;height:200px;border: double 5px #0033CC">
			<%
			for(String key:m.keySet()){
				if(key.equals("descption")){
					%>
					<br><hr><%=key+":" %><%=m.get(key)%><br>
					<%
				}
				else if(key.equals("imgPath")){
				
					%>
					<img alt="#" src="<%=m.get(key)%>" style="border:blue 5px double; width:130px;height:80px;float:left;top:-70px; ">
					<%
					
				}else{
					
				%>
				<%=key+":" %><%=m.get(key)%>___
				<%
				}
			}
			%>
			<br><hr>
			</div>
			<%
		}
		%>
 		<!-- 子元素（商品详情）for -->
		
	    </div>

<%%><%%>

	   <!-- 最外层for -->
<%}%>
</div>
    </center>
  </body>
</html>
