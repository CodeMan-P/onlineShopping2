<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>首页</title>
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

<script type="text/javascript">
	$(document).ready(function(){
	$("#bt").on("click",function(){
		
		var ajax_option={  
							   //target: '#output',          //把服务器返回的内容放入id为output的元素中        
							   //beforeSubmit://提交前的回调函数    
							   url: './login',                 //默认是form的action， 如果申明，则会覆盖    
							   type: 'post',               //默认是form的method（get or post），如果申明，则会覆盖    
							   dataType: 'json',           //html(默认), xml, script, json...接受服务端返回的类型    
							   clearForm: true,          //成功提交后，清除所有表单元素的值    
							   resetForm: true,          //成功提交后，重置所有表单元素的值    
							   timeout: 3000,               //限制请求的时间，当请求大于3秒后，跳出请求   
							   success: function(data){
							//	   alert(JSON.stringify(data));
							//	alert(data.sex+""+
							//		data.regdate.toString()+"\r\n"+
							//			data.avatar); 
//						$("body").remove("#userInfo");
						$("#user").hide();
						$("body").remove("#user");
						
						$("#userInfo #sp1").text(data.uname);
						$("#userInfo img").attr("src","jsp/"+data.avatar);
						$("#userInfo #sp2").text(data.city);
						$("#userInfo").show();
						//temp.show();
							   },      //提交后的回调函数
							   error: function(){
								   alert("登录异常，请重新登录！");
							   }
					};
					
					  
		
		$("#fm").ajaxSubmit(ajax_option);
	});
	});
</script>		
  </head>
  
  <body>
  <div id="userInfo"  style="border:#06C double 5px; position:absolute; z-index:10; left:1050px;top:400px;">
<center>
用户名：<span id = "sp1" style="font-size: 20px;color: #03C">${sessionScope.name}</span>
<img alt="头像" src="jsp/${sessionScope.avatar}" style="width: 60px;height: 60px; border-radius: 50%;">
<br/><hr/>当前城市：<span id = "sp2" style="font-size: 20px;color: #03C">${sessionScope.city}</span>
</center>
</div>

 <c:choose>
 <c:when test="${empty sessionScope.name}">
 <script type="text/javascript">
 $("#userInfo").hide();
 </script>
 
   <div id="user" style="border:#06C double 5px; position:absolute; z-index:10; left:1050px;top:400px;">
<center>
<h1><font color="red">用户登录</font></h1>
<form action="login" method="post" id="fm">
用户名：<input type="text" id="name" name = "name" /><br/><br/>
密码： <input type="password" id="pwd" name = "pwd" /><br/><br/>
</form>
<input type="button" id="bt" value="登录"/>
<a href="jsp/regist.jsp">新用户注册</a>
</center>
</div>
 </c:when>
 <c:otherwise>
 <script type="text/javascript">
 $("#userInfo").show();
 </script>
 
 </c:otherwise>
 
 </c:choose>


  

<jsp:include page="index.html"></jsp:include>

  </body>
</html>
