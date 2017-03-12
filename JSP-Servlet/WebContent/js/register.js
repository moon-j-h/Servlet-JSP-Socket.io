/**
 * 회원 등록 화면에서 사용
 */
function validateForm(){
	//alert("check");
	var name = $.trim(document.forms["registerForm"]["name"].value);
	var email = $.trim(document.forms["registerForm"]["email"].value);
	var password = $.trim(document.forms["registerForm"]["password"].value);
	var confirm = $.trim(document.forms["registerForm"]["confirmPassword"].value);
	alert(name+", "+email+", "+password+", "+confirm);
	// 공백 문자열 체크
	if(name == null || name==""){
		alert("이름을 입력하세요.");
		return false;
	}
	else if(email == null || email == ""){
		alert("Email을 입력하세요.");
		return false;
	}else if(password == null || password ==""){
		alert("비밀번호를 입력하세요.");
		return false;
	}else if(confirm == null || confirm == ""){
		alert("비밀번호 확인을 입력하세요.");
		return false;
	}
	// email 형식 유효성 체크
	var atpos = email.indexOf("@");
	var dotpos = email.indexOf(".");
	if(atpos<1 || dotpos<atpos+2 || dotpos+2 >= email.length){
		alert("유효한 Email 주소가 아닙니다.");
		return false;
	}
	// 비밀번호 자리수 체크
	var pwLen = password.length;
	if(pwLen <=7 || pwLen >=13){
		alert("비밀번호는 8자리 이상 12자리 이하여야 합니다.");
		return false;
	}
	// 비밀번호 확인 유효성 체크
	if(password !== confirm){
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		return false;
	}
}