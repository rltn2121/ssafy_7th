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

      /* 회원가입 상자 */
      #signin {
        border: 1px solid lightgray;
        padding: 25px;
      }
    </style>
  </head>

  <body>
     <!-- 상단 로그인바 -->
        <div >
            <nav id="nav" class="navbar navbar-light" style="background-color: pink;">
                <a id="home" href="index.jsp">HAPPY HOUSE</a>
                <%
					HttpSession sess = request.getSession();
					if(sess.getAttribute("id") == null){
				%>
                	<img id="navImg" src="img/noProfile.png" >
                	<a id="navLogin" href="login.jsp">로그인</a>
                	<a id="navRegister" href="register.jsp">회원가입</a>
               	<%
					} else {
               	%>
               		<span><b><%= session.getAttribute("id") %></b>님 로그인 되었습니다. </span>
                	<span><a href="/HappyHouse4/user?act=logout" id="navLogout">로그아웃</a></span>
                	<span><a href="/HappyHouse4/user?act=view" id="navInformation" >회원정보</a></span>
               	<% } %> 
            </nav>
        </div>

    <div id="container">
      <!-- 회원가입 화면 -->
      <div id="signin" class="open">
        <h2 style="color: pink">회원가입</h2>
        <hr>
            <form method="post" action="/HappyHouse4/user?act=regist">
             <div class="input-group mb-3 input-group-sm">
            	<label for="userId2" class="input-group-text">아이디</label>
           	  	<input id="userId2" name="userId2" type="text" class="form-control">
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
  
	        <button  id="btnLogin" style="background: seashell;">회원가입</button>
	        <input type="hidden" name="act" value="login"/>
        
        </form>
      </body>
    </html>

    <!-- stript 시작 -->

