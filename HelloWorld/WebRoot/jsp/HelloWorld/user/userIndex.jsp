<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>
<title>HelloWorld</title>
<head>
<script type="text/javascript" src="/HelloWorld/JQuery/jquery-1.11.3.min.js"></script>
</head>
<body>
	<div>
		<p>${account.username}</p>
		<p>等级：<span id="nowlevel">${account.nowlevel}</span>&nbsp;&nbsp;经验：<span id="experience">${account.experience}</span></p>
	</div>
	<div>
		<c:if test="${listAMission.size() ==0}">
			目前还没有任务
		</c:if>
		<c:if test="${listAMission.size() > 0}">
			
		</c:if>
	</div>
	<div>
		<c:if test="${listAMission.size() ==0}">
			您目前还没有任务
		</c:if>
		<c:if test="${listAMission.size() > 0}">
			
		</c:if>
	</div>
</body>