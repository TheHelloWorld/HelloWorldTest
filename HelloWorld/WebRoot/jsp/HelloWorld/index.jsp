<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>HelloWorld</title>
<head>
<script type="text/javascript" src="/HelloWorld/JQuery/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function userLogin(){
		$.ajax({
			url:"/HelloWorld/checkUser.do",
			type:"POST",
			data:{
				username:$("#username").val(),
				password:$("#password").val()
			},
			success:function(data){
				if(data != "N"){
					window.location.href="/HelloWorld/userIndex.do?id="+data;
				}else{
					$("#password").val("");
					alert("用户名或密码错误");
				}
			}
			
		});
		
	}
</script>
</head>
<body>
	<div>
		<div><span>用户名：</span><input id="username" type="text" /></div>
		<div><span>密码：</span><input id="password" type="password"/></div>
		<input type="button" onclick="userLogin()" value="提交">
		<a href="/HelloWorld/jsp/HelloWorld/register/checkHelloWorld.jsp">注册</a>
	</div>
</body>