<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String name = request.getParameter("name");
	response.setContentType("text/html; charset=utf-8");
 %>
<!DOCTYPE html>
<html>

<style>
	#message{
		color:red;
	}
</style>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 id="message">안녕하세요, <%=name %></h1>
	<button type="button" 
			onclick='document.getElementById("message").innerHTML = "Hello JavaScript!"'>Click Me!</button>
			
	<script>
		console.log("hello")
	</script>
</body>
</html>