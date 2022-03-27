<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- DTO를 참조하기 위해서 import 처리가 필요하다. -->
<%@ page import="com.ssafy.backend.dto.*"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 100px;
}
</style>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<h1>도서 상세</h1>
	<h2>등록 도서 상세</h2>
	<%-- c:if 태그를 이용해 request 영역에 book이 있다면 내용을 출력한다. --%>
	<c:if test="${!empty book }">
		<table>
			<thead>
				<tr>
					<th>항목</th>
					<th>내용</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>도서번호</td>
					<td>${book.isbn }</td>
				</tr>
				<tr>
					<td>도서명</td>
					<td>${book.title }</td>
				</tr>
				<tr>
					<td>저자</td>
					<td>${book.author }</td>
				</tr>
				<tr>
					<td>가격</td>
					<td>${book.price }</td>
				</tr>
				<tr>
					<td>설명</td>
					<td>${book.desc }</td>
				</tr>
			</tbody>
		</table>
	</c:if>
	<%-- c:if 태그를 이용해 request 영역에 book이 없다면 정보가 없음을 출력한다. --%>
	<c:if test="${empty book }">
		<p>등록된 도서가 없습니다.</p>
	</c:if>
	<!-- 다시 도서를 등록할 수 있는 링크를 제공한다. -->
	<a href="./main?action=remove&isbn=${book.isbn }">삭제</a>
	<li><a href="./main?action=list">도서 목록</a> 
</body>
</html>