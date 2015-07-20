<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>HelloWorld</title>
<head>
<script type="text/javascript" src="/GitTest/JQuery/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	
	var remaining_time = 3;
	$(function(){ 
		show_time();
	});
	
	function show_time(){
		remaining_time = remaining_time - 1;
		alert(remaining_time == 0);
		if(remaining_time == 0){
			window.location.href="/GitTest/index.do";
		}
		$("#remaining_time").html(remaining_time);
		setTimeout("show_time()",1000); 	
	}
	
</script>
</head>
<body>
	<h2 id="sTitile">激活成功</h2><span id="remaining_time">3</span>秒后自动跳转<a href="localhost:8080/GitTest/index.do">无法跳转</a>
</body>