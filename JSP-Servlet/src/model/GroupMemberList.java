package model;

import java.util.*;

public class GroupMemberList {
	private ArrayList<GroupMember> groupMemberList;
	
	public GroupMemberList(ArrayList<GroupMember> groupMemberList) {
		this.groupMemberList = groupMemberList;
	}
	
	public GroupMemberList(String id, String name) {
		this.groupMemberList = new ArrayList<GroupMember>();
		this.addGroupMember(new GroupMember(id, name));
	}
	
	public GroupMemberList(GroupMember groupMember) {
		this.groupMemberList = new ArrayList<GroupMember>();
		this.addGroupMember(groupMember);
	}
	
	public GroupMemberList() {
		this.groupMemberList = new ArrayList<GroupMember>();
	}
	
	public ArrayList<GroupMember> getGroupMemberList() {
		return this.groupMemberList;
	}
	
	public void setGroupMemberList(ArrayList<GroupMember> groupMemberList) {
		this.groupMemberList = groupMemberList;
	}
	
	public void addGroupMember(GroupMember groupMember) {
		this.groupMemberList.add(groupMember);
	}
	
	public void addGroupMember(String id, String name) {
		this.groupMemberList.add(new GroupMember(id, name));
	}
	
	public GroupMember searchGroupMember(int index) {
		if( index < 0 || index >= this.groupMemberList.size() ){
			return null;
		}
		
		return this.groupMemberList.get(index);
	}
	
	public GroupMember searchGroupMember(String id) {
		GroupMember res = null;
		
		for(GroupMember temp: this.groupMemberList){
			if( temp.getMemberId().equals(id) ){
				res = temp;
			}
		}
		
		return res;
	}
	
	public ArrayList<GroupMember> searchGroupMemberByName(String name) {
		ArrayList<GroupMember> res = new ArrayList<GroupMember>();
		
		for(GroupMember temp:this.groupMemberList){
			if( temp.getMemberName().equals(name) ){
				res.add(temp);
			}
		}
		
		return res;
	}
	
	public int removeGroupMember(int index) {
		if( index < 0 || index >= this.groupMemberList.size() ){
			return 0;
		}
		
		this.groupMemberList.remove(index);
		
		return 1;
	}
	
	public int removeGroupMember(String id) {
		ArrayList<Integer> removeIndex = new ArrayList<Integer>();
		GroupMember temp = null;
		
		for(int i=0; i<this.groupMemberList.size(); i++){
			temp = this.groupMemberList.get(i);
			
			if( temp.getMemberId().equals(id) ){
				removeIndex.add(new Integer(i));
			}
		}
		
		for(Integer tmp : removeIndex){
			this.groupMemberList.remove(tmp.intValue());
		}
		
		return removeIndex.size();
	}
	
	public int removeGroupMemberByName(String name) {
		ArrayList<Integer> removeIndex = new ArrayList<Integer>();
		GroupMember temp = null;
		
		for(int i=0; i<this.groupMemberList.size(); i++){
			temp = this.groupMemberList.get(i);
			
			if( temp.getMemberId().equals(name) ){
				removeIndex.add(new Integer(i));
			}
		}
		
		for(Integer tmp : removeIndex){
			this.groupMemberList.remove(tmp.intValue());
		}
		
		return removeIndex.size();
	}
	
	public void modifyGroupMember(int index, String id, String name) {
		if( index < 0 || index >= this.groupMemberList.size() ){
			return ;
		}
		
		GroupMember temp = this.groupMemberList.get(index);
		
		temp.setMemberId(id);
		temp.setMemberName(name);
		
		return ;
	}
	
	public void modifyGroupMemberId(int index, String id) {
		if( index < 0 || index >= this.groupMemberList.size() ){
			return ;
		}
		
		GroupMember temp = this.groupMemberList.get(index);
		
		temp.setMemberId(id);
		
		return ;
	}
	
	public void modifyGroupMemberName(int index, String name) {
		if( index < 0 || index >= this.groupMemberList.size() ){
			return ;
		}
		
		GroupMember temp = this.groupMemberList.get(index);
		
		temp.setMemberName(name);
		
		return ;
	}
	
	public void modifyGroupMemberId(String id, String newId) {
		GroupMember temp = this.searchGroupMember(id);
		
		temp.setMemberId(newId);
		
		return ;
	}
	
	public void modifyGroupMemberName(String id, String newName) {
		GroupMember temp = this.searchGroupMember(id);
		
		temp.setMemberName(newName);
		
		return ;
	}
}
