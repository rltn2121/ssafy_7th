<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String contextPath = request.getContextPath();
%>
<%-- 
Bootstrap 5
jQuery
ajax with jQuery $.ajax()
post with urlencoded
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- Bootstrap 5 버전 -->
	<!-- https://getbootstrap.com/docs/5.0/getting-started/introduction/ -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
	
	<!-- jQuery 는 학습용으로 사용하는 것으로 위 Bootstrap 5는 더이상 아래의 jQuery 를 필요로 하지 않는다. -->
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>


	<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/alertify.min.js"></script>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/alertify.min.css"/>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/themes/default.min.css"/>
	<title>회원 가입</title>
</head>
<body>
<br>
<br>
	<div class="container">
		<div class="mb-3 d-flex justify-content-center">
	  		<h1 class="display-4">삐따기 세상</h1>
		</div>
		<div class="mb-3">
			<h2>Register</h2>
		</div>
		<form novalidate>
            <div class="mb-3">
                <label for="userName">User Name:</label>
                <input type="text" class="form-control" id="userName" placeholder="Enter userName" name="userName" required>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="mb-3">
                <label for="userPassword">Password:</label>
                <input type="password" class="form-control" id="userPassword" placeholder="Enter password" name="userPassword" required>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">1개 이상의 특수문자, 대소문자 및 숫자를 포함하고 8자리 이상이여야 합니다.</div>
            </div>
            <div class="mb-3">
                <label for="userPassword2">Password Confirm:</label>
                <input type="password" class="form-control" id="userPassword2" placeholder="Confirm password" name="userPassword2" required>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Please fill out this field.</div>
            </div>
            <div class="mb-3">
                <label for="userEmail">Email:</label>
                <input type="text" class="form-control" id="userEmail" placeholder="Enter email" name="userEmail" required>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Please fill out this field.</div>
            </div>
        </form>
		<div>
			<button id="btnRegister" class="btn btn-primary">가입</button>
		</div>
	</div>

<script>
$(document).ready(function(){
	
    $("#userName").focus();

    // manually check
    $("#userName").blur(function () {
        if (validateUserName($(this))) {
            $(this).removeClass("is-invalid").addClass('is-valid');
        } else {
            $(this).removeClass("is-valid").addClass('is-invalid');
        }
    });

    $("#userPassword").blur(function () {
        if (validatePassword($(this))) {
            $(this).removeClass("is-invalid").addClass('is-valid');
        } else {
            $(this).removeClass("is-valid").addClass('is-invalid');
        }
    });

    $("#userPassword2").blur(function () {
        if (validatePassword2($(this))) {
            $(this).removeClass("is-invalid").addClass('is-valid');
        } else {
            $(this).removeClass("is-valid").addClass('is-invalid');
        }
    });

    $("#userEmail").blur(function () {
        if (validateEmail($(this))) {
            $(this).removeClass("is-invalid").addClass('is-valid');
        } else {
            $(this).removeClass("is-valid").addClass('is-invalid');
        }
    });

    $(':input').focus(function () {
        $(this).removeClass('is-valid is-invalid');
    });
    
	//submit
    $("#btnRegister").click(function(){
        if( $("form").find(".is-invalid").length > 0 ){
            alert("입력이 올바르지 않습니다.")
        }else{
        	register();
        }
    });

});


function validateUserName(userName) {
    if (userName.val().length >= 4) return true;
    else return false;
}

function validatePassword(userPassword) {
	let userPasswordValue = userPassword.val();

	var patternEngAtListOne = new RegExp(/[a-zA-Z]+/);// + for at least one
	var patternSpeAtListOne = new RegExp(/[~!@#$%^&*()_+|<>?:{}]+/);// + for at least one
	var patternNumAtListOne = new RegExp(/[0-9]+/);// + for at least one
	
	if( patternEngAtListOne.test( userPasswordValue ) 
			&& patternSpeAtListOne.test( userPasswordValue )  
			&& patternNumAtListOne.test( userPasswordValue )
			&& userPasswordValue.length >= 8
	){
		return true;
	}
    else return false;
}

function validatePassword2(userPassword2) {
    if (userPassword2.val() == $("#userPassword").val()) return true;
    else return false;
}

function validateEmail(userEmail) {
    // ^ 시작일치, $ 끝 일치
    // {2, 3} 2개 ~ 3개
    // * 0회 이상, + 1회 이상
    // [-_.] - 또는 _ 또는 .
    // ? 없거나 1회
    let regexp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    if (regexp.test(userEmail.val())) return true;
    else return false;
}

function register() {
      $.ajax({
         type : 'post',
         url : '<%=contextPath%>/register',
         dataType : 'json', // 받는 response 가 json 이다 라고 알려주는 코드
         data : {
            userName : $("#userName").val(),
            userEmail : $("#userEmail").val(),
            userPassword : $("#userPassword").val()
         },
         success : function(data, status, xhr) { // alertify or another welcome page 이동
        	 
        	 console.log(data.result);
         	
        	 if( data.result == "success" ){
				alertify.alert('Welcome!', '회원가입을 축하합니다. 로그인 페이지로 이동합니다.', function(){
					window.location.href="<%= contextPath%>/jsp/login.jsp";
				});
			}else{
				alertify.error('회원가입에 문제가 생겼습니다.');
				console.log(xhr);
			}
         },
         error : function(jqXHR, textStatus, errorThrown) {
        	 alert("서버 오류!!");
			console.log(jqXHR);
         }
      });

   }
</script>
</body>
</html>