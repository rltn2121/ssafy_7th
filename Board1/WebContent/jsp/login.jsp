<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<%
	String contextPath = request.getContextPath();
%>
<body>
	<div class="container">
		<div class="mb-3 d-flex justify-content-center">
	  		<h1 class="display-4">삐따기 세상</h1>
		</div>
		<div class="mb-3">
			<h2>Login</h2>
		</div>
		<div class="mb-3">
		  <label for="userEmail" class="form-label">Email</label>
		  <input type="email" class="form-control" id="userEmail" name="userEmail" value="hong@gildong.com">
		</div>
		<div class="mb-3">
		  <label for="userPassword" class="form-label">제목</label>
		  <input type="password" class="form-control" id="userPassword" name="userPassword" value="1234">
		</div>
		<div>
			<button id="btnLogin" class="btn btn-primary">로그인</button>
			<a href="<%=contextPath%>/jsp/register.jsp" class="btn btn-success">회원가입</a>
		</div>		
	</div>
	<script>
		window.onload = function(){
			document.querySelector("#btnLogin").onclick = function(){
				login();
			}
		}
		
		async function login(){
			// ui value
			let userEmail = document.querySelector("#userEmail").value; /// ssafy
			let userPassword = document.querySelector("#userPassword").value; /// 123
			
			// parameter
			let urlParams = new URLSearchParams({
				userEmail: userEmail, // request.getParameter("...")
				userPassword: userPassword
			});
			
			// post, parameter => fetch option
			let fetchOptions = {
				method: "POST",
				body: urlParams
			};
			
			let response = await fetch("<%= contextPath%>/login", fetchOptions);
			console.log(response);
			let data = await response.json(); // parse : json -> javascript object
			console.log(data);
			if( data.result == "success" ){
				console.log("login success");
				window.location.href="<%= contextPath%>/board/boardMain"
			}else if( data.result == "fail"){
				alert("fail");
			}
		}
	</script>
</body>
</html>



