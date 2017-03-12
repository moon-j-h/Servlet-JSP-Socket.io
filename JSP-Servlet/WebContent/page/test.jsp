<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/bootstrap.css" rel="stylesheet" media="screen">
<script src='http://code.jquery.com/jquery-1.10.2.js'></script>
<script src="../js/bootstrap.min.js"></script>
<script>
	$("#page-view").carousel({
		interval: false
	})
</script>
</head>
<body>
	<form action="../connect_page.do" method="post">
		Email : <input type="text" name="id"/><br/>
		Name : <input type="text" name="name"/><br/>
		RoomNum : <input type="text" name="link"/><br/>
		<button type="submit">Go~</button>
		 
	</form>
</body>
</html>