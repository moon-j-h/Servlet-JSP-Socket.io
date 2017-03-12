<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>share_page_2</title>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/navbarBtn.js"></script>

  <script>
  $(function() {
    $( "#group" ).accordion();
    
    
    if($("#nav-group").hasClass('active')===true){
    	$("#nav-group").removeClass('active');
    }else if($("#nav-invite").hasClass('active')===true){
    	$("#nav-invite").removeClass('active');
    }else if($("#nav-comment").hasClass('active')===true){
    	$("#nav-comment").removeClass('active');
    }
    $("#nav-share").addClass('active');
  });
  </script>
  
  <script type="text/javascript">
  var membersIds = [];
  var membersNames = [];
  var index = 0;
  
  function addInviteList(member){
	  var row = document.getElementById(member);
	  var cells = row.getElementsByTagName("td");
	  
	  var memberId = cells[0].innerText;
	  var memberName = cells[1].innerText;
	  
	  membersIds.push(memberId);
	  membersNames.push(memberName);
	  
	 // var elTr = document.createElement('tr');
	  //var elTbody = document.getElementById('inviteList');
	  
	  //try {
		//elTbody.add(elTr, null); // standards compliant; doesn't work in IE
		//}
		//catch(ex) {
		    //elTbody.add(elTr); // IE only
		  //}
		
		var str = document.getElementById("inviteList").innerHTML;

		str += '<tr>';
		str += '<td>'+memberId+'</td>';
		str += '<td>'+memberName+'</td>';
		str += '<td><button id="cancel'+member+'"'+'class="btn-default btn" name="'+(index++)+'" onclick="removeInviteList(\''+member+'\')">cancel</button><td>';
		str += '<td><input type="hidden" name="inviteIds" value="'+memberId+'"/></td>';
		str += '</tr>';
		
		document.getElementById("inviteList").innerHTML = str;
        
	  document.getElementById("btn"+member).disabled = true;
  }
  
  function removeInviteList(member){
	  var tb = document.getElementById('inviteList');
	  var tr = document.getElementById('cancel'+member).getAttribute("name");
	  var rows = tb.getElementsByTagName('tr').length;
	  
	  tb.deleteRow(tr);
	  index--;
	  
	  document.getElementById("btn"+member).disabled = false;
	  
	  tr *= 1;
	  
	  for(var i=tr; i<rows; i++){ 
		  tb.getElementsByTagName('tr').item(0).getElementsByTagName('td').item(2).getElementsByTagName('button')[0].setAttribute("name", i-1);
	  }		  
  }
  
  function startShare(){
	  document.getElementById("inviteForm").submit();
  }
  </script>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/navbar.css" rel="stylesheet">
<link href="css/navbar-user-icon.css" rel="stylesheet">
<link href="css/share_page.css" rel="stylesheet">
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
	margin:0 auto;
}
.file-img{
	width:55%;
	margin:0 auto;
}
.group-member-list{
	float:right;
	width:50%;
	margin-right:30px;
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
	<c:import url="navbar.jsp">
		<c:param name="memberId" value="${sessionScope.memberId}"/>
		<c:param name="memberName" value="${sessionScope.memberName}"/>
	</c:import>
	<div class="wrapper">
		<div class="file-img">
		<h3>
		<button type="button" class="btn btn-default btn-lg" id="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
			</button>	
		페이지 공유(2/2)
		<button type="button" class="btn btn-default btn-lg" id="next" onclick="startShare()">
			<span class="glyphicon glyphicon-chevron-right"></span>	
		</button>
		</h3>
		</div>
	</div>
	
	<br/>
	<br/>
	
	<div id="group">
		<c:forEach items="${requestScope.groupList.groupInfoList}" var="groupInfo" varStatus="groupCnt">
			<h3>${groupInfo.groupName}</h3>
			<div>
			<table style="width: 100%">
				<tr>
					<th width="60%">ID</th>
					<th width="30%">name</th>
					<th width="10%">invite</th>
				</tr>

				<c:forEach items="${groupInfo.groupMemberList.groupMemberList}" var="memberInfo" varStatus="memberCnt">
					<tr id="${groupCnt.count}of${memberCnt.count}">
						<td>${memberInfo.memberId}</td>
						<td>${memberInfo.memberName}</td>
						<td><button id="btn${groupCnt.count}of${memberCnt.count}" class="btn-default btn" onclick="addInviteList(${groupCnt.count}+'of'+${memberCnt.count})">invite</button>
						<td>
					</tr>
				</c:forEach>
			</table>
			</div>
		</c:forEach>
	</div>
	
	<form id="inviteForm" action="start_share.do" method="post">
	<div class="group-member-list">
	<input type="hidden" name="fileCode" value="${requestScope.fileCode}"/>
			<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>name</th>
					<th>cancel</th>
				</tr>
			</thead>
				<tbody id="inviteList">
				
				</tbody>
			</table>
	</div>
	<input type="hidden" value="${requestScope.imagePath}" name="imagePath"/>
	</form>
	
</body>
</html>