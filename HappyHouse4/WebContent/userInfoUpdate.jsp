<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
    />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>Document</title>
    <style>
      html,
      body {
        height: 100%;
      }
      #container {
        display: flex;
        justify-content: center;
        align-items: center;

        height: 100%;
      }

      #nav {
        position: fixed;
        top: 0px;
        left: 0px;
        right: 0px;
        height: 50px;

        display: flex;
        justify-content: flex-end;
        align-items: center;

        background-color: pink;
      }

      /* 프로필 사진 */
      #nav img {
        width: 36px;
        border-radius: 50%;
        margin-right: 20px;
      }

      /* 프로필 문자(로그인, 회원가입) */
      #nav a {
        color: darkolivegreen;
        margin-right: 20px;
      }

      /* (로그인 회원가입)밑줄 없애기 */
      #nav a:link {
        text-decoration: none;
      }

      #Info {
        border: 1px solid lightgray;
        padding: 25px;
      }
    </style>
  </head>

  <body>
   <%
			HttpSession sess = request.getSession();
			if(sess.getAttribute("id") == null){
		%>
		<h1>로그인이 필요한 서비스입니다.
		<a id="navLogin" href="/HappyHouse4/login.jsp">로그인</a>
		</h1>
		<%
			} else { 
		%>
    <div id="nav">
      <a id="home" href="index.jsp" ">HAPPY HOUSE</a>
      <img id="navImg" src="img/아이언맨.png" />
      <a id="navLogin" href="#">로그아웃</a>
      <a id="navRegister" href="userInfo.jsp">회원정보</a>
    </div>

    <div id="container">
      <!-- 회원정보 화면 -->
      <div id="Info">
        <h2 style="color: pink">회원정보 수정하기</h2>
        <hr>
        <div id="Info">
          <!-- 아이디(변경 불가) -->
           <form method="post" action="user?act=edit">
             <div class="input-group mb-3 input-group-sm">
            	<label for="userId2" class="input-group-text">아이디</label>
           	  	<input id="userId2" value = "<%= session.getAttribute("id") %>" readonly = "readonly" name="userId2" type="text" class="form-control">
          	</div>
             <div class="input-group mb-3 input-group-sm">
        	  	<label for="password" class="input-group-text">비밀번호</label>
           	  	<input id="password" name="password" type="password" class="form-control">
          	</div>
          	   <div class="input-group mb-3 input-group-sm">
        	  	<label for="password" class="input-group-text">이름</label>
           	  	<input id="name" name="name" type="text" class="form-control">
          	</div>
          	   <div class="input-group mb-3 input-group-sm">
        	  	<label for="password" class="input-group-text">주소</label>
           	  	 <input id="address" name="address" type="text" class="form-control">
          	</div>
          	   <div class="input-group mb-3 input-group-sm">
        	  	<label for="password" class="input-group-text">전화번호</label>
           	  	<input id="number" name="number" type="text" class="form-control">
  
	        <button  id="btnLogin" style="background: seashell;">회원정보수정</button>
	        <input type="hidden" name="act" value="edit"/>
        
        </form>
              
           
      </div>

    
    <%
			}
	%>
  </body>
</html>
