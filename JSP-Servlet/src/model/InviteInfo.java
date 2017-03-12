package model;

public class InviteInfo {
	private String inviteCode;
	private String inviteSenderId;
	private String inviteSenderName;
	private String inviteReceiverId;
	private String inviteDate;
	private String link;
	
	public InviteInfo(){
		this.inviteCode = "";
		this.inviteSenderId = "";
		this.inviteSenderName = "";
		this.inviteReceiverId = "";
		this.inviteDate = "";
		this.link = "";
	}
	
	public InviteInfo(String inviteCode, String inviteSenderId, String inviteSenderName, String inviteReceiverId, String inviteDate, String link) {
		this.inviteCode = inviteCode;
		this.inviteSenderId = inviteSenderId;
		this.inviteSenderName = inviteSenderName;
		this.inviteReceiverId = inviteReceiverId;
		this.inviteDate = inviteDate;
		this.link = link;
	}
	
	/*public InviteInfo(String inviteCode, String inviteSenderId, String inviteReceiverId, String inviteDate, String link) {
		this.inviteCode = inviteCode;
		this.inviteSenderId = inviteSenderId;
		this.inviteReceiverId = inviteReceiverId;
		this.inviteDate = inviteDate;
		this.link = link;
	}*/

	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	public String getInviteSenderId() {
		return inviteSenderId;
	}

	public void setInviteSenderId(String inviteSenderId) {
		this.inviteSenderId = inviteSenderId;
	}

	public String getInviteSenderName() {
		return inviteSenderName;
	}

	public void setInviteSenderName(String inviteSenderName) {
		this.inviteSenderName = inviteSenderName;
	}

	public String getInviteReceiverId() {
		return inviteReceiverId;
	}

	public void setInviteReceiverId(String inviteReceiverId) {
		this.inviteReceiverId = inviteReceiverId;
	}

	public String getInviteDate() {
		return inviteDate;
	}

	public void setInviteDate(String inviteDate) {
		this.inviteDate = inviteDate;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
