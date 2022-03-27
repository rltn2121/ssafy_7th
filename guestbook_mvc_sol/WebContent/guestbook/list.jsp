<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<c:if test="${empty userinfo}">
	<script type="text/javascript">
		alert("로그인 후 이용 가능한 페이지입니다.");
		location.href = "${root}/user?act=mvlogin";
	</script>
</c:if>
<c:if test="${!empty userinfo}">

    <style>
        mark.sky {
            background: linear-gradient(to top, #54fff9 20%, transparent 30%);
        }
    </style>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#mvRegisterBtn").click(function () {
                location.href = "${root}/guestbook?act=mvregister";
            });
        });
    </script>

    <div class="container text-center mt-3">
        <div class="col-lg-8 mx-auto">
        	<%@ include file="/include/confirm.jsp" %>
            <h2 class="p-3 mb-3 shadow bg-light"><mark class="sky">글목록</mark></h2>
            <div class="m-3 text-right">
                <button type="button" id="mvRegisterBtn" class="btn btn-link">글작성</button>
            </div>
	<c:if test="${!empty articles}">
		<c:forEach var="article" items="${articles}">
			<table class="table table-active text-left">
				<tbody>
					<tr class="table-info">
						<td>작성자 : ${article.userName}</td>
						<td class="text-right">작성일 : ${article.regTime}</td>
					</tr>
					<tr>
						<td colspan="2" class="table-danger">
							<strong>${article.articleNo}. ${article.subject}</strong>
						</td>
					</tr>
					<tr>
						<td class="p-4" colspan="2">
							${article.content}
						</td>
					</tr>
				</tbody>
			</table>
		</c:forEach>
	</c:if>
	<c:if test="${empty articles}">
			<table class="table table-active text-center">
				<tr class="table-info">
					<td>작성한 글이 없습니다.</td>
				</tr>
			</table>
	</c:if>
		</div>
    </div>

<%@ include file="/include/footer.jsp" %>
</c:if>