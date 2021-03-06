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
	
	<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/alertify.min.js"></script>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/alertify.min.css"/>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/themes/default.min.css"/>
	
	<!-- New for FileUpload, CKEditor -->
	<link rel="stylesheet" href="<%= contextPath %>/css/common.css">
	<script src="https://cdn.ckeditor.com/ckeditor5/19.0.0/classic/ckeditor.js"></script>
	<!-- / New for FileUpload, CKEditor -->	
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
		  <!-- New for FileUpload, CKEditor -->
		  <div id="divEditorInsert"></div>  
		</div>
		
		<div class="mb-3">
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="chkFileUploadInsert">
			  <label class="form-check-label" for="chkFileUploadInsert">파일 추가</label>
			</div>
		</div>
		
		<div class="mb-3" style="display:none;" id="imgFileUploadInsertWrapper">
			<input type="file" id="inputFileUploadInsert" multiple>
			<div id="imgFileUploadInsertThumbnail" class="thumbnail-wrapper"></div>
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
            
            <tr><td colspan="2">첨부파일</td></tr>
            <tr><td colspan="2" id="fileListDetail"></tr>
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
		  <!-- New for FileUpload, CKEditor -->
		  <div id="divEditorUpdate"></div>  
		</div>
		<!-- 현재 첨부된 파일 정보 -->
		<div class="mb-3">
			첨부파일 : <span id="fileListUpdate"></span>
		</div>
		<!-- 새롭게 파일을 추가하는 UI -->
		<div class="mb-3">
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="chkFileUploadUpdate">
			  <label class="form-check-label" for="chkFileUploadUpdate">파일 변경</label>
			</div>
		</div>
		
		<div class="mb-3" style="display:none;" id="imgFileUploadUpdateWrapper">
			<input type="file" id="inputFileUploadUpdate" multiple>
			<div id="imgFileUploadUpdateThumbnail" class="thumbnail-wrapper"></div>
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

var PAGE_LINK_COUNT = 10;	// pagination link 갯수
var TOTAL_LIST_ITEM_COUNT = 0;
var CURRENT_PAGE_INDEX = 1;

<!-- New for FileUpload, CKEditor -->
var CKEditorInsert;
var CKEditorUpdate;


