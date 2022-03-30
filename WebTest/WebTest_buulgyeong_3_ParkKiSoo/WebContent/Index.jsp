<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1, h4{
	text-align: center;
}
a {
	text-align: center;
	margin: 10px;
}
.pdSub {
  margin-top: 50px;
  width: 80%;
  height: 50px;
  border: 0;
  outline: none;
  border-radius: 40px;
  font-size: 1.2em;
  letter-spacing: 2px;
  text-decoration : none;
  color: black;
}

</style>
</head>
<body>



<%
	HttpSession sess = request.getSession();
	if(sess.getAttribute("id") == null){
%>
<!-- 로그인  구현  -->

	  <form method="post" action="${pageContext.request.contextPath }/main.do">
	  <table class=pdTable border="0" cellpadding="0" cellspacing="1" width="730" bgcolor="BBBBBB">
	  	<label for="id"> 아이디</label>
		  <input type="text" name="id">
		  <label for="pw"> 비밀번호</label>
		  <input type="password" name="pw">
	  </table>
	  
	  <table width=730 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=right>
			<input class="inputSubmit" type="submit" value="로그인" />&nbsp;
			</td>
		  </tr>
	  </table>
	  <input type="hidden" name="action" value="login"/>
	  </form>
<%
	}
	else{
%>

<h1> 메인 페이지 </h1>
<p/>

<p/>
	<h4><a class=pdSub href="main.do?action=NOTEREG">상품 등록</a><a class=pdSub href="main.do?action=NOTESEARCH">상품 목록</a></h4>
	<h4><b><%= session.getAttribute("id") %></b>님 로그인 되었습니다. <a href="main.do?action=logout">로그아웃</a></h4>
<%
	}
%>
</body>
</html>