<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/header.jsp" %>
	<div align="center">
		<h3>SSAFY 방명록!!!</h3>
		<a href="<%= root %>/guestbook/write.jsp">글쓰기</a><br> 
		<a href="<%= root %>/article?act=list">글목록</a>
	</div>
<%@ include file="/template/footer.jsp" %>