<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
     			<span class="glyphicon glyphicon-user user-icon dropdown-toggle" data-toggle="dropdown"></span>
     			<ul class="user-info dropdown-menu">
     				<li id="user-id">ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <span>${param.memberId}</span></li>
     				<li id="user-name">NAME : <span>${param.memberName}</span></li>
     			</ul>
     		</li>
      		<li id="nav-comment"><a href="watch_share_page.do">comment</a></li>
      		<li id="nav-group"><a href="watch_group.do">group</a></li>
     		<li id="nav-invite"><a href="watch_invite.do">invite</a></li>
     		<li id="nav-share"><a href="go_to_share_page.do">start page share</a></li>
     		<li><button type="button" class="btn btn-default navbar-btn" onclick = "changePw()">change pw</button></li>
     		<li><button type="button" class="btn btn-default navbar-btn" id="logout-btn" onclick="logout()">logout</button></li>
     	</ul>
  	</div><!-- /.navbar-collapse -->
</nav>
