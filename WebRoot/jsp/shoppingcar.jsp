
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

<title>购物车</title>

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
    	$("#bt1").click(function(){  
            var $check_boxes = $("input[type=checkbox][id!=check_all_box]:checked");  
            if($check_boxes.length<=0){ alert('未勾选购买物品，请勾选！');return;}  
            if(confirm('确定要剁手（购买）吗？')){
                var buyCids = new Array();  
                $check_boxes.each(function(){  
                	buyCids.push($(this).val());  
                });  
                var adresId = $("input[type=radio]:checked").val();
             
                $("input[name='buyCids']").val(buyCids.toString());
                $("input[name='adresId']").val(adresId+"");
                $("#frm").submit();
             
            }
            
        });  
    	
    });
    function changeBox(){
    	//$("input[type=checkbox][id!=check_all_box]").removeAttr("checked");
		$("input[type=checkbox][id!=check_all_box]").prop("checked",$('input[id=check_all_box]').is(':checked'));
    };
    function deleGoods(cid){
    	flag = false;
        $.ajax({
            type:'post',  
            traditional :true,//阻止深度序列化  
            url:'../Spcar',  
            data:{
            	"flag":"dele",
            	"cid":cid},
            dataType:'json',
            async: false,
            success:function(data){  
				if(data.message.match('.+?成功.+')){
                	alert("成功删除！"); 
                    //MARK**转付款界面
					//location.href="../index.jsp";	
                	flag =true; 
				}else{
						alert("删除失败");
					}
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
				   alert(XMLHttpRequest.status);
				   alert(XMLHttpRequest.readyState);
				   alert(textStatus);
			   }
        });  
    return flag;  
    };
    
    </script>
</head>

<body>
<form action="../Order" id="frm">
<input type="hidden" name="flag" value="multi"> 
<input type="hidden" name="buyCids"> 
<input type="hidden" name="adresId"> 
</form>
	<% 
 //@SuppressWarnings("unchecked")
 //LinkedList<ShoppingCar> list = (LinkedList<ShoppingCar>)request.getSession().getAttribute("carlist");
	@SuppressWarnings("unchecked")
	LinkedList<HashMap<String,Object>> view = (LinkedList<HashMap<String,Object>>)request.getSession().getAttribute("view");
	String adresJson = (String)request.getSession().getAttribute("adresJson");
	
	ObjectMapper mapper = new ObjectMapper();
	@SuppressWarnings("unchecked")
	LinkedList<HashMap<String,Object>> adlist = mapper.readValue(adresJson, LinkedList.class);
	 %>
 <center>
 <div style="width:1200px;height:250px;border: double 5px #AA33CC;">
   <% 
  for(HashMap<String,Object> item : adlist){
	  %><div style="float:left;width:300px;height:auto; margin: 10px;bottom: 10px;border: double 5px #0033FF;">
	     <input type="radio" name="radio" id="radio<%=item.get("adressid")%>" value="<%=item.get("address")%>"><%=item.get("adressid") %><br/><hr/>
	     <% 
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
	  <div style="float:left;width:300px;height:auto; margin: 20px;bottom: 20px;border: double 5px #0033FF;">
	      			<br/>
    			<span style="width:100px;height:auto;bottom: 10px;margin: 10px;border: double 5px #0033CC;">
    			<a href="#">新增收货地址</a>
    			</span>
    			<br/>
    			<br/>
	  </div>
 </div>
  <div style="width:1200px;height:auto;border:dotted 5px #0033CC;">
  <table border="1"
				style="text-align:center;border:5px #06C solid;width:100%;"
				cellspacing="20px">
				<tr>
					
					<td style="border-color: 	#000080">选择
					<input type="checkbox" name="cbox" id="check_all_box" onclick="$(changeBox)" >(全选)</td>
					<td style="border-color:#6A5ACD">产品详情</td>
					<td style="border-color:#1A7ACD">产品图片</td>
					<td style="border-color:#2A7ADD">产品参数</td>
					<td style="border-color: 	#F4A460">操作</td>
				</tr>
				
  <%int index = 1; 
mapper.setSerializationInclusion(Include.NON_NULL);  
mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
for(HashMap<String,Object> item : view){
	  
	  %>
	   <tr style="border: double 5px #0033CC;padding: 20px;margin:50px;">
	   <td style="border-color: 	#000080"><input type="checkbox" name="cbox" value="<%=item.get("cid")%>"><%=index %></td>
<td style="border-color:#6A5ACD">
<%String descJson = (String)item.get("descption");
item.remove("descption");
String imgPath = (String)item.get("imgPath");
item.remove("imgPath");;

String itemJson = mapper.writeValueAsString(item);
@SuppressWarnings("unchecked")
HashMap<Object,Object> h = mapper.readValue(itemJson, HashMap.class);
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
	<input type="button" id="dele" 
	onclick="javascript:if(deleGoods(<%=h.get("cid")%>)){$(this.parentNode.parentNode).remove();}" value="删除"/>
	</td>
					
			
			
	  </tr>
	  
	  <%
	index++;  
  } %>
	 <tr>
	<td style="border-color: #CCA460" colspan="5">
	<input type="button" id ="bt1" value="提交订单">
	</td>
	  </tr>
  
  </table>
  </div>
 </center>
  </body>
</html>