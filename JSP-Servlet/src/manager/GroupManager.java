package manager;

import model.*;
import dbmanager.*;

public class GroupManager {
	public GroupManager(){
		
	}
	
	public int createGroup(String memberId, String groupName){
		return new GroupDBManager().insertGroup(memberId, groupName);
	}
	
	public GroupInfoList deleteGroup(String groupCode){
		return new GroupDBManager().deleteGroup(groupCode);
	}
	
	public GroupMemberList addGroupMember(String groupCode, String memberId){
		return new GroupDBManager().insertGroupMember(groupCode, memberId);
	}
	
	public GroupMemberList deleteGroupMember(String groupCode, String memberId){
		return new GroupDBManager().deleteGroupMember(groupCode, memberId);
	}
	
	public GroupInfoList watchGroup(String memberId){
		return new GroupDBManager().selectGroup(memberId);
	}
	
	public GroupMemberList watchGroupMember(String groupCode){
		return new GroupDBManager().selectGroupMember(groupCode);
	}
}