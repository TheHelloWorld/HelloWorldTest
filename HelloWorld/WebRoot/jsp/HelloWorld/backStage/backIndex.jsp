<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>HelloWorld</title>
<head>
<script type="text/javascript" src="/HelloWorld/JQuery/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function updateThis(id){
		window.location.href="/HelloWorld/toUpdateMission.do?id="+id;
	}
	
	function addMission(id){
		window.location.href="/HelloWorld/toAddMission.do?id="+id;
	}

</script>
</head>
<body>
	<div>
		<p>${account.username}</p>
		<p>等级：<span id="nowlevel">${account.nowlevel}</span>&nbsp;&nbsp;经验：<span id="experience">${account.experience}</span></p>
	</div>
	<div>
		<div><input type="button" value="添加任务" onclick="addMission(${account.id})"></div>
		<c:if test="${listAMission.size() ==0}">
			目前还没有任务
		</c:if>
		<p>${listAMission.size()}</p>
		<c:if test="${listAMission.size() > 0}">
			<c:forEach var="index" items="${listAMission}" varStatus="mission">
				<p>
					<span>
						经验值：${index.experience}
					</span>
					<span>
						任务类型：
						<c:if test="${index.type == group}">
							小组
						</c:if>
						<c:if test="${index.type == personal}">
							个人
						</c:if>
						<c:if test="${index.type == pog}">
							小组或个人
						</c:if>
					</span>
					<span>
						人数：<c:out value="${index.num}"/>
					</span>
					<span>
						完成时间：<c:out value="${index.dead_line}"/>
					</span>
					
					<span>
						<input type="button" value="修改" onclick="updateThis(${index.id})">
					</span>
				</p>
			</c:forEach>
		</c:if>
	</div>
	<div>
		<c:if test="${listIMission.size() ==0}">
			目前还没有已接任务
		</c:if>
		<c:if test="${listIMission.size() > 0}">
			<c:forEach var="index" items="${listIMission}" varStatus="mission">
				<p>
					<span>
						经验值：<c:out value="${mission.experience}"/>
					</span>
					<span>
						任务类型：
						<c:if test="${mission.type == group}">
							<c:out value="小组"/>
						</c:if>
						<c:if test="${mission.type == personal}">
							<c:out value="个人"/>
						</c:if>
						<c:if test="${mission.type == pog}">
							<c:out value="小组或个人"/>
						</c:if>
					</span>
					<span>
						人数：<c:out value="${mission.num}"/>
					</span>
					<span>
						完成时间：<c:out value="${mission.dead_line}"/>
					</span>
				</p>
			</c:forEach>
		</c:if>
	</div>
</body>