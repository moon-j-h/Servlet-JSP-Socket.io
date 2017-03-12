<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>share_page_step_1</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/navbar.css" rel="stylesheet">
<link href="css/navbar-user-icon.css" rel="stylesheet">
<!-- <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>  -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/navbarBtn.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		if($("#nav-group").hasClass('active')===true){
			$("#nav-group").removeClass('active');
		}else if($("#nav-invite").hasClass('active')===true){
			$("#nav-invite").removeClass('active');
		}else if($("#nav-comment").hasClass('active')===true){
			$("#nav-comment").removeClass('active');
		}
		$("#nav-share").addClass('active');
		
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
				reader.onload = function(e) {

					$('#first-page').attr('src', e.target.result); //이미지 Tag의 SRC속성에 읽어들인 File내용을 지정
				};
				reader.readAsDataURL(input.files[0]); //File내용을 읽어 dataURL형식의 문자열로 저장
			}
		};

		//file 양식으로 이미지를 선택(값이 변경) 되었을때 처리하는 코드
		$("#filename").change(function() {			
			//alert(this.value); //선택한 이미지 경로 표시
			var filename = this.value.substring(this.value.lastIndexOf('\\')+1);
			
			upload();
			
			setTimeout(function updatePath(){
				//readURL(this);
				var mid = $("#user-id span").text();
				//alert(mid);
				var path = "saveFile/" + mid + "/" + filename + "/1.jpg";
				var str = '<input type="hidden" name="imagePath" value="' + path + '"/>';
				
				document.getElementById("imgPath").innerHTML = str;
				
				document.getElementById("first-page").src = path;
			}, 10000);
		});
	});
	
	

	function upload() 
	{
	  var fileInput = document.getElementById("filename");	  
	  var file = fileInput.files[0];   
	  
	  var formData = new FormData();
	  formData.append("filename", file);
	  
	  var client = new XMLHttpRequest();
	  
	  client.open("post", "choose_file.do", true);
	  client.send(formData); 
	 }  
</script>

<style>
.wrapper{
	width:100%;
	margin:0 auto;
}
.file-img{
	width:55%;
	margin:0 auto;
}
#first-page{
	width:100%;
	height:320px;
	margin:5px auto;
}
#file-choice{
	margin:20px;
	font-size: 20px;
}
#next{
	float:right;
	margin-bottom:8px;
}
</style>
</head>
<body>
	<c:import url="navbar.jsp">
		<c:param name="memberId" value="${sessionScope.memberId}"/>
		<c:param name="memberName" value="${sessionScope.memberName}"/>
	</c:import>
	<div class="wrapper">
		<div class="file-img">
	<form action="select_file.do" method="post" enctype="multipart/form-data">
		<h3>페이지 공유(1/2)
		<button type="submit" class="btn btn-default btn-lg" id="next">
			<span class="glyphicon glyphicon-chevron-right"></span>	
		</button>
		</h3>
		<br/>
		<img src="#" alt="first page" id="first-page" class="img-thumbnail"/>
		<input type="file" id="filename" name="filename"/>
		<p id="imgPath"></p>
	</form>
	</div>
	</div>
</body>
</html>