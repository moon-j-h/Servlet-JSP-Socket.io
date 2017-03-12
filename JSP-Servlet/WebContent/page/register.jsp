<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 문정현 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register in DalGongFee</title>


<script src='http://code.jquery.com/jquery-1.10.2.js'></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/register.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../css/register.css" rel="stylesheet">
</head>



<body>
	<div class="wrapper"><br/><br/>
	<h3 style="text-align:center">회원가입</h3><br/><br/><br/>
	<form method="post" action="../register.do" onsubmit="return validateForm()" name="registerForm" class="form-horizontal">
		<div class="form-group">
    		<label for="inputName" class="col-lg-2 control-label">Name</label>
    		<div class="col-lg-10">
      			<input type="text" class="form-control" name="name" autofocus/>
    		</div>
  		</div><br/>
  		<div class="form-group">
    		<label for="inputEmail" class="col-lg-2 control-label">Email</label>
    		<div class="col-lg-10">
      			<input type="text" class="form-control" name="email"/>
    		</div>
  		</div><br/>
  		<div class="form-group">
    		<label for="inputPassword" class="col-lg-2 control-label">Password</label>
    		<div class="col-lg-10">
      			<input type="password" class="form-control" name="password"/>
    		</div>
  		</div><br/>
  		<div class="form-group">
    		<label for="inputconfirm" class="col-lg-2 control-label">Check Password</label>
    		<div class="col-lg-10">
      			<input type="password" class="form-control" name="confirmPassword"/>
    		</div>
  		</div><br/>
  
  		<div class="form-group">
    		<div class="col-lg-offset-2 col-lg-10">
      			<button type="submit" class="btn btn-default btn-lg" id="re-btn">register</button>
    		</div>
  		</div>
	</form>
	</div>
</body>
</html>