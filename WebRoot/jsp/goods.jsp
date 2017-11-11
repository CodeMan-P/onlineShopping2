<%@ page language="java" import="java.util.*"  import="com.mod.bean.Goods" pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" import="java.io.File"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
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
    		if($(this).val() == null||$(this).val() <=0){
    			$("a[name='buy']").attr("href","#");
    		}else{
    		src="buy?"+$(this).val()+"&&gid="+$("#gid").val();
    		$("a[name='buy']").attr("href",src);
    		}
    		});	
     
    });
  	
    function addGoods(){
    	if($("#num").val() == null||$("#num").val() <=0){
    		alert("输入购物数量？>0！");
    		return false;
    	}
    	var ajax_option={  
				   //target: '#output',          //把服务器返回的内容放入id为output的元素中        
				   //beforeSubmit://提交前的回调函数    
				   url: '../Spcar',                 //默认是form的action， 如果申明，则会覆盖    
				   type: 'post',               //默认是form的method（get or post），如果申明，则会覆盖    
				   dataType: 'json',           //html(默认), xml, script, json...接受服务端返回的类型    
				   clearForm: true,          //成功提交后，清除所有表单元素的值    
				   resetForm: true,          //成功提交后，重置所有表单元素的值    
				   timeout: 3000,               //限制请求的时间，当请求大于3秒后，跳出请求   
				   success: function(data){
					if(data.message.match('.+?成功.+')){
					alert("添加成功");
					$("#sp1").empty();
					$("#sp1").text(data.num);
//						location.href="../index.jsp";	
					}else{
						alert("添加失败");
					}
					
				   },      //提交后的回调函数
				   error:function(XMLHttpRequest, textStatus, errorThrown){
					   alert(XMLHttpRequest.status);
					   alert(XMLHttpRequest.readyState);
					   alert(textStatus);
				   },   
				   complete: function(XMLHttpRequest, textStatus) {
				   }
		};
		
		$("#fm").ajaxSubmit(ajax_option);  
    }
    
  </script>
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
    <img alt="数据库炸了？？？" src="<%=g.getImgpath()%>" style="position:relative; left:-200px;width: 300px;height:auto"/><br/><hr/>

 <div style="width:300px;height:auto; position:relative; left:200px;top:-200px;border:double 5px #DFD184">
 购买数量：
<form action="" id="fm">
    <input type="text" name="gnum" id="num"/>
    <input id="gid" name="gid" value="<%=g.getGid()%>" type="hidden"/>
	</form>    
    
    <a  href="#" name="buy">购买</a>
	<input type="button" value="加入购物车" onclick="addGoods()" />
	<a href="OrderCar.html" target="_blank" style="z-index:9;">
			购物车<span id="sp1" style="font-size:18px; color:#F00">${sessionScope.carnum}</span>
	</a>
 
 </div>  
     <%
     String fpath = "jsp/"+g.getFilepath();
     fpath = application.getRealPath(fpath);
     File file = new File(fpath);
     	if(file.listFiles()!=null){
     		
     	
		for(File f :file.listFiles()){
			String ipath = fpath+f.getName();
			int index =ipath.lastIndexOf("goods");
			ipath = ipath.substring(index);
			%>	
	<img alt="数据库炸了？？？" src="<%=ipath%>" style="width: 800px;height:auto"/><br/><hr/>

			<%
			
		}}
     %>
    </div>
    </center>
  </body>
</html>
