<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.guestbook.model.MemberDto"%>
<%@ include file="/template/header.jsp" %>
	<div align="center">
		<h3>SSAFY 방명록!!!</h3>
<%
String msg = (String)request.getParameter("msg");
if(msg != null){
%>

<script>

alert("<%=msg%>");
</script>

<%
} 
%>
		<%
		MemberDto memberDto = (MemberDto)session.getAttribute("userInfo");
		if(memberDto == null){
		%>
			<a href="<%= root %>/article?act=mvregister">회원가입</a>
			<a href="<%= root %>/user?act=mvlogin">로그인</a>
		<%} else{%>
			<strong><%= memberDto.getUserName() %>(<%=memberDto.getUserId() %>)</strong>님 안녕하세요<br>
			<a href="<%= root %>/user?act=logout">로그아웃</a>
			<br>
			<a href="<%= root %>/article?act=list">글목록</a>
		<%
		} 
		%>
	</div>
<%@ include file="/template/footer.jsp" %>