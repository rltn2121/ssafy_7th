<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
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


<table width=750 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
  <!--contents-->
	  <table class=pdList width=730 height=30 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>상품 관리 - 에러</b></td>
		  </tr>
	  </table>  
	  <br>
	  <h1>처리 중 오류가 발생했습니다</h1>
	
	  </td>
	</tr>
</table>  

<a class=pdSub href="main.do?action=NOTESEARCH">상품 목록 조회</a>
</body>

</html>