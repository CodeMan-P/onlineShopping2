<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/jsp/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册页面</title>
    
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
		Date.prototype.format = function(pattern) {
		    /*初始化返回值字符串*/
		    var returnValue = pattern;
		    /*正则式pattern类型对象定义*/
		    var format = {
		        "y+": this.getFullYear(),
		        "M+": this.getMonth()+1,
		        "d+": this.getDate(),
		        "H+": this.getHours(),
		        "m+": this.getMinutes(),
		        "s+": this.getSeconds(),
		        "S": this.getMilliseconds(),
		        "h+": (this.getHours()%12),
		        "a": (this.getHours()/12) <= 1? "AM":"PM"
		    };
		    /*遍历正则式pattern类型对象构建returnValue对象*/
		    for(var key in format) {
		        var regExp = new RegExp("("+key+")");
		        if(regExp.test(returnValue)) {
		            var zero = "";
		            for(var i = 0; i < RegExp.$1.length; i++) { zero += "0"; }
		            var replacement = RegExp.$1.length == 1? format[key]:(zero+format[key]).substring(((""+format[key]).length));
		            returnValue = returnValue.replace(RegExp.$1, replacement);
		        }
		    }
		    return returnValue;
		};
		$("input[name=regdate]").val(new Date().format("yyyy-MM-dd"));
		$('input[name=regdate]').attr('disabled',true);
		$("#bt1").on("click",function(){
	        $.ajaxFileUpload({ 
	            method:"POST",
	            url:"../UMS",            //需要链接到服务器地址  
	            secureuri:false,  
	            fileElementId:'file',                        //文件选择框的id属性
	            dataType: 'text',//服务器返回的格式  
	            async : false, 
	            success: function(data,status){ 
	            //上传成功之后的操作
	            if(data.match('img.+')){
	            $("#img").attr("src",data);
	           // $("input[name='img']").val(data);
	            $("#ava").val(data);
	            alert("上传成功");	            	
	            }else{
	            	alert("上传失败");
	            }
	            },error: function (data, status, e){ 
	            //上传失败之后的操作
	            	alert("error");
	            }  
	        });
		});
			$("#bt2").on('click', function() {
				var name = $("input[name=uname]").val();
				var pwd = $("input[name=upwd]").val();
				var pwd2 = $("input[name=upwd2]").val();
				
				if(name === ""){
					alert("用户名不能为空！！！");
					return false;
				}
				if(pwd === ""){
					alert("密码不能为空！！！");
					return false;
				}
				if(pwd !== pwd2){
					alert("密码不一致！！！");
					return false;
				}
				var pwd2=$("input[name=pwd]").val();
				$('input[name=regdate]').attr('disabled',false);
					var ajax_option={  
							   //target: '#output',          //把服务器返回的内容放入id为output的元素中        
							   //beforeSubmit://提交前的回调函数    
							   url: '../UMS',                 //默认是form的action， 如果申明，则会覆盖    
							   type: 'post',               //默认是form的method（get or post），如果申明，则会覆盖    
							   dataType: 'text',           //html(默认), xml, script, json...接受服务端返回的类型    
							   clearForm: true,          //成功提交后，清除所有表单元素的值    
							   resetForm: true,          //成功提交后，重置所有表单元素的值    
							   timeout: 3000,               //限制请求的时间，当请求大于3秒后，跳出请求   
							   success: function(data){
								alert(data);   
								if(data.match('注册成功.+')){
									location.href="../index.jsp";	
								}
								
							   },      //提交后的回调函数		
					};
					
					$("#userForm").ajaxSubmit(ajax_option);  
			});
	});
	</script>
  </head>
  
  <body>
    <center>
    <div style="width:900px;height:auto;border: double 5px #0033CC">
    <div style="width: 500px;border: 5px double #f00">
    <iframe id="iframe_display" name="iframe_display" style="display: none;"></iframe>  
      <img id="img" src="#" alt="请上传头像" style="width: 100px;height: 80px"/><br><hr>
  <form id="picForm" method="post" enctype="multipart/form-data">
      <input id="file" type="file" name="file"/>
  </form>
      <input type="button" value="上传头像" id="bt1"/>
    </div>
    <br><hr>
     <form id="userForm" action="../UMS" method="post">
     <input type="hidden" name="flag" value="regist"/>
     	账户名：<input type="text" name="uname" required><br><hr>
     	密码：<input type="password" name="upwd" required>
     	确认密码：<input type="password" name="upwd2" required><br><hr>
     	手机：<input type="text" name="phone" onkeyup="this.value=this.value.replace(/\D/g,'')" required>
     	邮箱：<input type="text" name="email" required><br><hr>
			
     	年龄：<input type="text" name="age" onkeyup="this.value=this.value.replace(/\D/g,'')" required><br><hr>
     	所在地：<input type="text" name="city" required><br><hr>
     	注册日期：<input type="text" name = "regdate"/><br><hr>
     	性别：
     	<select name="sex">
     	<option value="男" defaultSelected>男</option>
		<option value="女">女</option>
		</select><br/><hr/>
		姓名：<input type="text" name = "realname"/>
		身份证:
		<input type="text" name = "idcard" /><br/><hr/>
		<input type="hidden" name="avatar" id = "ava"/>
    <input type="button" id="bt2" value="提交"/>
     </form>
     
    </div>
    </center>
  </body>
</html>
