<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자정보사이트</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<style>
	label {
		display: inline-block;
		width: 80px;
	}
</style>
</head>

<%
	String contextPath = request.getContextPath();
%>

<body>
	<h1>SSAFY 사용자 관리</h1>
	<form method="post" action="<%=contextPath %>/register">
		<fieldset>
		<legend>사용자 정보 입력</legend>
		<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
		<input type="hidden" name="action" value="regist">
		<label for="userName">이름</label>
		<input type="text" id="userName" name="userName"><br>
		<label for="userEmail">이메일</label>
		<input type="email" id="userEmail" name="userEmail"><br>
		<label for="userPassword">비밀번호</label>
		<input type="password" id="userPassword" name="userPassword"><br>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
		</fieldset>
	</form>
</body>
</html>