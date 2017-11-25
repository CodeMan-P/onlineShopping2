
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/jsp/";
%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"
	import="com.mod.bean.ShoppingCar"
	import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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

	<link href="./img/bootstrap.min.css" rel="stylesheet">
	<script src="./img/bootstrap.min.js.下载"></script>
	<link href="./img/style.css" rel="stylesheet">

<script type="text/javascript">
    $(document).ready(function(){ 
    	$("button.createOrderButton").click(function(){  
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
<script>

function checkEmpty(id, name){
	var value = $("#"+id).val();
	if(value.length==0){
		
		$("#"+id)[0].focus();
		return false;
	}
	return true;
}
</script>	
<script>
var deleteOrderItem = false;
var deleteOrderItemid = 0;
$(function(){

	$("a.deleteOrderItem").click(function(){
		deleteOrderItem = false;
		var oiid = $(this).attr("oiid")
		deleteOrderItemid = oiid;
		$("#deleteConfirmModal").modal('show');	   
	});
	$("button.deleteConfirmButton").click(function(){
		deleteOrderItem = true;
		$("#deleteConfirmModal").modal('hide');
	});
	
	$('#deleteConfirmModal').on('hidden.bs.modal', function (e) {
		if(deleteOrderItem){
			var page="foredeleteOrderItem";
			$.post(
				    page,
				    {"oiid":deleteOrderItemid},
				    function(result){
						if("success"==result){
							$("tr.cartProductItemTR[oiid="+deleteOrderItemid+"]").hide();
						}
						else{
							location.href="login.jsp";
						}
				    }
				);
			
		}
	})	
	
	$("img.cartProductItemIfSelected").click(function(){
		var selectit = $(this).attr("selectit");
		var oiid = $(this).attr("oiid")
		
		if("selectit"==selectit){
			$("input[type=checkbox][name="+oiid+"]").prop("checked",false);
			$(this).attr("src","img/cartNotSelected.png");
			$(this).attr("selectit","false")
			$(this).parents("tr.cartProductItemTR").css("background-color","#fff");
		}
		else{
			$("input[type=checkbox][name="+oiid+"]").prop("checked",true);
			$(this).attr("src","img/cartSelected.png");
			$(this).attr("selectit","selectit")
			$(this).parents("tr.cartProductItemTR").css("background-color","#FFF8E1");
		}
		
		syncSelect();
		syncCreateOrderButton();
		calcCartSumPriceAndNumber();
	});
	$("img.selectAllItem").click(function(){
		var selectit = $(this).attr("selectit")
		if("selectit"==selectit){
			$("img.selectAllItem").attr("src","img/cartNotSelected.png");
			$("img.selectAllItem").attr("selectit","false");
			$("input[type=checkbox][id!=check_all_box]").prop("checked",false);
			$(".cartProductItemIfSelected").each(function(){
				$(this).attr("src","img/cartNotSelected.png");
				$(this).attr("selectit","false");
				$(this).parent("td").children("input[type=checkbox]").prop("checked",false);
				$(this).parents("tr.cartProductItemTR").css("background-color","#fff");
			});			
		}
		else{
			$("input[type=checkbox][id!=check_all_box]").prop("checked",true);
			$("img.selectAllItem").attr("src","img/cartSelected.png");
			$("img.selectAllItem").attr("selectit","selectit")
			$(".cartProductItemIfSelected").each(function(){
				$(this).attr("src","img/cartSelected.png");
				$(this).attr("selectit","selectit");
				$(this).parent("td").children("input[type=checkbox]").prop("checked",true);
				$(this).parents("tr.cartProductItemTR").css("background-color","#FFF8E1");
			});				
		}
		syncCreateOrderButton();
		calcCartSumPriceAndNumber();
		

	});

	$(".numberPlus").click(function(){
		
		var pid=$(this).attr("pid");
		var stock= $("span.orderItemStock[pid="+pid+"]").text();
		var price= $("span.orderItemPromotePrice[pid="+pid+"]").text();
		var num= $(".orderItemNumberSetting[pid="+pid+"]").val();

		num++;
		if(num>stock){
			num = stock;
		}
		
		syncPrice(pid,num,price);
	});

	$(".numberMinus").click(function(){
		var pid=$(this).attr("pid");
		var stock= $("span.orderItemStock[pid="+pid+"]").text();
		var price= $("span.orderItemPromotePrice[pid="+pid+"]").text();
		
		var num= $(".orderItemNumberSetting[pid="+pid+"]").val();
		--num;
		if(num<=0){
			num=1;
		}
		syncPrice(pid,num,price);
	});
	function syncPrice(pid,num,price){
		
		var oiid =$(".orderItemNumberSetting[pid="+pid+"]").attr("oiid"); 
		var cartProductItemSmallSumPrice = formatMoney(num*price);
		$.ajax({
            type:'post',  
            traditional :true,//阻止深度序列化  
            url:'../Spcar',  
            data:{
            	"flag":"change",
            	"cid":oiid,
            	"gnum":num},
        	dataType:'json',
            async: false,
            success:function(data){  
				if(data.message.match('.+?成功.+')){
					$(".orderItemNumberSetting[pid="+pid+"]").val(num);
					 
					$(".cartProductItemSmallSumPrice[pid="+pid+"]").html("￥"+cartProductItemSmallSumPrice);
					calcCartSumPriceAndNumber();
				}else{
						alert("修改失败");
					}
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
				   alert(XMLHttpRequest.status);
				   alert(XMLHttpRequest.readyState);
				   alert(textStatus);
			   }
        });  
		/*
		 * var page = "forechangeOrderItem";
			$.post(
				    page,
				    {"pid":pid,"number":num},
				    function(result){
						if("success"!=result){
							location.href="login.jsp";
						}
				    }
				);
		 */	
	}
	function calcCartSumPriceAndNumber(){
		var sum = 0;
		var totalNumber = 0;
		$("img.cartProductItemIfSelected[selectit='selectit']").each(function(){
			var oiid = $(this).attr("oiid");
			var price =$(".cartProductItemSmallSumPrice[oiid="+oiid+"]").text();
			price = price.replace(/,/g, "");
			price = price.replace(/￥/g, "");
			sum += new Number(price);	
			
			var num =$(".orderItemNumberSetting[oiid="+oiid+"]").val();
			totalNumber += new Number(num);	
			
		});
		
		if(totalNumber==0){
			$("span.cartSumNumber").html(0);
			$("span.cartSumPrice").html("￥0.00");
			return;
		}
		$("span.cartSumPrice").html("￥"+formatMoney(sum));
		$("span.cartSumNumber").html(totalNumber);
	}
	function formatMoney(num){
		num = num.toString().replace(/\$|\,/g,'');  
		if(isNaN(num))  
		    num = "0";  
		sign = (num == (num = Math.abs(num)));  
		num = Math.floor(num*100+0.50000000001);  
		cents = num%100;  
		num = Math.floor(num/100).toString();  
		if(cents<10)  
		cents = "0" + cents;  
		for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)  
		num = num.substring(0,num.length-(4*i+3))+','+  
		num.substring(num.length-(4*i+3));  
		return (((sign)?'':'-') + num + '.' + cents);  
	}
	$(".orderItemNumberSetting").keyup(function(){
		var pid=$(this).attr("pid");
		var stock= $("span.orderItemStock[pid="+pid+"]").text();
		var price= $("span.orderItemPromotePrice[pid="+pid+"]").text();
		
		var num= $(".orderItemNumberSetting[pid="+pid+"]").val();
		num = parseInt(num);
		if(isNaN(num))
			num= 1;
		if(num<=0)
			num = 1;
		if(num>stock)
			num = stock;
		
		syncPrice(pid,num,price);
	});

	
	
	$("#bt1").click(function(){
		var params = "";
		$(".cartProductItemIfSelected").each(function(){
			if("selectit"==$(this).attr("selectit")){
				var oiid = $(this).attr("oiid");
				params += "&oiid="+oiid;
			}
		});
		params = params.substring(1);
		location.href="forebuy?"+params;
	});
	
	function syncCreateOrderButton(){
		var selectAny = false;
		$(".cartProductItemIfSelected").each(function(){
			if("selectit"==$(this).attr("selectit")){
				selectAny = true;
			}
		});
		
		if(selectAny){
			$("button.createOrderButton").css("background-color","#C40000");
			$("button.createOrderButton").removeAttr("disabled");
		}
		else{
			$("button.createOrderButton").css("background-color","#AAAAAA");
			$("button.createOrderButton").attr("disabled","disabled");		
		}
			
	}
	function syncSelect(){
		var selectAll = true;
		$(".cartProductItemIfSelected").each(function(){
			if("false"==$(this).attr("selectit")){
				selectAll = false;
			}
		});
		if(selectAll)
			$("img.selectAllItem").attr("src","img/cartSelected.png");
		else
			$("img.selectAllItem").attr("src","img/cartNotSelected.png");
	}

});
function syncSelect(){
	var selectAll = true;
	var sum = 0;
	$(".cartProductItemIfSelected").each(function(){
		if("false"==$(this).attr("selectit")){
			selectAll = false;
		}
		sum+=1;
	});
	if(selectAll&&sum!=0)
		$("img.selectAllItem").attr("src","img/cartSelected.png");
	else
		$("img.selectAllItem").attr("src","img/cartNotSelected.png");
}
function deleterow2(src,oiid) {

	$("img.cartProductItemIfSelected[oiid="+oiid+"]").attr("selectit","false");
	$("input[type=checkbox][name="+oiid+"]").prop("checked",false);
	$(src).empty();
	
	src.parentElement.deleteRow(src.rowIndex-1);
	var a=document.getElementById("table").rows.length;
	calcCart();
	syncSelect();
	if(a==0){
		$("#table").append("<tr><td>您的购物车没有商品，快去商城看看吧</td></tr>");
//		document.getElementById("div").style.display=null;		
	}	
}

function calcCart(){
	var sum = 0;
	var totalNumber = 0;
	$("img.cartProductItemIfSelected[selectit='selectit']").each(function(){
		var oiid = $(this).attr("oiid");
		var price =$(".cartProductItemSmallSumPrice[oiid="+oiid+"]").text();
		price = price.replace(/,/g, "");
		price = price.replace(/￥/g, "");
		sum += new Number(price);	
		
		var num =$(".orderItemNumberSetting[oiid="+oiid+"]").val();
		totalNumber += new Number(num);	
		
	});

	if(totalNumber==0){
		$("span.cartSumNumber").html(0);
		$("span.cartSumPrice").html("￥0.00");
		return;
	}
	$("span.cartSumPrice").html("￥"+formatMoney(sum));
	$("span.cartSumNumber").html(totalNumber);
}
function formatMoney(num){
	num = num.toString().replace(/\$|\,/g,'');  
	if(isNaN(num))  
	    num = "0";  
	sign = (num == (num = Math.abs(num)));  
	num = Math.floor(num*100+0.50000000001);  
	cents = num%100;  
	num = Math.floor(num/100).toString();  
	if(cents<10)  
	cents = "0" + cents;  
	for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)  
	num = num.substring(0,num.length-(4*i+3))+','+  
	num.substring(num.length-(4*i+3));  
	return (((sign)?'':'-') + num + '.' + cents);  
}
</script>	
</head>

<body>
<nav class="top ">
	<div class="top_middle">
	
		<a href="../index.jsp">
			<span style="color:#C40000;margin:0px" class=" glyphicon glyphicon-home redColor"></span>
			
		</a>	
		
			<a href="../index.jsp"style="float:right">退出</a>	
		
		
			<a href="javascript:void(0);" style="float:right"><c:out value="${sessionScope.name}" ></c:out></a>
			
				<a href="../Spcar?flag=view" target="_blank" style="float:right;color:#F00">
			购物车(${sessionScope.carnum})
			</a>
	</div>
</nav>
<div class="simpleSearchOutDiv">
	<a href="../index.jsp">
		<img id="simpleLogo" class="simpleLogo" width="190"height="30" src="./img/simpleLogo.png">	
	</a>
	
	<form action="../search" method="post">	
	<div class="simpleSearchDiv pull-right">
		<input type="text" placeholder="请输入想要的东西吧" value="" name="word">
		<button class="searchButton" type="submit">搜索</button>
		
	</div>
	</form>
	<div style="clear:both"></div>
</div>
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
 <div style="width:1010px;height:200px;border: 1px solid #CCCCCC">
   <% 
	     int idindex = 1;
  for(HashMap<String,Object> item : adlist){
	  %><div style="float:left;width:300px;height:170px; margin: 10px;bottom: 10px;border: 1px solid #CCCCCC">
	     <input type="radio" name="radio" id="radio<%=item.get("adressid")%>" value="<%=item.get("address")%>"><%=idindex++%><br/>
	     <% 
	     item.remove("uid");
	     for (String s:item.keySet()){
    	if(s.equals("default")){
    		if((Boolean)item.get(s)){
    			%>
    			<br/>
    			<span style="width:100px;height:auto;bottom: 1px;margin: 1px;border: solid 1px #0033CC;">
    			默认收货地址
    			</span>
    			<br/>
    			<br/>
    			<script type="text/javascript">
    			$("#radio<%=item.get("adressid")%>").prop("checked",true);
    			</script>
    			<%
    		}
    	}else{
    	
    	%>
    	
    	<%=s.equals("adressid")?"":item.get(s)%><br/>
    	
  		 <% }}%>
		</div>
	  <% }%>
	  <div style="float:left;width:300px;height:auto; margin: 20px;bottom: 20px;border:  1px solid #CCCCCC;">
	      			<br/>
    			<span style="width:100px;height:auto;bottom: 10px;margin: 10px;border:  1px solid #CCCCCC;">
    			<a href="javascript:void(0);">新增收货地址</a>
    			</span>
    			<br/>
    			<br/>
	  </div>
 </div>
<!-- ------------------------------------------------------------ -->


<div class="cartDiv">
	<div class="cartTitle pull-right">
		
	</div>
	
	
	<div class="cartProductList">
		<table class="cartProductTable">
			<thead>
				<tr>
					<th class="selectAndImage">
										
					
					
					</th>
					<th>商品信息</th>
					<th>单价</th>
					<th>数量</th>
					<th width="120px">金额</th>
					<th class="operation">操作</th>
				</tr>
			</thead>
			<tbody  id="table">
				  <%int index = 1; 
mapper.setSerializationInclusion(Include.NON_NULL);  
mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
for(HashMap<String,Object> item : view){
	  
	  %>

					<tr oiid="<%=item.get("cid") %>" class="cartProductItemTR">
						<td>
							<input type="checkbox" name="<%=item.get("cid")%>" value="<%=item.get("cid")%>" style="display: none;" >
							<img selectit="false" oiid="<%=item.get("cid") %>" class="cartProductItemIfSelected" src="./img/cartNotSelected.png">
							<a style="display:none" href="#"><img src="./img/cartSelected.png"></a>
							<img class="cartProductImg" src="<%=item.get("imgPath")%>" ale="商品图片">
						</td>
						<td>
						
							<span class="cartProductItemName"><a href="../ProInfo?gid=<%=item.get("gid") %>" class="cartProductLink"><%=item.get("gname") %></a></span>
						</td>
						<td>
							
							<span class="cartProductItemPromotionPrice"><%=item.get("price") %></span>
							
						</td>
						<td>
						
							<div class="cartProductChangeNumberDiv">
								<span class="hidden orderItemStock " pid="<%=item.get("gid")%>"><%=item.get("stock")%></span>
								<span class="hidden orderItemPromotePrice " pid="<%=item.get("gid")%>"><%=item.get("price")%></span>
								<a 	class="numberMinus"		 pid="<%=item.get("gid")%>" id="jian"  href="javascript:void(0);">-</a>
								<input pid="<%=item.get("gid")%>" oiid="<%=item.get("cid")%>" class="orderItemNumberSetting" autocomplete="off" value="<%=item.get("gnum")%>">
								<a class="numberPlus"		stock="<%=item.get("stock")%>" id="jia" pid="<%=item.get("gid")%>" href="javascript:void(0);">+</a>
							</div>					
						
						 </td>
						<td>
							<span class="cartProductItemSmallSumPrice" oiid="<%=item.get("cid")%>" pid="<%=item.get("gid")%>">
							￥<%=(double)item.get("price")*(int)item.get("gnum")%>
							</span>
						
						</td>
						<td>
							<a class="deleteOrderItem" oiid="<%=item.get("cid")%>" href="javascript:void(0);"onClick='javascript:if(deleGoods(<%=item.get("cid")%>)){deleterow2(this.parentElement.parentElement,<%=item.get("cid")%>)}'>删除</a>
						</td>
					</tr>
				
						  <%
	index++;  
  } %>
								
			</tbody>
		
		</table>
	</div>
	
	<div class="cartFoot">
		<img selectit="false" class="selectAllItem" src="./img/cartNotSelected.png">
		<span>全选</span>
<!-- 		<a href="#">删除</a> -->
		
		<div class="pull-right">
			<span>已选商品 <span class="cartSumNumber">0</span> 件</span>
			
			<span>合计 : </span> 
			<span class="cartSumPrice">￥0.00</span>
			<button class="createOrderButton" disabled="disabled">结  算</button>
		</div>
		
	</div>
	
</div>

<!-- ------------------------------------------------------------ -->
 </center>
  </body>
</html>