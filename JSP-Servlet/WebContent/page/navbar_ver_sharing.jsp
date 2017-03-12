<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Insert title here</title>
<!-- 
<link href="../css/bootstrap.css" rel="stylesheet" media="screen">
<link href="../css/navbar_ver_sharing.css" rel="stylesheet">
 -->
<!--  <script>
 // 로그아웃 시
 function logout(){ 
	 if(confirm("로그아웃 하시겠습니까?")){
		 window.location = "/DalGongFee"; // 로그인 화면으로
		}
 }
 
 function exitPage(){
	 if(confirm("정말로 나가시겠습니까?")){
			window.location = "watch_share_page.do";
		}
 }
 </script> -->
</head>
<body id="page-top" class="index">
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  	<div class="navbar-header">
    	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
      		<span class="sr-only">Toggle navigation</span>
      		<span class="icon-bar"></span>
      		<span class="icon-bar"></span>
      		<span class="icon-bar"></span>
    	</button>
    	<a class="navbar-brand" href="#page-top">DalGongFee</a>
  	</div>
 
  <!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav navbar-right">
     		<li class="dropdown">
     			<span class="glyphicon glyphicon-user dropdown-toggle user-icon" data-toggle="dropdown"></span>
     			<ul class="user-info dropdown-menu">
     				<li id="user-id">ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <span>${param.memberId}</span></li>
     				<li id="user-name">NAME : <span>${param.memberName}</span></li>
     			</ul>
     		</li>
     		<li class="dropdown">
     			<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="badge pull-right"></span>joiner list<b class="caret"></b></a>
     			<ul class="dropdown-menu joiner-list">
     				<li>
     					<table class="table table-hover attendance-list">
     						<thead>
     						<tr>
     							<th>ID</th>
     							<th>NAME</th>
     						</tr>
     						</thead>
     						<tbody>
     						</tbody>
     					</table>
     				</li>
     			</ul>
     		</li>
     		<li><button type="button" class="btn btn-default navbar-btn" id="exit-btn" onclick = "exitPage()">exit</button></li>
     		<li><button type="button" class="btn btn-default navbar-btn" id="logout-btn" onclick = "logout()">logout</button></li>
     	</ul>
  	</div><!-- /.navbar-collapse -->
</nav>
	
 <!--  Placed at the end of the document so the pages load faster -->
	<!-- <script src='http://code.jquery.com/jquery-1.10.2.js'></script> -->
    <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
    <!-- <script src="../js/bootstrap.min.js"></script> -->
</body>
</html>