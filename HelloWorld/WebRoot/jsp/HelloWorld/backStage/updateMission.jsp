<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>HelloWorld</title>
<head>
<link rel="stylesheet" type="text/css" href="/HelloWorld/css/tcal.css" />
<script type="text/javascript" src="/HelloWorld/JQuery/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/HelloWorld/JQuery/tcal.js"></script> 

<script type="text/javascript">
	var flag = true;
	
	$(function(){
		changeNum();
	});	
	
	function changeNum(){
		if($("#type").val() == "personal"){
			$("#realnum").hide();
			$("#num").val(1);
		}else{
			$("#num").val("");
			$("#realnum").show();
		}
	}
	
	function sub(){
		checkNum();
		if($("#type").val() == "group"){
			if($("#num").val()<2){
				alert("人数不能少于2人！");
				flag = false;
			}
		}
		if(flag){
			$("#form1").submit();
		}
	}
	
	function checkNum(){
		if(isNaN($("#experience").val())){
			flag = false;
			alert("经验值必须是数字！");		
		}else{
			flag = true;
		}
	}
	
	function goBack(){
		window.location.href="/HelloWorld/userIndex.do?id="+$("#publisher_id").val();
	}
		
</script>
</head>
<body>
	<div>
		<form id="form1" action ="/HelloWorld/updateMission.do" method="POST">
			<input type="hidden" id="publisher_id" name="publisher_id" value="${model.publisher_id}">		
			<input type="hidden" name="id" value="${model.id}"/>
			<input type="hidden" name="returnType" value="${model.type}"/>
			<p>内容：<input type="text" id="content" name="content" value="${model.content}"></p>
			<p>经验值：<input type="text" id="experience" name="experience" onblur="checkNum()" value="${model.experience}"></p>
			<p>
				任务类型：
				<select name="type" id="type" onchange="changeNum()">
					<option value="personal">个人</option>
					<option value="group">小组</option>
					<option value="pog">小组或个人</option>
				</select>
			</p>
			<p id="realnum">人数：<input type="text" id="num" name="num" value="${model.num}" /></p>
			<p>完成时间：<input type="text" id="dead_line" name="dead_line" class="tcal" value="${model.dead_line}" /></p>
			<input type="button" value="提交" onclick="sub()" />
			<input type="reset" value="重置"/>
			<input type="button" value="返回" onclick="goBack()"/>
		</form>
	</div>
</body>