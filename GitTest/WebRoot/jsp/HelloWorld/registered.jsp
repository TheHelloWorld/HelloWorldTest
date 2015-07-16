<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
	<script type="text/javascript" src="/GitTest/JQuery/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		var mailFlag = true;
		var passwordFlag = true;
		
		function checkMail(){
			var username = $("#username").val();
			if (!username.match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) { 
				$("#mailMsg").html("邮箱格式不正确"); 
				//$("#confirmMsg").html("<font color='red'>邮箱格式不正确！请重新输入！</font>"); 
				$("#username").focus(); 
			}else{
				$.ajax({
					url:"/GitTest/checkEmail.do",
					data:{
						email:$("#username").val()
					},
					type:"POST",
					success:function(data){
						if(data == "Y"){
							$("#mailMsg").html("");
							mailFlag = true;
						}else{
							$("#mailMsg").html("该邮箱以被占用,请更换");
							mailFlag = false;
						}
					},error:function(e){
						
					}
				});
				
			}
		}
		
		function checkSecond(){
			var firstValue = $("#firstPassword").val();
			var secondValue = $("#secondPassword").val();
			
			if(firstValue.length !=0 && secondValue.length != 0 && firstValue != secondValue){
				$("#pwdMsg").html("两次的密码不一致");
				passwordFlag = false;
			}else{
				$("#pwdMsg").html("");
				passwordFlag = true;
			}
		}
		
		function submitAccount(){
			$.ajax({
				url:"/GitTest/addAccount.do",
				data:{
					username:$("#username").val(),
					password:$("#secondPassword").val()
				},
				type:"POST",
				success:function(data){
					if(passwordFlag && mailFlag){
						if(data == "Y"){
							alert("您已注册成功，请去您的邮箱激活");
							window.location.href="/GitTest/jsp/HelloWorld/inde.jsp";
						}else{
							alert(data);
						}
					}
				},error:function(e){
					
				}
			});
		}
		
	</script>
</head>
<body>
	<form action="" method="post">
		<div>邮箱：<input id="username" onblur="checkMail()" type="text"><span id="mailMsg"></span></div>
		<div>密码：<input  type="password" id="firstPassword"/></div>
		<div>再次输入密码：<input  type="password" id="secondPassword" onblur="checkSecond()"/><span id="pwdMsg"></span></div>
		<input type="button" onclick="submitAccount()" value="提交">
	</form>
</body>
</html>