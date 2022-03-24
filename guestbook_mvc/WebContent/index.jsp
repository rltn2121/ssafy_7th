<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.guestbook.model.MemberDto"%>
   
<%@ include file="/template/header.jsp" %>
	<div align="center">
		<h3>SSAFY 방명록!!!</h3>
		
		
		<%
			MemberDto memberDto = (MemberDto)session.getAttribute("userInfo");
		if(memberDto == null){
		%>
		
		<a href="<%= root %>/user?act=mvregister">회원가입</a>
		<a href="<%= root %>/user?act=mvlogin">로그인</a>
		
		<%
		} else {
		%>
		<a href="<%= root %>/user?act=list">글목록</a>
		
		<%
		}
		%>
		
		
	</div>
<%@ include file="/template/footer.jsp" %>