window.onload = function(){
	
	<!-- New for FileUpload, CKEditor -->
	initCKEditor();
	
	boardList();
	
	document.querySelector("#btnSearchWord").onclick = function(){

		SEARCH_WORD = document.querySelector("#inputSearchWord").value;
		// 처음 페이지로 초기화
		OFFSET = 0;
		CURRENT_PAGE_INDEX = 1;
		
		boardList();
		
	}

	// New for FileUpload, CKEditor
	// insert Page
	document.querySelector("#btnInsertPage").onclick = function(){
		document.querySelector("#titleInsert").value = "";
		CKEditorInsert.setData("");
		
		document.querySelector("#chkFileUploadInsert").checked = false;
		document.querySelector("#inputFileUploadInsert").value = "";
		document.querySelector("#imgFileUploadInsertThumbnail").innerHTML = "";
		document.querySelector("#imgFileUploadInsertWrapper").style.display = "none";
		
		let modal = new bootstrap.Modal(
			document.querySelector("#boardInsertModal")
		);
		
		modal.show();
	}

	// insert
	document.querySelector("#btnBoardInsert").onclick = function(){
		
		if( validateInsert() ){
			boardInsert();
		}
	}

	document.querySelector("#chkFileUploadInsert").onchange = function(){
		if( this.checked ){
			document.querySelector("#imgFileUploadInsertWrapper").style.display = "block";
		}else{
			document.querySelector("#inputFileUploadInsert").value = "";
			document.querySelector("#imgFileUploadInsertThumbnail").innerHTML = "";
			document.querySelector("#imgFileUploadInsertWrapper").style.display = "none";
		}
	}
	
	document.querySelector("#inputFileUploadInsert").onchange = function(e){
		const fileArray = Array.from(this.files);
		fileArray.forEach( file => {
			let reader = new FileReader();
			reader.readAsDataURL(file);
			reader.onload = function(e){
				let thumbnailHTML = `<img src="\${e.target.result}">`;
				document.querySelector("#imgFileUploadInsertThumbnail").insertAdjacentHTML("beforeend", thumbnailHTML);
			}
		});
	}


	// update
	document.querySelector("#btnBoardUpdateForm").onclick = function(){
		
		var boardId = document.querySelector("#boardDetailModal").getAttribute("data-boardId");
		document.querySelector("#boardUpdateModal").setAttribute("data-boardId", boardId);
		
		document.querySelector("#titleUpdate").value = document.querySelector("#titleDetail").innerHTML;
		// CKEditor
		CKEditorUpdate.setData( document.querySelector("#contentDetail").innerHTML )
		// FileUpload
		let fileListHTML = ``;
		document.querySelectorAll("#fileListDetail .fileName").forEach( el => {
			fileListHTML += `<div class="fileName">\${el.innerHTML}</div>`;
		})
		document.querySelector("#fileListUpdate").innerHTML = fileListHTML;
		
		document.querySelector("#chkFileUploadUpdate").checked = false;
		document.querySelector("#inputFileUploadUpdate").value = "";
		document.querySelector("#imgFileUploadUpdateThumbnail").innerHTML = "";
		document.querySelector("#imgFileUploadUpdateWrapper").style.display = "none";
		
		let detailModal = new bootstrap.Modal( document.querySelector("#boardDetailModal") );
		detailModal.hide();
		let updatelModal = new bootstrap.Modal( document.querySelector("#boardUpdateModal") );
		updatelModal.show();
	};
	
	document.querySelector("#btnBoardUpdate").onclick = function(){
		console.log(1)
		if( validateUpdate() ){
			boardUpdate();
		}
	};
	
	document.querySelector("#chkFileUploadUpdate").onchange = function(){
		if( this.checked ){
			document.querySelector("#imgFileUploadUpdateWrapper").style.display = "block";
		}else{
			document.querySelector("#inputFileUploadUpdate").value = "";
			document.querySelector("#imgFileUploadUpdateThumbnail").innerHTML = "";
			document.querySelector("#imgFileUploadUpdateWrapper").style.display = "none";
		}
	}
	
	document.querySelector("#inputFileUploadUpdate").onchange = function(e){
		const fileArray = Array.from(this.files);
		fileArray.forEach( file => {
			let reader = new FileReader();
			reader.readAsDataURL(file);
			reader.onload = function(e){
				let thumbnailHTML = `<img src="\${e.target.result}">`;
				document.querySelector("#imgFileUploadUpdateThumbnail").insertAdjacentHTML("beforeend", thumbnailHTML);
			}
		});
	}
	
	// delete
	document.querySelector("#btnBoardDeleteConfirm").onclick = function(){
		 alertify.confirm('삭제 확인', '이 글을 삭제하시겠습니까?',
 			function() {
				boardDelete();
 			},
			function(){
 				console.log('cancel');
			}
		);
	};
}

// New for FileUpload, CKEditor
async function initCKEditor(){
	try{
        CKEditorInsert = await ClassicEditor.create( document.querySelector( '#divEditorInsert' ) );
        CKEditorUpdate = await ClassicEditor.create( document.querySelector( '#divEditorUpdate' ) );
      }catch(error){
        console.error(error);
      }	
}

/// stringify(obj) parse(json)
async function boardList(){
	let url = '<%=contextPath%>/board/boardList';
	let urlParams = '?limit=' + LIST_ROW_COUNT + '&offset=' + OFFSET + "&searchWord=" + SEARCH_WORD;
	
	let fetchOptions = {
		method: 'GET',
		headers: {
			'async': 'true' // 비동기 요청을 위한 약속 mark
		}
	}
	
	try{
		let response = await fetch(url + urlParams, fetchOptions);
		let data = await response.json();
		if( data.result == "login" ){ // 백엔드 로그인 필터에서 session timeout 이 발생하면 내려주는 json 값
			window.location.href = "<%=contextPath%>/login"; // 비동기 요청 X
		}else{
			makeListHtml(data);
		}
		
	}catch(error){
		console.log(error);
		alertify.error('글 조회 과정에 문제가 생겼습니다.');
	}

}

