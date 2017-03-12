package dbmanager;

import java.util.*;

import dao.view.*;
import dao.tb.*;
import dto.tb.GroupDTO;
import dto.tb.GroupMemberDTO;
import dto.tb.MemberDTO;
import dto.view.GroupInfoDTO;
import model.*;

public class GroupDBManager {
	private GroupMemberDAO groupMemberDAO;
	private GroupDAO groupDAO;
	private GroupInfoDAO groupInfoDAO;
	
	public GroupDBManager(GroupMemberDAO groupMemberDAO, GroupDAO groupDAO, GroupInfoDAO groupInfoDAO){
		this.groupMemberDAO = groupMemberDAO;
		this.groupDAO = groupDAO;
		this.groupInfoDAO = groupInfoDAO;
	}
	
	public GroupDBManager(GroupMemberDAO groupMemberDAO){
		this.groupMemberDAO = groupMemberDAO;
		this.groupDAO = new GroupDAO();
		this.groupInfoDAO = new GroupInfoDAO();
	}
	
	public GroupDBManager(GroupDAO groupDAO){
		this.groupMemberDAO = new GroupMemberDAO();
		this.groupDAO = groupDAO;
		this.groupInfoDAO = new GroupInfoDAO();
	}
	
	public GroupDBManager(GroupInfoDAO groupInfoDAO){
		this.groupMemberDAO = new GroupMemberDAO();
		this.groupDAO = new GroupDAO();
		this.groupInfoDAO = groupInfoDAO;
	}
	
	public GroupDBManager(){
		this.groupMemberDAO = new GroupMemberDAO();
		this.groupDAO = new GroupDAO();
		this.groupInfoDAO = new GroupInfoDAO();
	}

	public GroupMemberDAO getGroupMemberDAO() {
		return groupMemberDAO;
	}

	public void setGroupMemberDAO(GroupMemberDAO groupMemberDAO) {
		this.groupMemberDAO = groupMemberDAO;
	}

