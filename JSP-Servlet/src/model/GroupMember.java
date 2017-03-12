package model;

public class GroupMember {
	private String memberId;
	private String memberName;
	public GroupMember(String memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	public GroupMember() {
		this.memberId = "";
		this.memberName = "";
	}
	
	public String getMemberId() {
		return this.memberId;
	}
	
	public String getMemberName() {
		return this.memberName;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
}
