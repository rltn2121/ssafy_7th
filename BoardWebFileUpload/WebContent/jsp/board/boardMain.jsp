<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import = "board.dto.*, java.util.*" %>
<%
	String contextPath = request.getContextPath();
	UserDto userDto = (UserDto) session.getAttribute("userDto");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>Board</title>
	<!-- Bootstrap 5 버전 -->
	<!-- https://getbootstrap.com/docs/5.0/getting-started/introduction/ -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
	
	<!-- jQuery 는  이번이 마지막. FileUpload 부터는 fetch 사용. Bootstrap 5는 더이상 아래의 jQuery 를 필요로 하지 않는다. -->
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

	<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/alertify.min.js"></script>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/alertify.min.css"/>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/themes/default.min.css"/>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><img src="<%= contextPath + userDto.getUserProfileImageUrl() %>" alt="Logo" style="width:24px; height: 24px; border-radius: 50%;"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="<%= contextPath%>/board/boardMain">게시판</a>
        </li>
        <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      </ul>
    </div>
  </div>
</nav>



<div class="container">

  <h4 class="text-center">게시판 - Main</h4>       
  
	<div class="input-group mb-3">
	  <input id="inputSearchWord" type="text" class="form-control" placeholder="Search">
	  <button id="btnSearchWord" class="btn btn-success" type="button">Search</button>
	</div>

	<table class="table table-hover">
		<thead>
       		<tr>
				<th>#</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일시</th>
				<th>조회수</th>
			</tr>
     	</thead>
     	<tbody id="boardTbody">
     	</tbody>
   	</table>
   
	<div id="paginationWrapper"></div>

	<button class="btn btn-sm btn-primary" id="btnInsertPage">글쓰기</button>
</div>

<!-- modal begin ------------------------------------------------------------------------->

<!-- Modal insert-->
<div class="modal" tabindex="-1" id="boardInsertModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">글 쓰기</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">

		<div class="mb-3">
		  <label for="titleInsert" class="form-label">제목</label>
		  <input type="text" class="form-control" id="titleInsert">
		</div>
		<div class="mb-3">
		  <label for="contentInsert" class="form-label">내용</label>
		  <textarea class="form-control" id="contentInsert" rows="5"></textarea>  
		</div>
		<button id="btnBoardInsert" class="btn btn-sm btn-primary btn-outline float-end" data-bs-dismiss="modal" type="button">등록</button>

      </div>      
    </div>
  </div>
</div>
<!-- End Modal -->
				
<!-- Modal detail-->
<div class="modal" tabindex="-1" id="boardDetailModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">글 상세</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">

        <table class="table table-hover">
          <tbody>
            <tr><td>글번호</td><td id="boardIdDetail">#</td></tr>
            <tr><td>제목</td><td id="titleDetail">#</td></tr>
            <tr><td>내용</td><td id="contentDetail">#</td></tr>
            <tr><td>작성자</td><td id="userNameDetail">#</td></tr>
            <tr><td>작성일시</td><td id="regDtDetail">#</td></tr>
            <tr><td>조회수</td><td id="readCountDetail">#</td></tr>
          </tbody>
        </table>
		<button id="btnBoardUpdateForm" class="btn btn-sm btn-primary btn-outline" data-bs-dismiss="modal" type="button">글 수정하기</button>
		<button id="btnBoardDeleteConfirm" class="btn btn-sm btn-warning btn-outline" data-bs-dismiss="modal" type="button">글 삭제하기</button>

      </div>      
    </div>
  </div>
</div>
<!-- End Modal -->

<!-- Modal update-->
<div class="modal" tabindex="-1" id="boardUpdateModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">글 수정</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">

		<div class="mb-3">
		  <label for="titleUpdate" class="form-label">제목</label>
		  <input type="text" class="form-control" id="titleUpdate">
		</div>
		<div class="mb-3">
		  <label for="contentUpdate" class="form-label">내용</label>
		  <textarea class="form-control" id="contentUpdate" rows="5"></textarea>  
		</div>
		<button id="btnBoardUpdate" class="btn btn-sm btn-primary btn-outline float-end" data-bs-dismiss="modal" type="button">수정</button>

      </div>      
    </div>
  </div>
</div>
<!-- End Modal -->				

<!-- modal end --------------------------------------------------------------------------->

<!-- form begin -------------------------------------------------------------------------->

<!-- form end ---------------------------------------------------------------------------->

<script src="<%=contextPath%>/js/util.js"></script>		
<script>

var LIST_ROW_COUNT = 10;	//limit
var OFFSET = 0;   // limit 10 offet 10
var SEARCH_WORD = "";

