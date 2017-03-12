<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>comment management</title>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<link href="css/navbar.css" rel="stylesheet">
<link href="css/comment_manage.css" rel="stylesheet">
<script src='http://code.jquery.com/jquery-1.10.2.js'></script>
<script>
// 댓글 입력 창 코드 저장
var commentInput = "<div class='list-group-item recomment-input-div'><table class='input-table'><tr><td>┗━&nbsp;</td><td colspan='3'><textArea class='form-control recomment-write' rows='2'></textArea></td><td><button type='button' class='btn btn-default recomment-input' onclick='writeRecomment()'>Ok</button></td></tr></table></div>";
// 상위 댓글 코드를 저장할 변수
var superCommentCode=0;
// 현재 보여주고 있는 페이지
var nowPage = 1;
// 댓글 작성 또는 변경 삭제 등을 했을 때 그 결과 값을 이용해 작성한 html코드를 저장할 변수
var result = "";

function makeRecommentTextArea(commentCode){
	var temp = $("span.recomment[id="+commentCode+"]").text();
	if(temp == "☞답글"){
		if(superCommentCode!=0){
			// 전에 선택 했던 것을 원래대로 돌려 놓기
			$("div").remove(".recomment-input-div");
			$("span.recomment[id="+superCommentCode+"]").text("☞답글");
			$("span.recomment[id="+superCommentCode+"]").css('color','#A9A9A9');
		}
		// 이번에 선택 한 것을 바꾸기
		$("span.recomment[id="+commentCode+"]").text("☞답글 취소");
		$("span.recomment[id="+commentCode+"]").css('color','#DC143C');
		$("span.recomment[id="+commentCode+"]").parent().after(commentInput);
		superCommentCode = commentCode;
	}else{  // 답글 취소 눌렀을 때
		$("span.recomment[id="+superCommentCode+"]").text("☞답글");
		$("span.recomment[id="+superCommentCode+"]").css('color','#A9A9A9');
		$("div").remove(".recomment-input-div");
	}
}

function writeRecomment(){
	//alert(superCommentCode);
	
	var commentContent = $(".recomment-write").val();
	//alert(commentContent);
	$.ajax({
		type:"POST",
		url:"write_comment.do",
		dataType:"json",
		data:{
			parentCode : superCommentCode,
			pageNum : nowPage,
			content : commentContent
		},
		error:function(r){
			alert("다시 입력해주세요.");
		},
		success:function(data){
			result = "<div class='list-group'>";
			if(data==""){
				result += ("<p class='list-group-item'>댓글이 없습니다.</p>");
			}else{
				$.each(data, function(index, item){
					if(item.parentCommentCode == null){ // 상위 댓글임   
						result += ("<p class='list-group-item'><span class='name'>"+item.writerName+"</span>&nbsp;(<span class='id'>"+item.writerId+"</span>)&nbsp;&nbsp;<span class='write-date'>"+item.writeDate+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class='recomment' id="+item.commentCode+" onclick='makeRecommentTextArea("+item.commentCode+")'>☞답글</span><br/>"+item.commentContent+"</p>");
					}else{
						//result += ("<p class='list-group-item'>&nbsp;&nbsp;┗━&nbsp;<span class='name'>"+item.writerName+"</span>&nbsp;(<span class='id'>"+item.writerId+"</span>)&nbsp;&nbsp;<span class='write-date'>"+item.writeDate+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class='recomment' id="+item.commentCode+" onclick='makeRecommentTextArea("+item.commentCode+")'>☞답글</span><br/>"+item.commentContent+"</p>");
						result += ("<p class='list-group-item'>&nbsp;&nbsp;┗━&nbsp;<span class='name'>"+item.writerName+"</span>&nbsp;(<span class='id'>"+item.writerId+"</span>)&nbsp;&nbsp;<span class='write-date'>"+item.writeDate+"</span><br/>"+item.commentContent+"</p>");
					}
				});
			}
			result+="</div>";
			$(".comment-list").html(result);
		}
	});
}
</script>
<style>
.recomment-input{
	margin-top: 5px;
	float: right;
	font-size: 8px;
}
.input-table{
	width:95%;
}
</style>
</head>
<body>
	<c:import url="navbar.jsp"/>
	<h3>댓글 관리</h3><br/>
	<div class="wrapper">
		<div class="page-view">
				<img src="img/nonepage.jpg" id="file-page" class="img-thumbnail"/>
		</div>
		<div class="comment-list">
			<div class="list-group">
				<c:forEach items="${requestScope.commentInfoList.commentInfoList}" var="commentInfo">
					<c:if test="${commentInfo.parentCommentCode eq null}">
						<p class="list-group-item"><span class="name">${commentInfo.writerName}</span>&nbsp;(<span class="id">${commentInfo.writerId}</span>)&nbsp;&nbsp;<span class="write-date"> ${commentInfo.writeDate}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="recomment" id="${commentInfo.commentCode}" onclick="makeRecommentTextArea(${commentInfo.commentCode})">☞답글</span><br/>${commentInfo.commentContent}</p>
					</c:if>
					<c:if test="${commentInfo.parentCommentCode ne null}">
						<!-- <p class="list-group-item">&nbsp;&nbsp;┗━&nbsp;<span class="name">${commentInfo.writerName}</span>&nbsp;(<span class="id">${commentInfo.writerId}</span>)&nbsp;&nbsp;<span class="write-date"> ${commentInfo.writeDate}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="recomment" id="${commentInfo.commentCode}" onclick="makeRecommentTextArea(${commentInfo.commentCode})">☞답글</span><br/>${commentInfo.commentContent}</p> -->
						<p class="list-group-item">&nbsp;&nbsp;┗━&nbsp;<span class="name">${commentInfo.writerName}</span>&nbsp;(<span class="id">${commentInfo.writerId}</span>)&nbsp;&nbsp;<span class="write-date"> ${commentInfo.writeDate}</span><br/>${commentInfo.commentContent}</p>
					</c:if>
					<c:if test="${commentInfo eq null}">
						<p class="list-group-item">작성된 댓글이 없습니다.</p>
					</c:if>
				</c:forEach>
				<!-- <div class="list-group-item"><table class="input-table"><tr><td colspan="3"><textArea class="form-control recomment-write" rows="2"></textArea></td><td><button type="button" class="btn btn-default recomment-input">Ok</button></td></tr></table></div> -->
			</div>
		</div>
	</div>
</body>
</html>