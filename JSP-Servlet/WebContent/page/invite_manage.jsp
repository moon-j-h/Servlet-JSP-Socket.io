<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>invite management</title>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<link href="css/navbar.css" rel="stylesheet">
<link href="css/invite_manage.css" rel="stylesheet">
<link href="css/navbar-user-icon.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/navbarBtn.js"></script>
<script>
$(function(){
	if($("#nav-group").hasClass('active')===true){
		$("#nav-group").removeClass('active');
	}else if($("#nav-comment").hasClass('active')===true){
		$("#nav-comment").removeClass('active');
	}else if($("#nav-share").hasClass('active')===true){
		$("#nav-share").removeClass('active');
	}
	$("#nav-invite").addClass('active');
})
</script>
</head>
<body>
	<c:import url="navbar.jsp">
		<c:param name="memberId" value="${sessionScope.memberId}"/>
		<c:param name="memberName" value="${sessionScope.memberName}"/>
	</c:import>
	<h3>초대 관리</h3><br/>
	<div class="wrapper">
		<div class="invite-list">
			<table class="table table-hover">
			<thead>
				<tr>
					<th>host id</th>
					<th>host name</th>
					<th>invite date</th>
					<th>accept</th>
					<th>refuse</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${requestScope.inviteList}" var="invite">
				<tr>
					<td>${invite.inviteSenderId}</td>
					<td>${invite.inviteSenderName}</td>
					<td>${invite.inviteDate }</td>
					<td><form action="accept_invite.do" method="post">
						<input type="hidden" name="inviteCode" value="${invite.inviteCode}"/>
						<input type="submit" value="accept" class="btn-default btn" id="group-member-add"/> 
						</form>
					</td>
					<td><form action="refuse_invite.do" method="post">
						<input type="hidden" name="inviteCode" value="${invite.inviteCode}"/>
						<input type="submit" value="refuse" class="btn-default btn" id="group-member-add"/> 
						</form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
			</table>
		</div>
	</div>
</body>
</html>