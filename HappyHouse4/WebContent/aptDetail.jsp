<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.ssafy.dto.*, java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
     <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <style>

        html, body {
            margin: 0;
        }
        #nav{
            height: 50px;
            display: flex;
            justify-content: flex-end;
            align-items: center;
            background-color: pink;
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

        #addressSelect{
            top: 450px;
            height: 50px;
            width: 100%;

            background-color: darkgray;

            justify-content: center;
            display: flex;
            align-items: center;
        }

        #addressSelect select{
            margin-right: 50px;
            text-decoration: none;
        }

        #Info{
            justify-content: center;
            display: flex;
        }

        #information{
            width: 20%;
            
        }

        #map{
            width: 70%;
            margin: 20px;
        }

        #apartMap img{
            width: 100%;
        }

        .apart{
            border-style: groove;
        }

        .apart div{
            padding-left: 10px;
            padding-bottom: 10px;
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

    <div id="Info">
        <div id="information">
            <h1>거래정보</h1>
			<%
				HouseInfo info = (HouseInfo)request.getAttribute("houseinfo");
        		if(info==null){
			%>            
            
          	<h2>검색 결과가 없습니다.</h2> 
            
            <%
        		} else {
        			
        				
            %>
            
            <div class="apart">
                <div><h3><%=info.getNo() %></h3></div>
                <div>동: <%= info.getDong() %></div>
                <div>아파트이름: <%=info.getAptName() %></div>
                <div>건축년도: <%=info.getBuildYear() %></div>
            </div>
            <br>
            
            <%
        			
        		} 
            %>
     
        </div>
        <!-- ì¼ìª½ íë©´ ê±°ëì ë³´ end -->

        <!-- ì¤ë¥¸ìª½íë©´ì ì§ëë§µ -->
        <div id="map" style=""></div>
        
 

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
    </div>

</body>
</html>