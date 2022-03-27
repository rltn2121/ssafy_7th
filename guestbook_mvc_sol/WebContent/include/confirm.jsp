<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test="${!empty userinfo}">
	<div class="col-lg-12 text-right mb-2">
		<strong>${userinfo.userName}</strong>님 환영합니다.
		<a href="${root}/user?act=logout">로그아웃</a>
	</div>
</c:if>