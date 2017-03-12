<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>share_page_2</title>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
  <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
 <link href="../css/navbar_ver_sharing.css" rel="stylesheet">
<link href="../css/share_page.css" rel="stylesheet">
  <script>
  
  </script>
  

<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/navbar.css" rel="stylesheet">
<style>
#group{
	width:40%;
	float:left;
	margin-left:30px;
	margin-right:15px;
}

th, td {
    text-align: center;
}

h3{
	text-align: center;
}


.wrapper{
	width:100%;
	margin:20px auto;
}

.file-img{
	width:60%;
	margin-left:20px;
	float:left;
}
.comment-list{
	width:35%;
	margin-right:20px;
	float:right;
}
#first-page{
	width:100%;
	margin:0 auto;
}
#file-choice{
	margin:20px;
	font-size: 20px;
}
#next{
	float:right;
	margin-bottom:8px;
}
#prev{
	float:left;
	margin-bottom:8px;
}
</style>
</head>
<body>
	<c:import url="navbar_ver_sharing.jsp"/>
	
	<div class="wrapper">
		<div class="file-img">
			
		<img src="../img/santa.jpg" alt="first page" id="first-page" class="img-thumbnail"/>
			
		</div>
		
		<div class="comment-list">
				<div class="list-group">
					<a href="#" class="list-group-item">
						<p class="list-group-item-text"><span class="name"> 문정현</span>(<span class="id">answjdgus222@naver.com</span>)<span class="write-date"> 2014.10.13</span><br/>우와.. 이게 어떻게 이럴게 되나요? 진짜 신기하네  ㅋㅋㅋ</p>
					</a>
					<a href="#" class="list-group-item">
						<p class="list-group-item-text"><span class="name"> 문정현</span>(<span class="id">answjdgus222@naver.com</span>)<span class="write-date"> 2014.10.13</span><br/>우와.. 이게 어떻게 이럴게 되나요? 진짜 신기하네  ㅋㅋㅋ</p>
					</a>
					<a href="#" class="list-group-item">
						<p class="list-group-item-text"><span class="name"> 문정현</span>(<span class="id">answjdgus222@naver.com</span>)<span class="write-date"> 2014.10.13</span><br/>우와.. 이게 어떻게 이럴게 되나요? 진짜 신기하네  </p>
					</a>
				</div>
				<div class="input-group-lg">
					<textarea style="width:85%" class="form-control" placeholder="enter comment" id="prev"></textarea>
					<button class="btn-default btn" id="next">write</button>
				</div>
		</div>
		
	</div>
	

</body>
</html>