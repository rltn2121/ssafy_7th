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
       <!-- ?????? ???????????? -->
        <div >
            <nav id="nav" calss="navbar navbar-light" style="background-color: pink;">
                <a id="home" href="index.jsp">HAPPY HOUSE</a>
                <%
					HttpSession sess = request.getSession();
					if(sess.getAttribute("id") == null){
				%>
                	<img id="navImg" src="img/noProfile.png" >
                	<a id="navLogin" href="login.jsp">?????????</a>
                	<a id="navRegister" href="register.jsp">????????????</a>
               	<%
					} else {
               	%>
               		<span><b><%= session.getAttribute("id") %></b>??? ????????? ???????????????. </span>
                	<span><a href="/HappyHouse4/user?act=logout" id="navLogout">????????????</a></span>
                	<span><a href="/HappyHouse4/user?act=view" id="navInformation" >????????????</a></span>
               	<% } %> 
            </nav>
        </div>

      <div id="addressSelect">
        <!-- <label for="address">??????</label>   -->
        <form method="get" action="/HappyHouse4/house">
        	<input type="hidden" name="act" value="search">
	        <select name="address1" id="address1" onchange="getGugun(this.value);">
	          <!-- multiple -->
	          <option value="" selected>??????</option>
	          <option value="11">???????????????</option>
	          <option value="26">???????????????</option>
	          <option value="27">???????????????</option>
	          <option value="28">???????????????</option>
	          <option value="29">???????????????</option>
	          <option value="30">???????????????</option>
	          <option value="31">???????????????</option>
	          <option value="36">?????????????????????</option>
	          <option value="41">?????????</option>
	          <option value="32">?????????</option>
	          <option value="43">????????????</option>
	          <option value="44">????????????</option>
	          <option value="45">????????????</option>
	          <option value="46">????????????</option>
	          <option value="47">????????????</option>
	          <option value="48">????????????</option>
	          <option value="50">?????????????????????</option>
	        </select>
	        <select name="address2" id="address2" onchange="getDong(this.value);">
	          <option value="" selected>??????</option>
	        </select>
	        <select name="address3" id="address3">
	          <option value="" selected>??????</option>
	        </select>
	        <input type = "submit" value="??????">
        </form>
      </div>

    <div id="Info">
        <div id="information">
            <h1>????????????</h1>
			<%
				HouseInfo info = (HouseInfo)request.getAttribute("houseinfo");
        		if(info==null){
			%>            
            
          	<h2>?????? ????????? ????????????.</h2> 
            
            <%
        		} else {
        			
        				
            %>
            
            <div class="apart">
                <div><h3><%=info.getNo() %></h3></div>
                <div>???: <%= info.getDong() %>????</div>
                <div>?????????????????: <%=info.getAptName() %></div>
                <div>????????????: <%=info.getBuildYear() %></div>
            </div>
            <br>
            
            <%
        			
        		} 
            %>
     
        </div>
        <!-- ???????????? ???????????? ???????????????????????? end -->

        <!-- ???????????????????????????????????? ?????????????????? -->
        <div id="map" style=""></div>
        
 

    <script>
    	function getGugun(sParam){
    		var $target = $("select[name='address2']");
    		$target.empty();
   			$target.append(`<option value="" selected>??????</option>`);
    		$.ajax({
    			type: "GET",
    			url: "/HappyHouse4/house?act=gugun",
    			data: {
    				address1 : sParam
    				
    				},
    			success: function(data){
    				console.log("???????????? ??????");
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
    				alert("????????????");
    				return;
    			}
    		});
    	}
    
    
     	function getDong(gugun_code){
    		var $target = $("select[name='address3']");
    		$target.empty();
   			$target.append(`<option value="" selected>??????</option>`);
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
    				alert("???????????? ????????????");
    				return;
    			}
    		});
    	}
    	
    
    </script>
    </div>

</body>
</html>