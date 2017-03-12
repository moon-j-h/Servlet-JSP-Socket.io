package manager;

import java.util.ArrayList;

import model.InviteInfo;
import dbmanager.InviteDBManager;

public class InviteManager {
	public InviteManager(){
		
	}
	
	public ArrayList<InviteInfo> watchInvite(String id){
		return new InviteDBManager().selectInviteList(id);
	}
	
	public String acceptInvite(String inviteCode){
		return new InviteDBManager().acceptInvite(inviteCode);
	}
	
	public ArrayList<InviteInfo> refuseInvite(String inviteCode){
		return new InviteDBManager().refuseInvite(inviteCode);
	}
}
