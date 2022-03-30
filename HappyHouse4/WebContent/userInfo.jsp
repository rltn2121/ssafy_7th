<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.ssafy.dto.*"%>
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
      <div id="Info">
      <h2 style="color: pink">회원 정보</h2>      
      <hr>   
      <table class="table table-bordered">
        <thead>
          <tr>
            <th>목록</th>
            <th>정보</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>아이디</td>
            <td><%=request.getAttribute("id") %></td>
          </tr>
          <tr>
            <td>패스워드</td>
            <td><%=request.getAttribute("pw") %></td>
          </tr>
          <tr>
            <td>이름</td>
            <td><%=request.getAttribute("nm") %></td>
          </tr>
          <tr>
            <td>주소</td>
            <td><%=request.getAttribute("add") %></td>
          </tr>
          <tr>
            <td>전화번호</td>
            <td><%=request.getAttribute("tell") %></td>
          </tr>
        </tbody>
      </table>
      <hr>
      <button id="EditInfo" style="background: seashell" onclick="location.href='userInfoUpdate.jsp'">회원 정보 수정</button>
      <button id="Delete" style="background: seashell" onclick="location.href='/HappyHouse4/user?act=remove'">회원 탈퇴</button>
      </div>
	<%
			}
	%>
    <!-- stript 시작 -->

  </body>
</html>
