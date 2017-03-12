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
<link href="css/navbar-user-icon.css" rel="stylesheet">
<link href="css/change_pw.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/navbarBtn.js"></script>
<script>
function changePw(){
	var pw = $.trim($("#pw").val());  // 비밀 번호
	var repw = $.trim($("#repw").val());  // 비밀번호 확인
	// 유효성 확인
	if(pw.length<8 || pw.length>12){
		alert("비밀번호는 8자리이상 12자리이하입니다.");
		return;
	}
	if(pw !== repw){
		alert("비밀번호와 확인 비밀번호가 일치하지 않습니다.");
		return;
	}
	
	$.ajax({
		type:"POST",
		url:"pwChange2.do",
		dataType:"text",
		data:{
			password:pw
		},
		error:function(r){
			alert("다시 시도해주세요.");
		},
		success:function(str){
			alert(str);
			window.location = "watch_share_page.do"; // 댓글 확인 페이지로...
		}
	})
	
}
</script>
</head>
<body>
	<c:import url="navbar.jsp">
		<c:param name="memberId" value="${sessionScope.memberId}"/>
		<c:param name="memberName" value="${sessionScope.memberName}"/>
	</c:import>
	<div class="wrapper"><br/><br/>
	<h3>비밀번호 변경</h3><br/><br/>
	<div class="form-horizontal">
	<div class="form-group">
    	<label class="col-lg-2 control-label">Email</label>
    	<div class="col-lg-10">
      		<p class="form-control-static" id="id">${sessionScope.memberId}</p>
    	</div>
  	</div><br/>
  	<div class="form-group">
    	<label for="inputPassword" class="col-lg-2 control-label">New Password</label>
    	<div class="col-lg-10">
      		<input type="password" class="form-control" id="pw" placeholder="Password" autofocus/>
    	</div>
  	</div><br/>
  	<div class="form-group">
    	<label for="inputconfirm" class="col-lg-2 control-label">Check Password</label>
    	<div class="col-lg-10">
    		<input type="password" class="form-control" id="repw" placeholder="Check Password"/>
    	</div>
  	</div><br/>
  	<br/><br/>
  	<button class="btn btn-default btn-lg" type="button" id="change-pw" onclick="changePw()">Change Password</button>
	</div>
	</div>
</body>
</html>