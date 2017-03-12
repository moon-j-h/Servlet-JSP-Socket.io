package model;

public class GroupInfo {
	private String groupCode;
	private String groupName;
	private GroupMemberList groupMemberList;
	public GroupInfo(String groupCode, String groupName, GroupMemberList groupMemberList) {
		this.groupCode = groupCode;
		this.groupName = groupName;
		this.groupMemberList = groupMemberList;
	}
	
	public GroupInfo(String groupCode, String groupName, String id, String name) {
		this.groupCode = groupCode;
		this.groupName = groupName;
		this.groupMemberList = new GroupMemberList(id, name);
	}
	
	public GroupInfo(String groupCode, String groupName, GroupMember groupMember) {
		this.groupCode = groupCode;
		this.groupName = groupName;
		this.groupMemberList = new GroupMemberList(groupMember);
	}
	
	public GroupInfo(String groupCode, String groupName) {
		this.groupCode = groupCode;
		this.groupName = groupName;
		this.groupMemberList = new GroupMemberList();
	}
	
	public GroupInfo(String groupCode) {
		this.groupCode = groupCode;
		this.groupName = "";
		this.groupMemberList = new GroupMemberList();
	}
	
	public GroupInfo() {
		this.groupCode = "";
		this.groupName = "";
		this.groupMemberList = new GroupMemberList();
	}
	
	public String getGroupCode() {
		return this.groupCode;
	}
	
	public String getGroupName() {
		return this.groupName;
	}
	
	public GroupMemberList getGroupMemberList() {
		return this.groupMemberList;
	}
	
	public void setGoupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public void setGroupMemberList(GroupMemberList groupMemberList) {
		this.groupMemberList = groupMemberList;
	}
	public int getSize(){
		return this.groupMemberList.getGroupMemberList().size();
	}
}
