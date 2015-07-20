<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>HelloWorld</title>
<head>
<script type="text/javascript" src="/GitTest/JQuery/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	var type="";
	
	function changeType(){
		type = $("#type").val();
	}
	
	function checkHelloWorld(){
		if(type == "backstage"){
			$.ajax({
				url:"/GitTest/checkHelloWorld.do",
				data:{
					str:$("#test").val()
				},
				type:"POST",
				success:function(data){
					if(data == "Y"){
						alert("msg:HelloWorld!");
						window.location.href="/GitTest/jsp/HelloWorld/registered.jsp";
					}else{
						alert("HelloWorld err msg : "+data);
					}
				}			
			});
		}else{
			try{
				eval($("#test").val());
				var str = $("#test").val()+"";
				str = str.toLowerCase();
				//alert(str);
				if(str.split("helloworld") != undefined){
					alert("msg:HelloWorld!");
					window.location.href="/GitTest/jsp/HelloWorld/registered.jsp";
				}
			}catch(e){
				console.log("HelloWorld err msg : "+e.message);
			}
		}
	}	
</script>
</head>
<body>
	<span>语言类型：</span>
	<select id="type" onchange="changeType()">
		<option value="front">前端</option>
		<option value="backstage">后端</option>
	</select><br/>
	<textarea id="test"></textarea><br/>
	<input type="button" onclick="checkHelloWorld()" value="提交">

</body>
</html>