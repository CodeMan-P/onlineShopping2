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
    
    <title>结算</title>
    
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
<link rel="stylesheet" href="../css/lanrenzhijia.css" media="all">
<script type="text/javascript">
    $(document).ready(function(){
    	$("#bt1").click(function(){
    		alert("123");
    		
    	});
    	
    	$('.theme-login').click(function(){
    		$('.theme-popover-mask').fadeIn(100);
    		$('.theme-popover').slideDown(200);
    	})
    	$('.theme-poptit .close').click(function(){
    		$('.theme-popover-mask').fadeOut(100);
    		$('.theme-popover').slideUp(200);
    	})
    });
    
    function pay(){
    	$('.theme-popover-mask').fadeOut(100);
		$('.theme-popover').slideUp(200);
        $.ajax({
            type:'post',  
            url:'../Order',  
            data:{
            	"flag":$("#flag").val(),
            	"payPwd":$("#pwd").val(),
            	"oid":$("#oid").val(),
            	"addr":$("input[type=radio]:checked").val()
            	},
            dataType:'json',
            async: false,
            success:function(data){  
				if(data.message.match('.+?成功.+')){
                	alert("支付成功！"); 
                	window.location.href="../index.jsp";
				}else{
						alert("支付失败");
					}
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
				   alert(XMLHttpRequest.status);
				   alert(XMLHttpRequest.readyState);
				   alert(textStatus);
			   }
        });  
    return false;  
    };
  </script>
  </head>
  
  <body>
  <center>
  <div style="width:1200px;height:auto;border:dotted 5px #0033CC;">
  <% 
  String hmJson = (String)request.getSession().getAttribute("hm");
  	ObjectMapper mapper = new ObjectMapper();
	@SuppressWarnings("unchecked")
	HashMap<String,Object> hm = (HashMap<String,Object>)mapper.readValue(hmJson, HashMap.class);
  	
  %>
  <p style="font-size: 35px">
  订单号：<%=(String)hm.get("oid")%>
  <input type="hidden" id="oid" value="<%=(String)hm.remove("oid")%>">
  </p>
  <%hm.remove("uid");%>
   <%hm.remove("state");%>


 <%String address = (String)hm.remove("address");
 if(address.equalsIgnoreCase("#")){
	 //单个支付标志=============================
	 	String adresJson = (String)request.getSession().getAttribute("adresJson");
	 	@SuppressWarnings("unchecked")
	 	LinkedList<HashMap<String,Object>> adlist = mapper.readValue(adresJson, LinkedList.class);
	 	%>
<input type="hidden" id="flag" value="spay"/>
<div style="width:1200px;height:250px;bottom: 10px;border: double 5px #AA33CC;">

	 	<% 
	 	for(HashMap<String,Object> item : adlist){
 %>
 <div style="float:left;width:300px;height:90%; margin: 10px;bottom: 10px;border: double 5px #0033FF; font-size: 18px">
	     <input type="radio" name="radio" id="radio<%=item.get("adressid")%>" value="<%=item.get("address")%>"><%=item.get("adressid") %><br/><hr/>
	     <% 

	 	item.remove("uid");
	     item.remove("uid");
	     for (String s:item.keySet()){
    	if(s.equals("default")){
    		if((Boolean)item.get(s)){
    			%>
    			<br/>
    			<span style="width:100px;height:auto;bottom: 10px;margin: 10px;border: double 5px #0033CC;">
    			默认收货地址
    			</span>
    			<br/>
    			<br/>
    			<script type="text/javascript">
    			$("#radio<%=item.get("adressid")%>").attr("checked","checked");
    			</script>
    			<%
    		}
    	}else{
    	
    	%>
    	<%=s%>:<%=item.get(s)%><br/>
    	
  		 <% }}%>
		</div>
			 <% }%>
 </div>
 <%}else{%>
 <!-- 通过购物车支付标志！！！！！！！！！！！！！！！！！！！！！ -->
 <input type="hidden" id="flag" value="mpay"/>
 <p style="font-size: 25px ; color:red">
 送货地址: <%=address%>
</p>  
 <%}%>

 
 
<p style="font-size: 25px ; color:red">
 总计：<%=hm.remove("sum")%>

    <table border="1"
				style="text-align:center;border:5px #06C solid;width:100%;"
				cellspacing="20px">
				<tr>
					<td style="border-color:#6A5ACD">序号</td>
					
					<td style="border-color:#6A5ACD">产品详情</td>
					<td style="border-color:#1A7ACD">产品图片</td>
					<td style="border-color:#2A7ADD">产品参数</td>
					<td style="border-color: 	#F4A460">小计</td>
				</tr>
				
  <%int index = 1; 
mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
for(String temp : hm.keySet()){
	@SuppressWarnings("unchecked")
	HashMap<String,Object> item =(HashMap<String,Object>)hm.get(temp);  
	  %>
	   <tr style="border: double 5px #0033CC;padding: 20px;margin:50px;">
	  <td style="border-color:#6A5ACD"><%=index %></td>
<td style="border-color:#6A5ACD">
<%String descJson = (String)item.get("descption");
item.remove("descption");
String imgPath = (String)item.get("imgPath");
item.remove("imgPath");;

String itemJson = mapper.writeValueAsString(item);
@SuppressWarnings("unchecked")
HashMap<Object,Object> h = mapper.readValue(itemJson, HashMap.class);
double SubTotal = (double)h.remove("SubTotal");
%>
    <% for (Object s:h.keySet()){
    	%>
    	<%=s%>:<%=h.get(s)%><br/>
    	
   <% }%>
</td>
	<td style="border-color:#1A7ACD"><img alt="#" src="<%=imgPath%>" style="width: 150px;height: auto">
	
	</td>
<td style="border-color:#2A7ADD">
<%
if(descJson!=null){
	
descJson = descJson.replaceAll("\\]", "");
descJson = descJson.replaceAll("\\[", "");
@SuppressWarnings("unchecked")
HashMap<String,String> h2 = mapper.readValue(descJson, HashMap.class);

%>
    <% for (String s:h2.keySet()){
    	%>
    	<%=s%>:<%=h2.get(s)%><br/>
   <% }}%>

</td>
	<td style="border-color: 	#F4A460">
	<%=SubTotal%>
	</td>
					
			
			
	  </tr>
	  
	  <%
	index++;  
  } %>
  
  </table>
  
  </div>
    

<div class="theme-buy" style="position: relative;top:-130px;">
<a class="btn btn-primary btn-large theme-login" href="javascript:;">购买</a>
</div>
<div class="theme-popover">
     <div class="theme-poptit">
          <a href="javascript:;" title="关闭" class="close">×</a>
          <h3>支付</h3>
     </div>
     <div class="theme-popbod dform">
           <form class="theme-signin" name="loginform" action="" method="post">
                <ol>
                     <li><h4>交钱！</h4></li>
                     
                     <!--<li><strong>用户名：</strong><input class="ipt" type="text" name="log" value="lanrenzhijia" size="20" /></li>  -->
                     <li><strong>支付密码：</strong><input class="ipt" type="password" id = "pwd" name="payPwd" value="" size="20" /></li>
                     <li><input class="btn btn-primary" type="button" onclick="pay()" value="确认 " /></li>
                </ol>
           </form>
     </div>
</div>
    
    </center>
  </body>
</html>
