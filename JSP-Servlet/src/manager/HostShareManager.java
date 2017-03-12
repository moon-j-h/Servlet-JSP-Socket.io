package manager;

import java.util.*;
import model.*;
import dbmanager.*;

public class HostShareManager {
	public HostShareManager(){

	}
	
	public String saveFile(String hostId, FileInfo fileInfo){
		return new ShareDBManager().saveFile(hostId, fileInfo);
	}
	
	public GroupInfoList watchGroup(String memberId){
		GroupManager gm = new GroupManager();
		
		GroupInfoList groupList = gm.watchGroup(memberId);
		
		return groupList;
	}
	
	public String startShare(String hostId, ArrayList<String> inviteList, String fileCode){
		InviteDBManager idm = new InviteDBManager();
		
		MemberDBManager mdbm = new MemberDBManager();
		
		//link 일단은 "hostMemberCode-fileCode"로 했음
		String link = Integer.toString(mdbm.selectMemberCode(hostId)) + "-" + fileCode.trim();
		boolean first = idm.insertInvite(fileCode, link, inviteList);
		
		ShareDBManager sdbm = new ShareDBManager();
		boolean second = sdbm.insertShareJoiner(fileCode, hostId);
		
		if( first && second ){
			return link;
		}
		
		return "ShareFault";
	}
}