	public GroupDAO getGroupDAO() {
		return groupDAO;
	}

	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}

	public GroupInfoDAO getGroupInfoDAO() {
		return groupInfoDAO;
	}

	public void setGroupInfoDAO(GroupInfoDAO groupInfoDAO) {
		this.groupInfoDAO = groupInfoDAO;
	}
	
	private boolean checkGroupCode(int groupCode){
		GroupDTO temp = this.groupDAO.selectGroup(groupCode);
		
		if( temp == null ){
			return true;
		}
		else{
			return false;
		}
	}
	
	public GroupInfoList selectGroup(String memberId){
		int memberCode = new MemberDBManager().selectMemberCode(memberId);
		
		List<GroupInfoDTO> list = this.groupInfoDAO.selectGroupInfo(memberCode);
		
		ArrayList<GroupInfo> groupInfos = new ArrayList<GroupInfo>();
		ArrayList<GroupMember> groupMembers = new ArrayList<GroupMember>();

		if( list == null || list.size() == 0 ){
			return null;
		}
		else if(list.size() == 1){
			if (!list.get(0).getMemberId().equals(memberId)) {
				groupMembers.add(new GroupMember(list.get(0)
						.getMemberId(), list.get(0).getMemberName()));
			}
			groupInfos.add(new GroupInfo(Integer.toString(list.get(0).getGroupCode()).trim(), list.get(0).getGroupName(), new GroupMemberList(groupMembers)));
		}
		else {
			if (!list.get(0).getMemberId().equals(memberId)) {
				groupMembers.add(new GroupMember(list.get(0)
						.getMemberId(), list.get(0).getMemberName()));
			}
			
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i).getGroupCode() == list.get(i - 1)
						.getGroupCode()) {
					if (!list.get(i).getMemberId().equals(memberId)) {
						groupMembers.add(new GroupMember(list.get(i)
								.getMemberId(), list.get(i).getMemberName()));
					}
				} else {
					groupInfos.add(new GroupInfo(Integer.toString(
							list.get(i - 1).getGroupCode()).trim(), list.get(
							i - 1).getGroupName(), new GroupMemberList(
							groupMembers)));

					groupMembers = new ArrayList<GroupMember>();
					if (!list.get(i).getMemberId().equals(memberId)) {
						groupMembers.add(new GroupMember(list.get(i)
								.getMemberId(), list.get(i).getMemberName()));
					}
				}

				if (i == (list.size() - 1)) {
					groupInfos
							.add(new GroupInfo(Integer.toString(
									list.get(i).getGroupCode()).trim(), list
									.get(i).getGroupName(),
									new GroupMemberList(groupMembers)));
				}
			}
		}
		
		return new GroupInfoList(Integer.toString(memberCode), groupInfos);
	}
	
	public GroupInfoList selectGroup(int memberCode){		
		List<GroupInfoDTO> list = this.groupInfoDAO.selectGroupInfo(memberCode);
		
		ArrayList<GroupInfo> groupInfos = new ArrayList<GroupInfo>();
		ArrayList<GroupMember> groupMembers = new ArrayList<GroupMember>();

		MemberDBManager mdbm = new MemberDBManager();

		MemberDTO mdto = mdbm.getMemberDAO().selectActiveMember(memberCode);
		
		if( list == null || list.size() == 0 ){
			return null;
		}
		else if(list.size() == 1){
			if (!list.get(0).getMemberId().equals(mdto.getMemberId())) {
				groupMembers.add(new GroupMember(list.get(0)
						.getMemberId(), list.get(0).getMemberName()));
			}
			groupInfos.add(new GroupInfo(Integer.toString(list.get(0).getGroupCode()).trim(), list.get(0).getGroupName(), new GroupMemberList(groupMembers)));
		}
		else {
			if (!list.get(0).getMemberId().equals(mdto.getMemberId())) {
				groupMembers.add(new GroupMember(list.get(0)
						.getMemberId(), list.get(0).getMemberName()));
			}
			
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i).getGroupCode() == list.get(i - 1)
						.getGroupCode()) {
					if (!list.get(i).getMemberId().equals(mdto.getMemberId())) {
						groupMembers.add(new GroupMember(list.get(i)
								.getMemberId(), list.get(i).getMemberName()));
					}
				} else {
					groupInfos.add(new GroupInfo(Integer.toString(
							list.get(i - 1).getGroupCode()).trim(), list.get(
							i - 1).getGroupName(), new GroupMemberList(
							groupMembers)));

					groupMembers = new ArrayList<GroupMember>();
					if (!list.get(i).getMemberId().equals(mdto.getMemberId())) {
						groupMembers.add(new GroupMember(list.get(i)
								.getMemberId(), list.get(i).getMemberName()));
					}
				}

				if (i == (list.size() - 1)) {
					groupInfos
							.add(new GroupInfo(Integer.toString(
									list.get(i).getGroupCode()).trim(), list
									.get(i).getGroupName(),
									new GroupMemberList(groupMembers)));
				}
			}
		}

		return new GroupInfoList(Integer.toString(memberCode), groupInfos);
	}
	
	public GroupMemberList selectGroupMember(String groupCode){
		List<GroupMemberDTO> list = this.groupMemberDAO.selectGroupMembers(Integer.parseInt(groupCode));
		
		ArrayList<GroupMember> groupMembers = new ArrayList<GroupMember>();
		
		MemberDAO memberDAO = new MemberDAO();
		
		int memberCode = 0;
		MemberDTO member = null;
		
		for(GroupMemberDTO temp : list){
			memberCode = temp.getMemberCode();
					
			member = memberDAO.selectActiveMember(memberCode);
			
			groupMembers.add(new GroupMember(member.getMemberId(), member.getMemberName()));
		}
		
		return new GroupMemberList(groupMembers);
	}
	
	public int insertGroup(String memberId, String groupName){
		int randomCode = 0;
		
		while(true){
			randomCode = (int) (Math.random()*100000000);
			
			if( this.checkGroupCode(randomCode) ){
				break;
			}
		}
		
		int memberCode = new MemberDBManager().selectMemberCode(memberId);
		
		GroupDTO groupDTO = new GroupDTO(randomCode, memberCode, groupName);
		this.groupDAO.insertGroup(groupDTO);
		
		return randomCode;
	}
	
	public GroupInfoList deleteGroup(String groupCode){
		int hostCode = this.groupDAO.selectGroup(Integer.parseInt(groupCode)).getHostCode();
		
		this.groupMemberDAO.deleteGroupMembersByGroupCode(Integer.valueOf(groupCode));
		this.groupDAO.deleteGroup(Integer.parseInt(groupCode));
		
		return this.selectGroup(hostCode);
	}
	
	public GroupMemberList deleteGroupMember(String groupCode, String memberId) {
		int memberCode = new MemberDBManager().selectMemberCode(memberId);
		int groupMemberCode = this.groupMemberDAO.selectGroupMemberCode(Integer.parseInt(groupCode), memberCode);

		this.groupMemberDAO.deleteGroupMember(groupMemberCode);

		return this.selectGroupMember(groupCode);
	}
	
	
	public GroupMemberList insertGroupMember(String groupCode, String memberId){
		int randomCode = 0;
		
		while(true){
			randomCode = (int) (Math.random()*100000000);
			
			if( this.groupMemberDAO.selectGroupMember(randomCode) == null ){
				break;
			}
		}
		
		int memberCode = new MemberDBManager().selectMemberCode(memberId);
		
		if(memberCode == 0){
			return null;
		}
		
		GroupMemberDTO temp = new GroupMemberDTO(randomCode, Integer.parseInt(groupCode), memberCode);
		
		this.groupMemberDAO.insertGroupMember(temp);
		
		return this.selectGroupMember(groupCode);
	}
}