$(document).ready(function(){
	
	boardList();
	
	$("#btnSearchWord").click(function(){

		SEARCH_WORD = $("#inputSearchWord").val();
		// 처음 페이지로 초기화
		OFFSET = 0;
		CURRENT_PAGE_INDEX = 1;
		
		boardList();
		
	});

	
	// insert Page
	$("#btnInsertPage").click(function(){
		
		$("#titleInsert").val("");
		$("#contentInsert").val("");
		
		$("#boardInsertModal").modal("show");
	});
	
	// insert
	$("#btnBoardInsert").click(function(){
		
		if( validateInsert() ){
			boardInsert();
		}
	});
	
	// update
	$("#btnBoardUpdateForm").click(function(){
		
		var boardId = $("#boardDetailModal").attr("data-boardId");
		$("#boardUpdateModal").attr("data-boardId", boardId);
		
		$("#titleUpdate").val( $("#titleDetail").html() );
		$("#contentUpdate").val( $("#contentDetail").html() );
		
		$("#boardDetailModal").modal("hide");
		$("#boardUpdateModal").modal("show");
	});
	
	$("#btnBoardUpdate").click(function(){
		console.log(1)
		if( validateUpdate() ){
			boardUpdate();
		}
	});
	
	// delete
	$("#btnBoardDeleteConfirm").click(function(){
		 alertify.confirm('삭제 확인', '이 글을 삭제하시겠습니까?',
 			function() {
				boardDelete();
 			},
			function(){
 				console.l og('cancel');
			}
		);
	});
});

/// stringify(obj) parse(json)
function boardList(){
	let url = '<%= contextPath %>/board/boardList';
	let urlParams = '?limit=' + LIST_ROW_COUNT + '&offset=' + OFFSET + "&searchWord=" + SEARCH_WORD;
	$.ajax(
	{
        type : 'get',
        url : '<%=contextPath%>/board/boardList',
        dataType : 'json',
        data : 
		{
        	limit: LIST_ROW_COUNT,
			offset: OFFSET,
			searchWord: SEARCH_WORD
		},
        success : function(data, status, xhr) { 
        	makeListHtml(data);
        }, 
        error: function(jqXHR, textStatus, errorThrown) 
        { 
        	alertify.error(' 글 조회 과정에 문제가 생겼습니다.');
			console.log(jqXHR);
        }
    });
}

function makeListHtml(list){

	$("#boardTbody").html("");

	for( var i=0; i<list.length; i++){
	
		var boardId = list[i].boardId;
		var userName = list[i].userName;
		var title = list[i].title;
		var content = list[i].content;
		var regDt = list[i].regDt;	// javascript of parsed from LocalDateTime
		
		var regDtStr = makeDateStr(regDt.date.year, regDt.date.month, regDt.date.day, '.');
		
		var readCount = list[i].readCount;
		
		var listHtml =
			'<tr style="cursor:pointer" data-boardId=' + boardId +'><td>' + boardId + '</td><td>' + title + '</td><td>' + userName + '</td><td>' + regDtStr + '</td><td>' + readCount + '</td></tr>';

		$("#boardTbody").append(listHtml);
	}
	
	makeListHtmlEventHandler();
	
	boardListTotalCnt();
}

function makeListHtmlEventHandler(){
	$("#boardTbody tr").click(function(){
		var boardId = $(this).attr("data-boardId");
		var userSeq = '<%=userDto.getUserSeq()%>';
		boardDetail(boardId, userSeq);
	});
}

var PAGE_LINK_COUNT = 5;	// pagination link 갯수
var TOTAL_LIST_ITEM_COUNT = 0;
var CURRENT_PAGE_INDEX = 1;

function boardListTotalCnt(){
	
	$.ajax(
	{
        type : 'get',
        url : '<%=contextPath%>/board/boardListTotalCnt',
        dataType : 'json',
        data : 
		{
			searchWord: SEARCH_WORD
		},
        success : function(data, status, xhr) {
        	TOTAL_LIST_ITEM_COUNT = data.totalCnt;
        	addPagination();
        }, 
        error: function(jqXHR, textStatus, errorThrown) 
        { 
        	alertify.error(' 글 전체 수 조회 과정에 문제가 생겼습니다.');
			console.log(jqXHR);
        }
    });
}

function addPagination(){

	makePaginationHtml(LIST_ROW_COUNT, PAGE_LINK_COUNT, CURRENT_PAGE_INDEX, TOTAL_LIST_ITEM_COUNT, "paginationWrapper" );
}

function movePage(pageIndex){
	OFFSET = (pageIndex - 1) * LIST_ROW_COUNT;
	CURRENT_PAGE_INDEX = pageIndex;
	boardList();
}


