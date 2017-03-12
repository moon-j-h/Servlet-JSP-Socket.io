package dto.view;

public class GroupInfoDTO {
	private int hostCode;
	private int groupCode;
	private String groupName;
	private String memberId;
	private String memberName;
	public GroupInfoDTO(int hostCode, int groupCode, String groupName,
			String memberId, String memberName) {
		this.hostCode = hostCode;
		this.groupCode = groupCode;
		this.groupName = groupName;
		this.memberId = memberId;
		this.memberName = memberName;
	}
	public GroupInfoDTO() {
		this.hostCode=0;
		this.groupCode=0;
		this.groupName="";
		this.memberId="";
		this.memberName="";
	}
	public int getHostCode() {
		return hostCode;
	}
	public void setHostCode(int hostCode) {
		this.hostCode = hostCode;
	}
	public int getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return "GroupInfoDTO [hostCode=" + hostCode + ", groupCode="
				+ groupCode + ", groupName=" + groupName + ", memberId="
				+ memberId + ", memberName=" + memberName + "]";
	}
	
}
