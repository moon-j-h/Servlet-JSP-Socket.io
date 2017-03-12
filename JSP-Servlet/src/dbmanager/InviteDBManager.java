package dbmanager;

import java.util.ArrayList;
import java.util.List;

import model.InviteInfo;
import dao.tb.InviteDAO;
import dao.tb.MemberDAO;
import dao.tb.ShareJoinerDAO;
import dao.view.InviteInfoDAO;
import dto.tb.InviteDTO;
import dto.tb.MemberDTO;
import dto.tb.ShareJoinerDTO;
import dto.view.InviteInfoDTO;

public class InviteDBManager {
	private InviteDAO inviteDAO;
	private InviteInfoDAO inviteInfoDAO;
	private ShareJoinerDAO shareJoinerDAO;
	
	public InviteDBManager(){
		this.inviteDAO = new InviteDAO();
		this.inviteInfoDAO = new InviteInfoDAO();
		this.shareJoinerDAO = new ShareJoinerDAO();
	}
	
	public InviteDBManager(InviteDAO inviteDAO) {
		this.inviteDAO = inviteDAO;
		this.inviteInfoDAO = new InviteInfoDAO();
		this.shareJoinerDAO = new ShareJoinerDAO();
	}
	
	public InviteDBManager(InviteInfoDAO inviteInfoDAO) {
		this.inviteDAO = new InviteDAO();
		this.inviteInfoDAO = inviteInfoDAO;
		this.shareJoinerDAO = new ShareJoinerDAO();
	}
	
	public InviteDBManager(ShareJoinerDAO shareJoinerDAO) {
		this.inviteDAO = new InviteDAO();
		this.inviteInfoDAO = new InviteInfoDAO();
		this.shareJoinerDAO = shareJoinerDAO;
	}
	
	public InviteDBManager(InviteDAO inviteDAO, InviteInfoDAO inviteInfoDAO,ShareJoinerDAO shareJoinerDAO) {
		this.inviteDAO = inviteDAO;
		this.inviteInfoDAO = inviteInfoDAO;
		this.shareJoinerDAO = shareJoinerDAO;
	}

	public InviteDAO getInviteDAO() {
		return inviteDAO;
	}

	public void setInviteDAO(InviteDAO inviteDAO) {
		this.inviteDAO = inviteDAO;
	}

	public InviteInfoDAO getInviteInfoDAO() {
		return inviteInfoDAO;
	}

	public void setInviteInfoDAO(InviteInfoDAO inviteInfoDAO) {
		this.inviteInfoDAO = inviteInfoDAO;
	}

	public ShareJoinerDAO getShareJoinerDAO() {
		return shareJoinerDAO;
	}

	public void setShareJoinerDAO(ShareJoinerDAO shareJoinerDAO) {
		this.shareJoinerDAO = shareJoinerDAO;
	}
	
	public ArrayList<InviteInfo> selectInviteList(String memberId){
		int guestCode = new MemberDBManager().selectMemberCode(memberId);
		
		List<InviteInfoDTO> list = this.inviteInfoDAO.selectInviteInfo(guestCode);
		
		ArrayList<InviteInfo> inviteInfos = new ArrayList<InviteInfo>();

		for (InviteInfoDTO temp : list) {
			if( this.inviteDAO.selectInvite(temp.getInviteCode()).getInviteState().trim().equals("ACTIVE") ){
				inviteInfos.add(new InviteInfo(Integer.toString(temp.getInviteCode()).trim(), temp.getHostId(), temp.getHostName(), memberId, temp.getInviteDate(), temp.getInviteLink()));
			}
		}
		
		return inviteInfos;
	}
	
	private boolean checkInviteCode(int inviteCode){
		InviteDTO temp = this.inviteDAO.selectInvite(inviteCode);
		
		if( temp == null ){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean insertInvite(String fileCode, String link, ArrayList<String> receiverIdList){
		int randomCode = 0;
		
		MemberDBManager mdbm = new MemberDBManager();
		int guestCode = 0;
		
		for(String temp : receiverIdList){
			guestCode = mdbm.selectMemberCode(temp);
			
			while(true){
				randomCode = (int) (Math.random()*100000000);
				
				if( this.checkInviteCode(randomCode) ){ 
					break;
				}
			}
			
			this.inviteDAO.insertInvite(new InviteDTO(randomCode, Integer.parseInt(fileCode.trim()), guestCode, link, "ACTIVE"));
		}
		
		return true;
	}
	
	private boolean checkShareCode(int shareCode){
		ShareJoinerDTO temp = this.shareJoinerDAO.selectShareJoiner(shareCode);
		
		if( temp == null ){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean insertShareJoiner(String fileCode, String joinerId){
		int randomCode = 0;
		
		while(true){
			randomCode = (int) (Math.random()*100000000);
			
			if( this.checkShareCode(randomCode) ){ 
				break;
			}
		}
		
		int joinerCode = new MemberDBManager().selectMemberCode(joinerId);
		
		this.shareJoinerDAO.insertShareJoiner(new ShareJoinerDTO(randomCode, Integer.parseInt(fileCode.trim()), joinerCode));
		
		return true;
	}
	
	public String acceptInvite(String inviteCode){
		InviteDTO inviteDTO = this.inviteDAO.selectInvite(Integer.parseInt(inviteCode.trim()));
		
		MemberDBManager mdbm = new MemberDBManager();
		
		MemberDTO memberDTO = mdbm.getMemberDAO().selectActiveMember(inviteDTO.getGuestCode());
		
		this.insertShareJoiner(Integer.toString(inviteDTO.getFileCode()), memberDTO.getMemberId());
		//this.inviteDAO.updateInviteStateToInactive(Integer.parseInt(inviteCode.trim()));
		//Inactive는 끝날 때 시켜줘야하지 않나? 나왔다가 다시 들어갈 수도 있자나?
		
		return inviteDTO.getInviteLink();
	}
	
	public ArrayList<InviteInfo> refuseInvite(String inviteCode){
		InviteDTO idto = this.inviteDAO.selectInvite(Integer.parseInt(inviteCode.trim()));
		//this.inviteDAO.deleteInvite(idto.getInviteCode());
		this.inviteDAO.updateInviteStateToInactive(Integer.parseInt(inviteCode.trim()));
		
		MemberDTO mdto = new MemberDAO().selectMember(idto.getGuestCode());
		
		ArrayList<InviteInfo> inviteList = this.selectInviteList(mdto.getMemberId());
		
		return inviteList;
	}
}
