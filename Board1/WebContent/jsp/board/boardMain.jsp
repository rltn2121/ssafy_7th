<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="board.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Main</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

	<!-- jQuery 는 학습용으로 사용하는 것으로 위 Bootstrap 5는 더이상 아래의 jQuery 를 필요로 하지 않는다. -->
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>


	<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/alertify.min.js"></script>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/alertify.min.css"/>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/themes/default.min.css"/>

</head>
<%
	String contextPath = request.getContextPath();
	UserDto userDto = (UserDto) session.getAttribute("userDto");
%>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <div class="container">
	    <a class="navbar-brand" href="#"><img src="<%= contextPath + userDto.getUserProfileImageUrl() %>" style="width:24px; height:24px; border-radius:50%;"></a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
	      <div class="navbar-nav">
	        <a class="nav-link" aria-current="page" href="<%= contextPath%>/board/boardMain">게시판</a>
	        <a class="nav-link" href="#">Features</a>
	        <a class="nav-link" href="#">Pricing</a>
	      </div>
	    </div>
	  </div>
	</nav>

	<div class="container mt-3">
	
		<h4 class="text-center">게시판 - Main</h4>
		
		<div class="input-group mb-3">
		  <input type="text" class="form-control" placeholder="Search" aria-label="Search" aria-describedby="button-addon2">
		  <button class="btn btn-outline-success" type="button" id="button-addon2">Search</button>
		</div>
		
		<table class="table table-hover">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">제목</th>
		      <th scope="col">작성자</th>
		      <th scope="col">작성일시</th>
		      <th scope="col">조회수</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <th scope="row">1</th>
		      <td>Mark</td>
		      <td>Otto</td>
		      <td>@mdo</td>
		      <td>@mdo</td>
		    </tr>
		    <tr>
		      <th scope="row">1</th>
		      <td>Mark</td>
		      <td>Otto</td>
		      <td>@mdo</td>
		      <td>@mdo</td>
		    </tr>
		    <tr>
		      <th scope="row">1</th>
		      <td>Mark</td>
		      <td>Otto</td>
		      <td>@mdo</td>
		      <td>@mdo</td>
		    </tr>
		    <tr>
		      <th scope="row">1</th>
		      <td>Mark</td>
		      <td>Otto</td>
		      <td>@mdo</td>
		      <td>@mdo</td>
		    </tr>
		    <tr>
		      <th scope="row">1</th>
		      <td>Mark</td>
		      <td>Otto</td>
		      <td>@mdo</td>
		      <td>@mdo</td>
		    </tr>
		  </tbody>
		</table>
		
		<nav aria-label="...">
		  <ul class="pagination">
		    <li class="page-item disabled">
		      <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
		    </li>
		    <li class="page-item"><a class="page-link" href="#">1</a></li>
		    <li class="page-item active" aria-current="page">
		      <a class="page-link" href="#">2</a>
		    </li>
		    <li class="page-item"><a class="page-link" href="#">3</a></li>
		    <li class="page-item">
		      <a class="page-link" href="#">Next</a>
		    </li>
		  </ul>
		</nav>
		
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">글쓰기</button>
		
		<!-- modal start -->
		<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label">Email address</label>
		  <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
		</div>
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
		  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
		<!-- modal end -->
	</div>

	
	
	<script>
		$(document).ready(function(){
			
			boardList();
		});
		
		function boardList(){
			$.ajax({
				type: 'get',
				url:'',
				dataType: 'json',
				data: {
					
				},
				success: function( data, status, xhr ){
					// data <= json response 가 parse 되어서 javascript 객체로 변환 
				},
				error: function( jqXHR, textStatus, errorThrown ){
					
				}
			});
		}
	</script>
</body>
</html>











