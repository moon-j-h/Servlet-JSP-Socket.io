/**
 * 댓글 관리 창에서 사용하는 자바 스크립트
 */
$(function(){
	$("ul.nav").children().removeClass('active');
	$("#nav-comment").addClass('active');
	var addr = $("#path").val(); // fileAddress
	var max = $("#maxPageNum").val();
	var pa=[];
	for(var i=1; i<parseInt(max)+1; i++){
		pa.push(addr+""+i+".jpg");
	}
	pages = pa;
	$("#file-page").attr('src', addr+"1.jpg");
});

// 댓글 입력 창 코드 저장
var commentInput = "<div class='list-group-item recomment-input-div'><table class='input-table'><tr><td>┗━&nbsp;</td><td colspan='3'><textArea class='form-control recomment-write' rows='2'></textArea></td><td><button type='button' class='btn btn-default recomment-input' onclick='writeRecomment()'>Ok</button></td></tr></table></div>";
// 상위 댓글 코드를 저장할 변수
var superCommentCode=0;
// 현재 보여주고 있는 페이지의 인덱스
var nowPage = 0;
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
	
	var commentContent = $(".recomment-write").val();
	$.ajax({
		type:"POST",
		url:"write_comment.do",
		dataType:"json",
		data:{
			parentCode : superCommentCode,
			pageNum : nowPage+1,
			content : commentContent
		},
		error:function(r){
			alert("다시 입력해주세요.");
		},
		success:function(data){
			result = "<br/><br/><div class='list-group'>";
			if(data==""){
				result += ("<p class='list-group-item'>댓글이 없습니다.</p>");
			}else{
				$.each(data, function(index, item){
					if(item.parentCommentCode == null && item.pageNum == (nowPage+1)){ // 상위 댓글임   
						result += ("<p class='list-group-item'><span class='name'>"+item.writerName+"</span>&nbsp;(<span class='id'>"+item.writerId+"</span>)&nbsp;&nbsp;<span class='write-date'>"+item.writeDate+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class='recomment' id="+item.commentCode+" onclick='makeRecommentTextArea("+item.commentCode+")'>☞답글</span><br/>"+item.commentContent+"</p>");
					}else if(item.parentCommentCode != null && item.pageNum == (nowPage+1)){
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

var pages;

function prevPage(){
	if(nowPage!=0){
		$("#file-page").attr('src', pages[--nowPage]);
		refreshComment();
	}else{
		alert("첫번째 페이지 입니다.");
	}
}

function nextPage(){
	if(nowPage!=(pages.length-1)){
		$("#file-page").attr('src', pages[++nowPage]);
		refreshComment();
	}
	else{
		alert("마지막 페이지 입니다.");
	}
}

function refreshComment(){
	$.ajax({
		type:"POST",
		url:"refresh_comment.do",
		dataType:"json",
		data:{
			pageNum : (nowPage+1)
		},
		error:function(r){
			alert("다시 입력해주세요.");
		},
		success:function(data){
			result = "<br/><br/><div class='list-group'>";
			if(data==""){
				result += ("<p class='list-group-item'>댓글이 없습니다.</p>");
			}else{
				$.each(data, function(index, item){
					if(item.parentCommentCode == null && item.pageNum == (nowPage+1)){ // 상위 댓글임   
						result += ("<p class='list-group-item'><span class='name'>"+item.writerName+"</span>&nbsp;(<span class='id'>"+item.writerId+"</span>)&nbsp;&nbsp;<span class='write-date'>"+item.writeDate+"</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class='recomment' id="+item.commentCode+" onclick='makeRecommentTextArea("+item.commentCode+")'>☞답글</span><br/>"+item.commentContent+"</p>");
					}else if(item.parentCommentCode != null && item.pageNum == (nowPage+1)){
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