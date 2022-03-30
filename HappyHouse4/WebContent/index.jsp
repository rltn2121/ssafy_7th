<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

    <style>

        html, body {
            margin: 0;
        }

        #nav{
            top: 0px;
            left: 0px;
            right: 0px;
            height: 50px;

            display: flex;
            justify-content: flex-end;
            align-items: center;
        }

        #nav img{
            width: 36px;
            border-radius: 50%;
            margin-right: 20px;
        }

        #nav a{
            color: darkolivegreen;
            margin-right: 20px;         
        }

        #nav a:link{
            text-decoration: none;
        }

        #menu{
            top: 50px;
            left: 0px;
            right: 0px;
            height: 100px;
            width: 100%;

            justify-content: center;
            display: flex;
            align-items: center;
        }

        #menu a{
            color: black;
            margin-right: 50px;
            margin-left: 50px;
            text-decoration: none;
        }
        

        .carousel-item img{
            height: 300px;
        }
        
        #addressSelect{
            top: 450px;
            left: 0px;
            right: 0px;
            height: 50px;
            width: 100%;

            background-color: darkgray;

            justify-content: center;
            display: flex;
            align-items: center;
        }

        #addressSelect div{
            margin-right: 50px;
            text-decoration: none;
        }

        #Map{
            top: 500px;
            left: 0px;
            right: 0px;
            width: 100%;
            height: 400px;

            justify-content: center;
            display: flex;
            align-items: center;
        }

        #Map img{
            width: 100%;
            height: 100% ;
        }

        .open{
            display: block;
        }

        .close{
            display: none;
        }

    </style>
    
</head>
<body>
    <div id="AAA">
        <!-- 상단 로그인바 -->
        <div >
            <nav id="nav" calss="navbar navbar-light" style="background-color: pink;">
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
    
        <!-- 메뉴 -->
        <div id="menu">
            <a id="menuAnnounce" href="#">공지사항</a>
            <a id="menuNews" href="/HappyHouse4/house?act=search">아파트 실거래가 조회</a>
            <a id="menuExplore"href="#">주변 탐방</a>
            <a id="menuAttentionLook"href="#">관심 지역 둘러보기</a>
            <!-- 검색 -->
            <nav class="navbar navbar-light bg-light">
                <div class="container-fluid">
                    <form class="d-flex">
                        <input class="form-control me-2" id="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" id="searchBtn" >Search</button>                      
                    </form>
                </div>
            </nav>

        </div>

        <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active" >
                    <img src="img/mainImg.jpg" class="d-block w-100" alt="..." >
                </div>
                <div class="carousel-item">
                    <img src="img/이미지2.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="img/이미지3.jpg" class="d-block w-100" alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>

      
     <div id="addressSelect">
        <!-- <label for="address">전공</label>   -->
        <form method="get" action="/HappyHouse4/house">
        	<input type="hidden" name="act" value="search">
	        <select name="address1" id="address1" onchange="getGugun(this.value);">
	          <!-- multiple -->
	          <option value="" selected>선택</option>
	          <option value="11">서울특별시</option>
	          <option value="26">부산광역시</option>
	          <option value="27">대구광역시</option>
	          <option value="28">인천광역시</option>
	          <option value="29">광주광역시</option>
	          <option value="30">대전광역시</option>
	          <option value="31">울산광역시</option>
	          <option value="36">세종특별자치시</option>
	          <option value="41">경기도</option>
	          <option value="32">강원도</option>
	          <option value="43">충청북도</option>
	          <option value="44">충청남도</option>
	          <option value="45">전라북도</option>
	          <option value="46">전라남도</option>
	          <option value="47">경상북도</option>
	          <option value="48">경상남도</option>
	          <option value="50">제주특별자치도</option>
	        </select>
	        <select name="address2" id="address2" onchange="getDong(this.value);">
	          <option value="" selected>선택</option>
	        </select>
	        <select name="address3" id="address3">
	          <option value="" selected>선택</option>
	        </select>
	        <input type = "submit" value="검색">
        </form>
      </div>

      <!-- ë©ì¸íì´ì§ ìë ì§ë -->
      <div id="Map">
        <img id="mapImg" src="img/mapImg.PNG" />
      </div>
    </div>

    <!-- script ìì -->
    <script>
    	function getGugun(sParam){
    		var $target = $("select[name='address2']");
    		$target.empty();
   			$target.append(`<option value="" selected>선택</option>`);
    		$.ajax({
    			type: "GET",
    			url: "/HappyHouse4/house?act=gugun",
    			data: {
    				address1 : sParam
    				
    				},
    			success: function(data){
    				console.log("받아오기 성공");
    				console.log(data);
    				
    				$.each(data, function(index, item){
    					
    					let name = item.name;
    					let code = item.code;
    					console.log(name);
    					console.log(code);
    					$target.append(`<option value = `+ code +` > ` + name + ` </option>`);
    					
    				});
    				
    				
    		
    			},
    			error: function(xhr){
    				console.log(xhr.responseText);
    				alert("에러발생");
    				return;
    			}
    		});
    	}
    
    
     	function getDong(gugun_code){
    		var $target = $("select[name='address3']");
    		$target.empty();
   			$target.append(`<option value="" selected>선택</option>`);
    		$.ajax({
    			type: "GET",
    			url: "/HappyHouse4/house?act=dong",
    			data: {
    				address2: gugun_code},
    			dataType: "json",
    			success: function(data){
    				console.log(data);
    				
    				$.each(data, function(index, item){
    					
    					let name = item.name;
    					let code = item.code;
    					console.log(name);
    					console.log(code);
    					$target.append(`<option value = `+ code +` > ` + name + ` </option>`);
    					
    				});
    			
    			
    			
    			},
    			error: function(xhr){
    				console.log(xhr.responseText);
    				alert("ìë¬ ë°ì");
    				return;
    			}
    		});
    	}
    	
    
    </script>
  </body>
</html>
