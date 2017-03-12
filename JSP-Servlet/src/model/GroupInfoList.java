package model;

import java.util.*;

public class GroupInfoList {
	private String memberCode;
	private ArrayList<GroupInfo> groupInfoList;
	
	public GroupInfoList(String memberCode, ArrayList<GroupInfo> groupInfoList) {
		this.memberCode = memberCode;
		this.groupInfoList = groupInfoList;
	}
	
	public GroupInfoList(String memberCode, String groupCode, String groupName, ArrayList<GroupMember> groupMemberList) {
		this.memberCode = memberCode;
		this.groupInfoList = new ArrayList<GroupInfo>();
		this.addGroupInfo(new GroupInfo(groupCode, groupName, new GroupMemberList(groupMemberList)));
	}
	
	public GroupInfoList(String memberCode, String groupCode, String groupName, GroupMember groupMember) {
		this.memberCode = memberCode;
		this.groupInfoList = new ArrayList<GroupInfo>();
		this.addGroupInfo(new GroupInfo(groupCode, groupName, new GroupMemberList(groupMember)));
	}
	
	public GroupInfoList(String memberCode, String groupCode, String groupName, String id, String name) {
		this.memberCode = memberCode;
		this.groupInfoList = new ArrayList<GroupInfo>();
		this.addGroupInfo(new GroupInfo(groupCode, groupName, new GroupMemberList(id, name)));
	}
	
	public GroupInfoList(String memberCode, String groupCode, String groupName) {
		this.memberCode = memberCode;
		this.groupInfoList = new ArrayList<GroupInfo>();
		this.addGroupInfo(new GroupInfo(groupCode, groupName));
	}
	
	public GroupInfoList(String memberCode, String groupCode) {
		this.memberCode = memberCode;
		this.groupInfoList = new ArrayList<GroupInfo>();
		this.addGroupInfo(new GroupInfo(groupCode));
	}
	
	public GroupInfoList() {
		this.memberCode = "";
		this.groupInfoList = new ArrayList<GroupInfo>();
	}
	
	public String getMemberCode() {
		return this.memberCode;
	}
	
	public ArrayList<GroupInfo> getGroupInfoList() {
		return this.groupInfoList;
	}
	
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	
	public void setGroupInfoList(ArrayList<GroupInfo> groupInfoList) {
		this.groupInfoList = groupInfoList;
	}
	
	public void addGroupInfo(GroupInfo groupInfo) {
		this.groupInfoList.add(groupInfo);
	}
	
	public void addGroupInfo(String groupCode, String groupName, GroupMemberList groupMemberList) {
		this.groupInfoList.add(new GroupInfo(groupCode, groupName, groupMemberList));
	}
	
	public void addGroupInfo(String groupCode, String groupName, String id, String name) {
		this.groupInfoList.add(new GroupInfo(groupCode, groupName, new GroupMemberList(id, name)));
	}
	
	public void addGroupInfo(String groupCode, String groupName, GroupMember groupMember) {
		this.groupInfoList.add(new GroupInfo(groupCode, groupName, new GroupMemberList(groupMember)));
	}
	
	public void addGroupInfo(String groupCode, String groupName) {
		this.groupInfoList.add(new GroupInfo(groupCode, groupName));	
	}
	
	public void addGroupInfo(String groupCode) {
		this.groupInfoList.add(new GroupInfo(groupCode));
	}
	
	public GroupInfo searchGroupInfo(int index) {
		if( index < 0 || index >= this.groupInfoList.size() ){
			return null;
		}
		
		return this.groupInfoList.get(index);
	}
	
	public GroupInfo searchGroupInfo(String groupCode) {
		GroupInfo res = null;
		
		for(GroupInfo temp: this.groupInfoList){
			if( temp.getGroupCode().equals(groupCode) ){
				res = temp;
			}
		}
		
		return res;
	}
	
	public GroupInfo searchGroupInfoByName(String groupName) {
		GroupInfo res = null;
		
		for(GroupInfo temp: this.groupInfoList){
			if( temp.getGroupName().equals(groupName) ){
				res  = temp;
			}
		}
		
		return res;
	}
	
	public int removeGroupInfo(int index) {
		if( index < 0 || index >= this.groupInfoList.size() ){
			return 0;
		}
		
		this.groupInfoList.remove(index);
		
		return 1;
	}
	
	public int removeGroupInfo(String groupCode) {
		ArrayList<Integer> removeIndex = new ArrayList<Integer>();
		GroupInfo temp = null;
		
		for(int i=0; i<this.groupInfoList.size(); i++){
			temp = this.groupInfoList.get(i);
			
			if( temp.getGroupCode().equals(groupCode) ){
				removeIndex.add(new Integer(i));
			}
		}
		
		for(Integer tmp : removeIndex){
			this.groupInfoList.remove(tmp.intValue());
		}
		
		return removeIndex.size();
	}
	
	public int removeGroupInfoByName(String groupName) {
		ArrayList<Integer> removeIndex = new ArrayList<Integer>();
		GroupInfo temp = null;
		
		for(int i=0; i<this.groupInfoList.size(); i++){
			temp = this.groupInfoList.get(i);
			
			if( temp.getGroupCode().equals(groupName) ){
				removeIndex.add(new Integer(i));
			}
		}
		
		for(Integer tmp : removeIndex){
			this.groupInfoList.remove(tmp.intValue());
		}
		
		return removeIndex.size();
	}
	
	public void modifyGroupInfo(int index, GroupInfo groupInfo) {
		if( index < 0 || index >= this.groupInfoList.size() ){
			return ;
		}
		
		GroupInfo temp = this.groupInfoList.get(index); 
		
		temp.setGoupCode(groupInfo.getGroupCode());
		temp.setGroupMemberList(groupInfo.getGroupMemberList());
		temp.setGroupName(groupInfo.getGroupName());
	}
	
	public void modifyGroupInfo(String groupCode, GroupInfo groupInfo) {
		GroupInfo temp = this.searchGroupInfo(groupCode);
		
		if(temp == null){
			return ;
		}
		
		temp.setGoupCode(groupInfo.getGroupCode());
		temp.setGroupMemberList(groupInfo.getGroupMemberList());
		temp.setGroupName(groupInfo.getGroupName());
	}
	
	public void modifyGroupInfoByName(String groupName, GroupInfo groupInfo) {
		GroupInfo temp = this.searchGroupInfoByName(groupName);
		
		if(temp == null){
			return ;
		}
		
		temp.setGoupCode(groupInfo.getGroupCode());
		temp.setGroupMemberList(groupInfo.getGroupMemberList());
		temp.setGroupName(groupInfo.getGroupName());
	}
	
	public void modifyGroupName(int index, String groupName) {
		if( index < 0 || index >= this.groupInfoList.size() ){
			return ;
		}
		
		GroupInfo temp = this.groupInfoList.get(index); 
		
		temp.setGroupName(groupName);
	}
	
	public void modifyGroupName(String groupCode, String groupName) {
		GroupInfo temp = this.searchGroupInfo(groupCode);
		
		if(temp == null){
			return ;
		}
		
		temp.setGroupName(groupName);
	}
	
	public void modifyGroupNameByName(String groupName, String newGroupName) {
		GroupInfo temp = this.searchGroupInfoByName(groupName);
		
		if(temp == null){
			return ;
		}
		
		temp.setGroupName(newGroupName);
	}
}
