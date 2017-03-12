package dto.tb;

public class MemberDTO {
	private int memberCode;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberState;
	public MemberDTO(int memberCode, String memberId, String memberPw,
			String memberName) {
		this.memberCode = memberCode;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberState = "ACTIVE";
	}
	
	public MemberDTO(int memberCode, String memberId, String memberPw,
			String memberName, String memberState) {
		this.memberCode = memberCode;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberState = memberState;
	}

	public MemberDTO() {
		this.memberCode = 0;
		this.memberId="";
		this.memberPw="";
		this.memberName="";
		this.memberState="";
	}
	public int getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberState() {
		return memberState;
	}

	public void setMemberState(String memberState) {
		this.memberState = memberState;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberCode=" + memberCode + ", memberId=" + memberId
				+ ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberState=" + memberState + "]";
	}
	
	
	
}
