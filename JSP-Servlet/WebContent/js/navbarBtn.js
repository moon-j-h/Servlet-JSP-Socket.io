/**
 * navbar에 있는 버튼들의 이벤트 함수들
 */

// 로그아웃 시
 function logout(){ 
	 if(confirm("로그아웃 하시겠습니까?")){
		 window.location = "/DalGongFee"; // 로그인 화면으로
		}
 }
 // 비번 변경 요청 시 
 function changePw(){
	 window.location = "goToPwChange.do";  // 비번 변경
 }
 
 function exitPage(){
	 if(confirm("정말로 나가시겠습니까?")){
			window.location = "watch_share_page.do";
		}
 }