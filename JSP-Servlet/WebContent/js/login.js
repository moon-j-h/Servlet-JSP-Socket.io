/**
 * 로그인 자바스크립트
 */
function validateForm(){
	var id = $.trim(document.forms["login-form"]["id"].value);
	var pw = $.trim(document.forms["login-form"]["pw"].value);
	
	if(id == "" || id == null){
		alert("Email을 입력 해주세요.");
		return false;
	}else if(pw == "" || pw == null){
		alert("비밀번호를 입력 해주세요.");
		return false;
	}
	var atpos = id.indexOf("@");
	var dotpos = id.indexOf(".");
	
	if(atpos<1 || dotpos<atpos+2 || dotpos+2 >= email.length){
		alert("유효한 Email주소가 아닙니다.");
		return false;
	}
	var pwLen = pw.length;
	alert(pwLen);
	if(pwLen <=7 || pwLen >=13){
		alert("비밀번호는 8자리 이상 12자리 이하입니다.");
		return false;
	}
}