function makeListHtml(list){

	console.log(list);
	
	//$("#boardTbody").html("");
	let listHTML = ``;

	list.forEach( el => {
		let boardId = el.boardId;
		let userName = el.userName;
		let title = el.title;
		let content = el.content;
		let regDt = el.regDt;	// javascript of parsed from LocalDateTime
		console.log(regDt);
		let regDtStr = makeDateStr(regDt.date.year, regDt.date.month, regDt.date.day, '.');
		
		let readCount = el.readCount;		
		
		listHTML +=
			`<tr style="cursor:pointer" data-boardId=\${boardId}><td>\${boardId}</td><td>\${title}</td><td>\${userName}</td>
				<td>\${regDtStr}</td><td>\${readCount}</td></tr>`;
		
	} );
	
	document.querySelector("#boardTbody").innerHTML = listHTML;
	
	
	makeListHtmlEventHandler();
	
	boardListTotalCnt();
}

function makeListHtmlEventHandler(){
	document.querySelectorAll("#boardTbody tr").forEach( el => {
		el.onclick = function(){
			var boardId = this.getAttribute("data-boardId");	
			boardDetail(boardId);
		}
	});
}

async function boardListTotalCnt(){
	let url = '<%=contextPath%>/board/boardListTotalCnt';
	let urlParams = '?searchWord=' + SEARCH_WORD;
	
	let fetchOptions = {
		method: 'GET',
		headers: {
			'async': 'true' // 비동기 요청을 위한 약속 mark
		}
	}
	
	try{
		let response = await fetch(url + urlParams, fetchOptions);
		let data = await response.json();
		if( data.result == "login" ){ // 백엔드 로그인 필터에서 session timeout 이 발생하면 내려주는 json 값
			window.location.href = "<%=contextPath%>/login"; // 비동기 요청 X
		}else{
			TOTAL_LIST_ITEM_COUNT = data.totalCnt;
        	addPagination();
		}
		
	}catch(error){
		console.log(error);
		alertify.error('글 전체 수 조회 과정에 문제가 생겼습니다.');
	}
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

	var titleInsert = document.querySelector("#titleInsert").value;
	var titleInsertLength = titleInsert.length;
	
	if( titleInsertLength > 0 ){
		isTitleInsertValid = true;
	}
	
	var contentInsertValue = CKEditorInsert.getData();
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

async function boardInsert(){

	var formData = new FormData();
	formData.append("title", document.querySelector("#titleInsert").value);
	formData.append("content", CKEditorInsert.getData());
	
	var files = document.querySelector("#inputFileUploadInsert").files;
	const fileArray = Array.from(files);
	fileArray.forEach( file => formData.append("file", file));
	
	var url = '<%= contextPath%>/board/boardInsert';
	var fetchOptions = {
		method: 'POST',
		headers: {
			'async': 'true'
		},
		body: formData
	}
	
	try{
		let response = await fetch(url, fetchOptions );
		let data = await response.json();
		if( data.result == "login" ){ // 백엔드 로그인 필터에서 session timeout 이 발생하면 내려주는 json 값
			window.location.href = "<%=contextPath%>/login"; // 비동기 요청 X
		}else{
			alertify.success('글이 등록되었습니다.');
			boardList();
		}
	}catch( error ){
		console.error( error );
		alertify.error('글 등록 과젱에 문제가 있습니다.')
	}
}

// detail
async function boardDetail(boardId){

	var url = '<%= contextPath%>/board/boardDetail';
	var urlParams = '?boardId=' + boardId;
	
	let fetchOptions = {
		method: 'GET',
		headers: {
			'async': 'true'
		}
	}
	
	try{
		let response = await fetch(url + urlParams, fetchOptions);
		let data = await response.json();
		
		if( data.result == "login" ){ // 백엔드 로그인 필터에서 session timeout 이 발생하면 내려주는 json 값
			window.location.href = "<%=contextPath%>/login"; // 비동기 요청 X
		}else{
			console.log(data);
			makeDetailHtml(data);
		}
	}catch( error ){
		console.error( error );
		alertify.error("글 조회과정에 문제가 생겼습니다.");
	}
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
	var fileList = detail.fileList;
	
	document.querySelector("#boardDetailModal").setAttribute("data-boardId", boardId);
	document.querySelector("#boardIdDetail").innerHTML = "#" + boardId;
	document.querySelector("#titleDetail").innerHTML = title;
	document.querySelector("#contentDetail").innerHTML = content;
	document.querySelector("#userNameDetail").innerHTML = userName;
	document.querySelector("#regDtDetail").innerHTML = regDtStr;
	document.querySelector("#readCountDetail").innerHTML = readCount;
	
	// FileList
	var fileListDetailHtml = ``;
	if( fileList.length > 0 ){
		for (var i = 0; i < fileList.length; i++) {
			let fileId = fileList[i].fileId;
			let fileName = fileList[i].fileName;
			let fileUrl = fileList[i].fileUrl;
			
			fileListDetailHtml +=
				`
				<div>
					<span class="fileName">\${fileName}</span>
					&nbsp;&nbsp;
					<a type="button" class="btn btn-outline btn-default btn-xs" data-fileId="\${fileId}" href="<%=contextPath%>/\${fileUrl}" download="\${fileName}">내려받기</a>	
				</div>
				`;				
		}
		
		document.querySelector("#fileListDetail").innerHTML = fileListDetailHtml;
	}
	
	if( sameUser ){
		document.querySelector("#btnBoardUpdateForm").style.display = "inline-block";
		document.querySelector("#btnBoardDeleteConfirm").style.display = "inline-block";
	}else{
		document.querySelector("#btnBoardUpdateForm").style.display = "none";
		document.querySelector("#btnBoardDeleteConfirm").style.display = "none";
	}
	
	let modal = new bootstrap.Modal(document.querySelector("#boardDetailModal"));
	modal.show();
}

// update
function validateUpdate(){
	var isTitleUpdateValid = false;
	var isContentUpdateValid = false;

	var titleUpdate = document.querySelector("#titleUpdate").value;
	var titleUpdateLength = titleUpdate.length;
	
	if( titleUpdateLength > 0 ){
		isTitleUpdateValid = true;
	}
	
	var contentUpdateValue = CKEditorUpdate.getData();
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

async function boardUpdate(){
	
	var boardId = document.querySelector("#boardUpdateModal").getAttribute("data-boardId");
	var formData = new FormData();
	formData.append("boardId", boardId);
	formData.append("title", document.querySelector("#titleUpdate").value);
	formData.append("content", CKEditorUpdate.getData());
	
	var files = document.querySelector("#inputFileUploadUpdate").files;
	const fileArray = Array.from(files);
	fileArray.forEach( file => formData.append("file", file));
	
	var url = '<%= contextPath%>/board/boardUpdate';
	var fetchOptions = {
		method: 'POST',
		headers: {
			'async': 'true'
		},
		body: formData
	}
	
	try{
		let response = await fetch(url, fetchOptions );
		let data = await response.json();
		if( data.result == "login" ){ // 백엔드 로그인 필터에서 session timeout 이 발생하면 내려주는 json 값
			window.location.href = "<%=contextPath%>/login"; // 비동기 요청 X
		}else{
			alertify.success('글이 수정되었습니다.');
			boardList();
		}
	}catch( error ){
		console.error( error );
		alertify.error('글 수정 과젱에 문제가 있습니다.')
	}
}

// delete
async function boardDelete(){
	
	var url = '<%= contextPath%>/board/boardDelete';
	var urlParams = '?boardId=' + document.querySelector("#boardDetailModal").getAttribute("data-boardId");
	
	let fetchOptions = {
		method: 'GET',
		headers: {
			'async': 'true'
		}
	}
	
	try{
		let response = await fetch(url + urlParams, fetchOptions);
		let data = await response.json();
		
		if( data.result == "login" ){ // 백엔드 로그인 필터에서 session timeout 이 발생하면 내려주는 json 값
			window.location.href = "<%=contextPath%>/login"; // 비동기 요청 X
		}else if(data.result == "success"){
			alertify.success("글이 삭제되었습니다.");
			boardList();
		}else{
			alertify.error("글 삭제 과정에 문제가 생겼습니다.");
		}
	}catch( error ){
		console.error( error );
		alertify.error("글 삭제 과정에 문제가 생겼습니다.");
	}	
}
</script>

</body>
</html>