<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.PersonDto" %>
    <%
    	// getAttribute는 항상 Object 타입으로 반환되기 때문에 반드시 캐스팅 해야 함
    	PersonDto dto = (PersonDto) request.getAttribute("dto");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Person Info</h1>
	<h2>PersonId: <%= dto.getPersonId() %> 
	/ Person Name: <%= dto.getPersonNm() %>
	/ Person Age: <%= dto.getPersonAge() %></h2>
</body>
</html>