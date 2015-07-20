<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
<head>
	<title>My JSP 'hello.jsp' starting page</title>  
	<meta http-equiv="pragma" content="no-cache">  
	<meta http-equiv="cache-control" content="no-cache">  
</head>  
	<body>  
	  	  你好:<%=request.getAttribute("name") %>，现在时间是<%= new Date() %>  
	</body>  
</html>