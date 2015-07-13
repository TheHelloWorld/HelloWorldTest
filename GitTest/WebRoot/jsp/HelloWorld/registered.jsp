<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
	<script type="text/javascript" src="JQuery/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		function checkMail(){
			var username = $("#username").val();
			if (!username.match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) { 
				$("#mailMsg").html("邮箱格式不正确"); 
				//$("#confirmMsg").html("<font color='red'>邮箱格式不正确！请重新输入！</font>"); 
				$("#username").focus(); 
			}else{
				$("#mailMsg").html(""); 
			}
		}
		
		function checkSecond(){
			var firstValue = $("#firstPassword").val();
			var secondValue = $("#secnodPassword").val();
			
			if(firstValue != secondValue){
				$("#pwdMsg").html("两次的密码不一致");
			}else{
				
			}
		}
		
	</script>
</head>
<body>
	<form action="" method="post">
		<div>邮箱：<input id="username" onblur="checkMail()" type="text"><span id="mailMsg"></span></div>
		<div>密码：<input  type="password" id="firstPassword"/></div>
		<div>再次输入密码：<input  type="password" id="secondPassword" onblur="checkSecnod()"/><span id="pwdMsg"></span></div>
		<input type="submit" value="提交">
	</form>
</body>
</html>