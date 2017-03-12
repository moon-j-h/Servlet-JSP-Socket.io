<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>group management</title>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<link href="css/navbar.css" rel="stylesheet">
<link href="css/navbar-user-icon.css" rel="stylesheet">
<link href="css/group_manage.css" rel="stylesheet">
<script src='http://code.jquery.com/jquery-1.10.2.js'></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/navbarBtn.js"></script>
</head>

<script type="text/javascript">
$(function(){
	if($("#nav-comment").hasClass('active')===true){
		$("#nav-comment").removeClass('active');
	}else if($("#nav-invite").hasClass('active')===true){
		$("#nav-invite").removeClass('active');
	}else if($("#nav-share").hasClass('active')===true){
		$("#nav-share").removeClass('active');
	}
	$("#nav-group").addClass('active');
})
	
	function addGroup() {
		var groupName = prompt("Please Insert GroupName");

		//alert(groupName);
		if(groupName.trim() == ""){
			alert("Wrong Group Name!!");
		}
		else{
			var formData = new FormData();
			formData.append("groupname", groupName);

			var client = new XMLHttpRequest();

			client.open("post", "create_group.do", true);
			client.send(formData);
			
			
			setTimeout(function updatePath(){
				location.reload(true);
			}, 2000);
		}
		
		return ;
	}

	function selectGroup(gcode){
		//alert(gcode);
		
		var idList = new Array();
		var nameList = new Array();
		
		<c:forEach items="${requestScope.groupList.groupInfoList}" var="groupInfo">
			var groupCode = '${groupInfo.groupCode}';
			if( groupCode == gcode ){
				<c:forEach items="${groupInfo.groupMemberList.groupMemberList}" var="groupMember">
					idList.push("${groupMember.memberId}");
					nameList.push("${groupMember.memberName}");
				</c:forEach>
			}
		</c:forEach> 
		
		var str = "";
		var msg = "Relly Delete Group Member?";
		
		str += '<input type="hidden" id="selectedGroup" value="'+gcode+'"/>';
		for(var i=0;i<idList.length; i++){
			str += '<tr>';
			str += '<td width="50%">'+idList[i]+'</td>';
			str += '<td width="35%">'+nameList[i]+'</td>';
			str += '<td width="15%"> <form onSubmit="if(!confirm(\''+msg+'\')){return false;}" action="delete_member.do" method="post"> <input type="hidden" name="groupCode" value="'+gcode+'"/> <input type="hidden" name="memberId" value="'+idList[i]+'"/> <input type="submit" class="btn btn-default" value="delete"/> </form> <td>';
			str += '</tr>';
		}
		
		//alert(str);
		
		document.getElementById("groupMemberList").innerHTML = str;
		document.getElementById("group-member-add").disabled = false;
	}
	
	function addGroupMember(){
		var memberId = prompt("Please Insert MemberID");
		var groupCode = document.getElementById("selectedGroup").value;
		
		//alert(groupCode);
		
		if(memberId.trim() == ""){
			alert("Wrong Member ID!!");
		}
		else{
			var formData = new FormData();
			formData.append("memberid", memberId);
			formData.append("groupcode", groupCode);

			var client = new XMLHttpRequest();

			client.open("post", "add_member.do", true);
			client.send(formData);
			
			
			setTimeout(function updatePath(){
				location.reload(true);
			}, 2000);
		}
		
		
		//존재하지 않는 아이디라는 에러메시지 띄워줘야되는데..
		
		return ;
	}
</script>

<body>
	<c:import url="navbar.jsp">
		<c:param name="memberId" value="${sessionScope.memberId}"/>
		<c:param name="memberName" value="${sessionScope.memberName}"/>
	</c:import>
	<h3>그룹 관리</h3><br/>
	<div class="wrapper">
		<div class="group-list">
		<table class="table table-hover">
			<thead>
				<tr>
					<th width="65%">group name</th>
					<th width="20%">member</th>
					<th width="15%">delete</th>
				</tr>
			</thead>
		</table>
			<ul class="list-group">
			<c:forEach items="${requestScope.groupList.groupInfoList}" var="groupInfo" varStatus="groupCnt">
				<li class="list-group-item" onclick="selectGroup(${groupInfo.groupCode})">
				<form onSubmit="if(!confirm('Really Delete Group?')){return false;}" action="delete_group.do" method="post" >
				<table>
					<tr>
						<td width="65%"> ${groupInfo.groupName}</td>
						<td width="20%"> <span class="badge attendance-number">${groupInfo.size} </span></td>
					<td width="15%"><input type="hidden" name="groupCode" value="${groupInfo.groupCode}"/>
						<input type="submit" class="btn btn-default" value="delete" id="group-delete"/> </td>
					</tr>
				</table>
				</form>
				</li>
			</c:forEach>
			</ul>
			<div class="group-btn-group">
				<button class="btn-default btn" id="group-add" onclick="addGroup()">add group</button>
			</div>
		</div>
		<div class="group-member-list">
			<table class="table table-hover">
			<thead>
				<tr>
					<th>group member id</th>
					<th>group member name</th>
					<th>delete</th>
				</tr>
			</thead>
			<tbody id="groupMemberList">

			</tbody>
			</table>
			<div class="group-btn-group">
				<button class="btn-default btn" id="group-member-add" onclick="addGroupMember()" disabled>add group member</button>
			</div>
		</div>
	</div>
</body>
</html>