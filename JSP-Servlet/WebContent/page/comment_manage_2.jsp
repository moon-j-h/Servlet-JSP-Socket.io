<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>comment management</title>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<link href="css/navbar.css" rel="stylesheet">
<link href="css/comment_manage.css" rel="stylesheet">
<link href="css/navbar-user-icon.css" rel="stylesheet">
<style>
.input-table{
	width:95%;
}
#slide-control-btn{
	float:right;
	padding-left:10px;
	margin-bottom:5px;
}
</style>
<script src='http://code.jquery.com/jquery-1.10.2.js'></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/navbarBtn.js"></script>
<script src="js/comment-manage-2.js"></script>
</head>
<body>
	<c:import url="navbar.jsp">
		<c:param name="memberId" value="${sessionScope.memberId}"/>
		<c:param name="memberName" value="${sessionScope.memberName}"/>
	</c:import>
	<h3>댓글 관리</h3>
	<div class="wrapper">
		<div id="page-view">
			<div id="slide-control-btn">
				<button type="button" id="mo-prev" class="btn btn-default" onclick="prevPage()"><span class="glyphicon glyphicon-chevron-left"></span>&nbsp;prev</button>
				<button type="button" id="mo-prev" class="btn btn-default" onclick="nextPage()"><span class="glyphicon glyphicon-chevron-right"></span>&nbsp;next</button>
 			</div>
 			<img src="" id="file-page" class="img-thumbnail"/>
		</div>
		<div class="comment-list">
			<br/><br/>
			<div class="list-group">
				<c:forEach items="${requestScope.commentInfoList.commentInfoList}" var="commentInfo">
					<c:if test="${commentInfo.parentCommentCode eq null}">
						<c:if test="${commentInfo.pageNum eq 1 }">
							<p class="list-group-item"><span class="name">${commentInfo.writerName}</span>&nbsp;(<span class="id">${commentInfo.writerId}</span>)&nbsp;&nbsp;<span class="write-date"> ${commentInfo.writeDate}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="recomment" id="${commentInfo.commentCode}" onclick="makeRecommentTextArea(${commentInfo.commentCode})">☞답글</span><br/>${commentInfo.commentContent}</p>
						</c:if>
					</c:if>
					<c:if test="${commentInfo.parentCommentCode ne null}">
						<!-- <p class="list-group-item">&nbsp;&nbsp;┗━&nbsp;<span class="name">${commentInfo.writerName}</span>&nbsp;(<span class="id">${commentInfo.writerId}</span>)&nbsp;&nbsp;<span class="write-date"> ${commentInfo.writeDate}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="recomment" id="${commentInfo.commentCode}" onclick="makeRecommentTextArea(${commentInfo.commentCode})">☞답글</span><br/>${commentInfo.commentContent}</p> -->
						<c:if test="${commentInfo.pageNum eq 1 }">
							<p class="list-group-item">&nbsp;&nbsp;┗━&nbsp;<span class="name">${commentInfo.writerName}</span>&nbsp;(<span class="id">${commentInfo.writerId}</span>)&nbsp;&nbsp;<span class="write-date"> ${commentInfo.writeDate}</span><br/>${commentInfo.commentContent}</p>
						</c:if>
					</c:if>
					<c:if test="${commentInfo eq null}">
						<p class="list-group-item">작성된 댓글이 없습니다.</p>
					</c:if>
				</c:forEach>
				<!-- <div class="list-group-item"><table class="input-table"><tr><td colspan="3"><textArea class="form-control recomment-write" rows="2"></textArea></td><td><button type="button" class="btn btn-default recomment-input">Ok</button></td></tr></table></div> -->
			</div>
		</div>
	</div>
	<input type="hidden" id="path" value="${requestScope.filePath}"/>
	<input type="hidden" id="maxPageNum" value="${requestScope.maxPageNum}"/>
</body>
</html>