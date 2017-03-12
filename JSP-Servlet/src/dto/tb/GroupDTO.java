package dto.tb;

public class GroupDTO {
	private int groupCode;
	private int hostCode;
	private String groupName;
	public GroupDTO(int groupCode, int hostCode, String groupName) {
		this.groupCode = groupCode;
		this.hostCode = hostCode;
		this.groupName=groupName;
	}
	public GroupDTO() {
		this.groupCode=0;
		this.hostCode=0;
		this.groupName = "";
	}
	public int getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}
	public int getHostCode() {
		return hostCode;
	}
	public void setHostCode(int hostCode) {
		this.hostCode = hostCode;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@Override
	public String toString() {
		return "GroupDTO [groupCode=" + groupCode + ", hostCode=" + hostCode
				+ ", groupName=" + groupName + "]";
	}
	
}
