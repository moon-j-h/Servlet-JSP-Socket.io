<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 문정현 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>change password</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/navbar.css" rel="stylesheet">
<link href="css/change_pw.css" rel="stylesheet">
<link href="css/navbar-user-icon.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/navbarBtn.js"></script>
<script>
function validatePw(){
	var pw = $.trim($("#inputPassword").val());
	if(pw.length<8){
		alert("비밀번호는 8자리 이상입니다.");
		return false;
	}
}
</script>
<style>
#error-div{
	font-size: 20px;
	color:#DC143C;
}
</style>
</head>
<body>
	<c:import url="navbar.jsp">
		<c:param name="memberId" value="${sessionScope.memberId}"/>
		<c:param name="memberName" value="${sessionScope.memberName}"/>
	</c:import>
	<div class="wrapper"><br/><br/>
	<h3>비밀번호 변경</h3><br/><br/>
	<form class="form-horizontal" action="pwChange1.do" method="Post" onsubmit="return validatePw()">
  		<div class="form-group">
    		<label class="col-lg-2 control-label">Email</label>
    		<div class="col-lg-10">
      			<p class="form-control-static">${sessionScope.memberId}</p>
    		</div>
  		</div>
  		<div class="form-group">
    		<label for="inputPassword" class="col-lg-2 control-label">Password</label>
    		<div class="col-lg-10">
      			<input type="password" class="form-control" id="inputPassword" name="pw" placeholder="Password" autofocus/>
    		</div>
  		</div>
  		<br/><br/>
  		<button class="btn btn-default btn-lg" type="submit" id="change-pw">go to next step</button>
	</form>
	<div id="error-div">
		<c:if test="${requestScope.error ne null}">
			${requestScope.error}
		</c:if>
	</div>
	</div>
</body>
</html>