package dto.tb;

public class GroupMemberDTO {
	private int groupMemberCode;
	private int groupCode;
	private int memberCode;
	
	public GroupMemberDTO() {
		this.groupMemberCode=0;
		this.groupCode=0;
		this.memberCode=0;
	}
	public GroupMemberDTO(int groupMemberCode, int groupCode, int memberCode) {
		this.groupMemberCode = groupMemberCode;
		this.groupCode = groupCode;
		this.memberCode = memberCode;
	}
	public int getGroupMemberCode() {
		return groupMemberCode;
	}
	public void setGroupMemberCode(int groupMemberCode) {
		this.groupMemberCode = groupMemberCode;
	}
	public int getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}
	public int getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}
	@Override
	public String toString() {
		return "GroupMemberDTO [groupMemberCode=" + groupMemberCode
				+ ", groupCode=" + groupCode + ", memberCode=" + memberCode
				+ "]";
	}
	
	
}
