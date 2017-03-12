<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 문정현 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Share Page for Host</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/navbarBtn.js"></script>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<link href="css/navbar_ver_sharing.css" rel="stylesheet">
<link href="css/full-slider.css" rel="stylesheet">
<style>
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
</style>
<script src="http://192.168.0.100:13000/socket.io/socket.io.js"></script>
<script>
$(function(){
	var memberId = $("#user-id span").html(); // 로그인 한 회원의 아이디 가져오기
	var memberName = $("#user-name span").html(); // 로그인 한 회원의 이름 가져오기
	var roomNum = $("#room-num").val();  // 방번호
	//alert(memberId+"/"+memberName+"/"+roomNum);
	var filePath = $("#imgs-path").val(); // 파일 경로
	var maxNum = $("#max-num").val(); // 파일 수
	//alert("filePath  : "+filePath);
	$("#myCarousel").carousel({
		interval: false
	});
	
	$("#myCarousel").on('slide.bs.carousel', function(e){
		
		//var slideFrom = $(this).find('.active').index()+1;  // 현재 보고있는 페이지
		var slideTo = $(e.relatedTarget).index()+1;  // 다음 볼 페이지
		//alert(slideFrom+" -> "+slideTo);
		socket.emit("changePage", slideTo); // 변경된 페이지를 전송
		
	});
	socket.on('connect', function(){
		socket.emit("addJoiner", {"roomNum": roomNum, "memberId" : memberId, "memberName" : memberName}, {"path": filePath, "num": maxNum});  // room이름은 파일 코드로
		socket.on('setJoinerList', function(data){ // 참가자 목록 세팅
			for(var i=0; i<data.length; i++){
				$(".attendance-list").append("<tr><td class='attendance-id'>"+data[i].memberId+"</td><td class='attendance-name'>"+data[i].memberName+"</td></tr>");
			}
		});
	});
	
})

var socket = io.connect("http://192.168.0.100:13000"); // node.js서버에 연결
// 참가자 목록 변경
socket.on('updateJoinerList', function(memberId, memberName){
		$(".attendance-list").append("<tr><td class='attendance-id'>"+memberId+"</td><td class='attendance-name'>"+memberName+"</td></tr>");
});
// guest중 한 명이 나감
socket.on('outJoiner', function(data){
	var list = $(".attendance-list tbody").empty();
	for(var i=0; i<data.length; i++){
		$(".attendance-list").append("<tr><td class='attendance-id'>"+data[i].memberId+"</td><td class='attendance-name'>"+data[i].memberName+"</td></tr>");
	}
});
// 댓글 알림 창? 구현 예정


</script>
</head>
<body class="full">
	<c:import url="navbar_ver_sharing.jsp">
		<c:param name="memberId" value="${sessionScope.memberId}"/>
		<c:param name="memberName" value="${sessionScope.memberName}"/>
	</c:import>
	<input type="hidden" id="room-num" value="${requestScope.link}"/>
	<input type="hidden" id="imgs-path" value="${requestScope.path}"/>
	<input type="hidden" id="max-num" value="${requestScope.maxNum}"/>
	<!-- Full Page Image Background Carousel Header -->
    <div id="myCarousel" class="carousel slide">
        <!-- Wrapper for Slides -->
        <div class="carousel-inner">
            <c:forEach items="${requestScope.paths}" var="path" varStatus="pathLoopCount">
            	<c:choose>
            		<c:when test="${pathLoopCount.count ne 1 }">
            			<div class="item">
            				<div class="fill">
                				<img src="${path}" class="fill">
                			</div>
            			</div>
            		</c:when>
            		<c:otherwise>
            			<div class="item active">
            				<div class="fill">
                				<img src="${path}" class="fill">
                			</div>
            			</div>
            		</c:otherwise>	
            	</c:choose>
            </c:forEach>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </div>
    
</body>
</html>