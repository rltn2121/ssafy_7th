<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8" import="java.util.*, com.ssafy.dto.NoteBook"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 관리</title>
<style>
table.pdList {
  border-collapse: collapse;
  text-align: left;
  line-height: 1.5;
  border-top: 1px solid #ccc;
  border-left: 3px solid #369;
}
table.pdTable {
  border-collapse: collapse;
  text-align: left;
  line-height: 1.5;
}

table.pdTable th {
  padding: 10;
  font-weight: bold;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
  background: #f3f6f7;
  
}
table.pdTable td {
  padding: 10;
  vertical-align: top;
  border-left: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
}
input:focus, select:focus{
outline : none;
}

.inputSubmit { 
padding: 3px; 
border: none; 
border-radius: 5px; 
color: black; 
font-weight : bold; 
background-color:white;
cursor: pointer; 
outline: none; 
}



</style>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>

<h4><b><%= session.getAttribute("id") %></b>님 로그인 되었습니다. <a href="main.do?action=logout">로그아웃</a></h4>
<table width=750 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
  <!--contents-->
	  <table class=pdList width=730 height=30 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>상품 관리 - 리스트</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	
	  </td>
	</tr>
</table>  

<table>
	<tr>
		<td>상품번호</td>
		<td>모델이름</td>
		<td>가격</td>
		<td>제조사명</td>
	</tr>
	
	<%
		NoteBook book = (NoteBook)request.getAttribute("notebook");
		if(book != null) {
	%>
	
		<tr>
			<td>
			<td><%= book.getNoteCode()%></td>
			<td><%= book.getModel()%></td>
			<td><%= book.getPrice()%></td>
			<td><%= book.getCompany()%></td>
		</tr>
	<%
		} 
		
		else {
	%>
	<h2> 데이터가 없습니다</h2>
	<%
		}
	%>
</table>
<a class=pdSub href="main.do?action=NOTESEARCH">메인 페이지로</a>
<a class=pdSub href="main.do?action=delete&noteCode=<%= book.getNoteCode()%>">삭제</a>
</body>

</html>