<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 문정현 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login GolDangFee</title>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<script src='http://code.jquery.com/jquery-1.10.2.js'></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/login.js"></script>
<link href="css/login.css" rel="stylesheet">
</head>
<body>
	<div class="wrapper"><br/><br/>
	<h3 style="text-align:center">로그인</h3><br/>
	<form class="form-horizontal" name="login-form" method="post" action="login.do" onsubmit = "return validateForm()">
  		<div class="form-group">
    		<label for="inputEmail1" class="col-lg-2 control-label">Email</label>
    		<div class="col-lg-10">
      			<input type="text" class="form-control" id="id" name="id" autofocus/>
    		</div>
  		</div><br/>
 	 	<div class="form-group">
    		<label for="inputPassword1" class="col-lg-2 control-label">Password</label>
    		<div class="col-lg-10">
      			<input type="password" class="form-control" id="pw" name="pw"/>
    		</div>
  		</div><br/>
  		<div class="form-group">
    		<div class="col-lg-offset-2 col-lg-10">
      			<a href="page/register.jsp" id="go-register">register</a>
    		</div>
  		</div>
  		<div class="form-group">
    		<div class="col-lg-offset-2 col-lg-10">
      			<button type="submit" class="btn btn-default btn-lg" id="lo-btn">Login</button>
    		</div>
  		</div>
	</form>
	<c:if test="${requestScope.error ne null }">
		<p id="error-p">${requestScope.error}</p>
	</c:if>
	</div>
</body>
</html>