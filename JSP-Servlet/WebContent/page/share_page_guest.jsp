<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Share Page for Guest</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/navbarBtn.js"></script>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<link href="css/navbar_ver_sharing.css" rel="stylesheet">
<style>
.wrapper{
	width:100%;
	height:60%;
}
.user-info{
	text-transform: none;
	width:300px;
}	
.user-icon{
	font-size: 35px;
	margin: 0 auto;
}
.joiner-list{
	text-transform: none;
	width:500px;
}
.comment-list{
	float:right;
	width:30%;
	height:500px;
	font-size: 12px;
	overflow-y: auto;
	overflow-x: hidden; 
}
.write-comment-input{
	float:right;
	width:30%;
	font-size: 12px;
}
.input-table{
	width:100%;
}
.comment-input{
	margin-top: 5px;
	float: right;
	font-size: 12px;
}
.now-page-fill{
	width:70%;
	float:left;
    -webkit-background-size: contain;
    -moz-background-size: contain;
    background-size: contain;
    -o-background-size: contain;
}
#slide-page-num{
	width:80%;
}
.refresh-comment{
	margin-right:5px;
	margin-bottom:10px;
	float:right;
	font-size:2rem;
}
.refresh-comment:hover{
	cursor: pointer;
}
</style>
<script src="http://192.168.0.100:13000/socket.io/socket.io.js"></script>
<script>
$(function(){
	var id=$("#user-id span").text();
	var name = $("#user-name span").text();
	var fileCode = $("#r-n").val();  // 방번호
	socket.on('connect', function(){
		socket.emit('addJoiner', {"roomNum": fileCode, "memberId": id, "memberName": name}, null);
		socket.on('setJoinerList', function(data){ // 참가자 목록 세팅
			for(var i=0; i<data.length; i++){
				$(".attendance-list").append("<tr><td class='attendance-id'>"+data[i].memberId+"</td><td class='attendance-name'>"+data[i].memberName+"</td></tr>");
			}
		});
		socket.on("setFileInfo", function(filePath, maxNum){
			path = filePath;
			$("#now-page").attr('src', path+"/1.jpg");
			for(var i=0; i<maxNum; i++){
				$("#slide-page-num").append("<option value="+(i+1)+">"+(i+1)+"</option>");
			}
		});
	});
	$(".refresh-comment").on('click', function(){
		$.ajax({
			type:"POST",
			url:"refresh_comment.do",
			dataType:"json",
			data: {
				
			},
			error:function(r){
				alert("새로고침을 실패했습니다.");
			},
			success:function(data){
				var result="";
				if(data==""){
					result="<p class='list-group-item'>댓글이 없습니다.</p>";
				}else{
					$.each(data, function(index, item){
						result+=("<p class='list-group-item'><span class='commnet-page-num'>"+item.pageNum+"</span> page<span class='glyphicon glyphicon-bookmark'></span>&nbsp;&nbsp;<span class='name'>"+item.writerName+"</span>&nbsp;(<span class='id'>"+item.writerId+"</span>)<br/>"+item.commentContent+"</p>");
					});
				}
				$(".written-comment").html(result);
			}
		});
		
	});
})
var path=null;
var socket = io.connect("http://192.168.0.100:13000");
socket.on('updateJoinerList', function(memberId, memberName){
	$(".attendance-list").append("<tr><td class='attendance-id'>"+memberId+"</td><td class='attendance-name'>"+memberName+"</td></tr>");
});
socket.on("outAllJoiner", function(memberId){
	alert("발표자가 방을 나갔습니다.");
	window.location = "watch_share_page.do";		
});
socket.on('outJoiner', function(data){
	var list = $(".attendance-list tbody").empty();
	for(var i=0; i<data.length; i++){
		$(".attendance-list").append("<tr><td class='attendance-id'>"+data[i].memberId+"</td><td class='attendance-name'>"+data[i].memberName+"</td></tr>");
	}
});
socket.on("updatePage", function(page){
	var imgPath = path+"/"+page+".jpg";
	$("#now-page").attr('src', imgPath);
	var con = $.trim($(".comment-write").val()); // 댓글 내용
	if(con === ""){
		$("#slide-page-num option[value="+page+"]").attr('selected', true);
	}
});

function validate_form(){
	var content = $('.comment-write').val();
	if(content == null || content == ""){
		alert("댓글 내용을 입력해 주세요.");
		return false;
	}
	if(content.length>500){
		alert("500자 미만으로 입력해 주세요.");
		return false;
	}
}
function writeComment(){
	var commentContent = $.trim($('.comment-write').val());
	var writePage = $('#slide-page-num option:selected').val();
	$.ajax({
		type:"POST",
		url :"write_comment.do",
		dataType:"json",
		data:{
			pageNum : writePage,
			content : commentContent
		},
		error:function(r){
			alert("다시 입력해주세요.");
		},
		success:function(data){
			var result="";
			if(data==""){
				result="<p class='list-group-item'>댓글이 없습니다.</p>";
			}else{
				$.each(data, function(index, item){
					result+=("<p class='list-group-item'><span class='commnet-page-num'>"+item.pageNum+"</span> page<span class='glyphicon glyphicon-bookmark'></span>&nbsp;&nbsp;<span class='name'>"+item.writerName+"</span>&nbsp;(<span class='id'>"+item.writerId+"</span>)<br/>"+item.commentContent+"</p>");
				});
			}
			//alert(result);
			$(".written-comment").html(result);
			$(".comment-write").val("");
		}
	});
	
}
</script>

</head>
<body>
	<c:import url="navbar_ver_sharing.jsp">
		<c:param name="memberId" value="${sessionScope.memberId}"/>
		<c:param name="memberName" value="${sessionScope.memberName}"/>
	</c:import>
	<div class="wrapper">
	<img src="" id="now-page" class="now-page-fill"/>
	<span class='glyphicon glyphicon-refresh refresh-comment'></span>
	<div class="comment-list">
		<div class="list-group written-comment">
			<p class='list-group-item'>댓글이 없습니다.</p>
		</div>
	</div>
	<div class="write-comment-input">
		<div class="list-group">
			<div class="list-group-item">
				<table class="input-table">
					<tr>
						<td>
							<select class="form-control input-sm" id="slide-page-num" name="pageNum">
							</select>
						</td>
						<td colspan="3">
							<textArea class="form-control comment-write" rows="2" autofocus name="content"></textArea>
						</td>
						<td>
							<button type="button" class="btn btn-default comment-input" onclick="writeComment()">Ok</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<input type="hidden" value="${requestScope.roomNum}" id="r-n"/>
	</div>
</body>
</html>