// insert
function validateInsert(){
	var isTitleInsertValid = false;
	var isContentInsertValid = false;

	var titleInsert = $("#titleInsert").val();
	var titleInsertLength = titleInsert.length;
	
	if( titleInsertLength > 0 ){
		isTitleInsertValid = true;
	}
	
	var contentInsertValue = $("#contentInsert").val();
	var contentInsertLength = contentInsertValue.length;
	
	if( contentInsertLength > 0 ){
		isContentInsertValid = true;
	}

	if(	isTitleInsertValid && isContentInsertValid ){
		return true;
	}else{
		return false;
	}
}

function boardInsert(){

	$.ajax(
	{
        type : 'post',
        url : '<%= contextPath%>/board/boardInsert',
        dataType : 'json',
        data : 
		{
        	//userSeq: '<%=userDto.getUserSeq()%>',
        	title: $("#titleInsert").val(),
        	content: $("#contentInsert").val()
		},
        success : function(data, status, xhr) { 
		
        	if(data.result == "success"){
        		alertify.success('글이 등록되었습니다.');
        		boardList();
        	}
        }, 
        error: function(jqXHR, textStatus, errorThrown) 
        { 
        	alertify.error(' 글 등록 과정에 문제가 생겼습니다.');
			console.log(jqXHR);
        	
        }
    });
}

// detail
function boardDetail(boardId){

	$.ajax(
	{
        type : 'get',
        url : '<%= contextPath%>/board/boardDetail',
        dataType : 'json',
        data : 
		{
        	boardId: boardId
		},
        success : function(data, status, xhr) { 

        	makeDetailHtml(data);
        }, 
        error: function(jqXHR, textStatus, errorThrown) 
        {
    		alertify.error(' 글 상세 조회 과정에 문제가 생겼습니다.');
			console.log(jqXHR);
        }
    });
}

function makeDetailHtml(detail){
	console.log(detail);
	var boardId = detail.boardId;
	var userSeq = detail.userSeq;
	var userName = detail.userName;
	var title = detail.title;
	var content = detail.content;
	var regDt = detail.regDt;

	var regDtStr = makeDateStr(regDt.date.year, regDt.date.month, regDt.date.day, '.') + ' ' + makeTimeStr(regDt.time.hour, regDt.time.minute, regDt.time.second, ':');
	
	var readCount = detail.readCount;
	var sameUser = detail.sameUser;

	$("#boardDetailModal").attr("data-boardId", boardId);
	$("#boardIdDetail").html("#" + boardId);
	$("#titleDetail").html(title);
	$("#contentDetail").html(content);
	$("#userNameDetail").html(userName);
	$("#regDtDetail").html(regDtStr);
	$("#readCountDetail").html(readCount);
	
	if( !sameUser ){
		$("#btnBoardUpdateForm").hide();
		$("#btnBoardDeleteConfirm").hide();
	}else{
		$("#btnBoardUpdateForm").show();
		$("#btnBoardDeleteConfirm").show();
	}
	
	$("#boardDetailModal").modal("show");
}

// update
function validateUpdate(){
	var isTitleUpdateValid = false;
	var isContentUpdateValid = false;

	var titleUpdate = $("#titleUpdate").val();
	var titleUpdateLength = titleUpdate.length;
	
	if( titleUpdateLength > 0 ){
		isTitleUpdateValid = true;
	}
	
	var contentUpdateValue = $("#contentUpdate").val();
	var contentUpdateLength = contentUpdateValue.length;
	
	if( contentUpdateLength > 0 ){
		isContentUpdateValid = true;
	}

	if(	isTitleUpdateValid && isContentUpdateValid ){
		return true;
	}else{
		return false;
	}
}

function boardUpdate(){

	$.ajax(
	{
        type : 'post',
        url : '<%= contextPath%>/board/boardUpdate',
        dataType : 'json',
        data : 
		{
        	boardId: $("#boardUpdateModal").attr("data-boardId"),
        	title: $("#titleUpdate").val(),
        	content: $("#contentUpdate").val()
		},
        success : function(data, status, xhr) { 
		
        	if(data.result == "success"){
        		alertify.success('글이 수정되었습니다.');
        		boardList();
        	}
        }, 
        error: function(jqXHR, textStatus, errorThrown) 
        {
        	alertify.error(' 글 수정 과정에 문제가 생겼습니다.');
			console.log(jqXHR);
        }
    });
}

// delete
function boardDelete(){
	$.ajax(
	{
        type : 'post',
        url : '<%= contextPath%>/board/boardDelete',
        dataType : 'json',
        data : 
		{
        	boardId: $("#boardDetailModal").attr("data-boardId")
		},
        success : function(data, status, xhr) { 
		
        	if(data.result == "success"){
        		alertify.success('글이 삭제되었습니다.');
        		boardList();
        	}
        }, 
        error: function(jqXHR, textStatus, errorThrown) 
        {
        	alertify.error(' 글 삭제 과정에 문제가 생겼습니다.');
			console.log(jqXHR);
        }
    });
}
</script>

</body>
</html>