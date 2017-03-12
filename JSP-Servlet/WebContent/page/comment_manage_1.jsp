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
<script src='http://code.jquery.com/jquery-1.10.2.js'></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/navbarBtn.js"></script>
<style>
.c-watch{
	font-size:20px;
	color:  #00008B;
	cursor:pointer;
	text-decoration: none;
}
</style>
<script>
$(function(){
	if($("#nav-group").hasClass('active')===true){
		$("#nav-group").removeClass('active');
	}else if($("#nav-invite").hasClass('active')===true){
		$("#nav-invite").removeClass('active');
	}else if($("#nav-share").hasClass('active')===true){
		$("#nav-share").removeClass('active');
	}
	$("#nav-comment").addClass('active');
})
</script>
</head>
<body>
	<c:choose>
		<c:when test="${requestScope.memberId ne null}">
			<c:import url="navbar.jsp">
				<c:param name="memberId" value="${requestScope.memberId}"/>
				<c:param name="memberName" value="${requestScope.memberName}"/>
			</c:import>
		</c:when>
		<c:otherwise>
			<c:import url="navbar.jsp">
				<c:param name="memberId" value="${sessionScope.memberId}"/>
				<c:param name="memberName" value="${sessionScope.memberName}"/>
			</c:import>
		</c:otherwise>
	</c:choose>
		
	<h3>댓글 관리</h3><br/>
	<div class="wrapper">
		<div class="share-list">
				<table class="table table-hover">
				<thead>
					<tr>
						<th>host id</th>
						<th>host name</th>
						<th>share date</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.shareList}" var="shareInfo">
						<tr>
							<td class="host-id">${shareInfo.hostId}</td>
							<td class="host-name">${shareInfo.hostName}</td>
							<td class="share-date">${shareInfo.shareDate}</td>
							<td><a href="watch_comment.do?fileCode=${shareInfo.fileInfo.fileCode}" class="c-watch">댓글 보기</a></td>
						</tr>
					</c:forEach>
				</tbody>
				</table>
		</div>
		
	</div>
</body>
</html>