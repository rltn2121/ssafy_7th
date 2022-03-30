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
<h4><b><%= session.getAttribute("id") %></b>님 로그인 되었습니다. <a href="main.do?action=logout">로그아웃</a></h4>
<table width=750 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
  <!--contents-->
	  <table class=pdList width=730 height=30 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>상품 관리 - 상품 등록</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <!-- write Form  -->
	  <form method="post" action="${pageContext.request.contextPath }/main.do">
	  <table class=pdTable border="0" cellpadding="0" cellspacing="1" width="730" bgcolor="BBBBBB">
		  <tr>
			<th width=100 align=center bgcolor="E6ECDE" height="22">모델번호</td>
			<td width=630 bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="border:none;" name="noteCode"/>  
			</td>
		  </tr>
		  <tr>
			<th width=100 align=center bgcolor="E6ECDE" height="22">모 델 명</td>
			<td width=630 bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="border:none;" name="model"/>
			</td>
		  </tr>
		  <tr>
			<th width=100 align=center bgcolor="E6ECDE" height="22">가&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;격</td>
			<td width=630 bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="border:none;" name="price"/>원
			</td>
		  </tr>
		  <tr>
			<th width=100 align=center bgcolor="E6ECDE" height="22">제 조 사</td>
			<td width=630 bgcolor="ffffff" style="padding-left:10; height:100%;">
				<select NAME="company" id="company" tabindex="5"  style="width:100px; padding:5px; border:none; align:center">
				<option value="삼성">삼성</option>
				<option value="엘지">엘지</option>
				<option value="애플">애플</option>
				</select>
			</td>
		  </tr>		  
	  </table>
	  
	  <table width=730 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=right>
			<input class="inputSubmit" type="submit" value="상품등록" />&nbsp;
			<input class="inputSubmit" type="reset" value="취소" /> 
			</td>
		  </tr>
	  </table>
	  <input type="hidden" name="action" value="NOTESAVE"/>
	  </form>
	  </td>
	</tr>
</table>  

</body>

</html>