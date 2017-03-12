package dto.tb;

public class InviteDTO {
	private int inviteCode;
	private int fileCode;
	private int guestCode;
	private String inviteLink;
	private String inviteState;
	public InviteDTO(int inviteCode, int fileCode, int guestCode,
			String inviteLink, String inviteState) {
		this.inviteCode = inviteCode;
		this.fileCode = fileCode;
		this.guestCode = guestCode;
		this.inviteLink = inviteLink;
		this.inviteState = inviteState;
	}
	public InviteDTO() {
		this.inviteCode=0;
		this.fileCode=0;
		this.guestCode=0;
		this.inviteLink="";
		this.inviteState="";
	}
	public InviteDTO(int inviteCode, int fileCode, int guestCode,
			String inviteLink) {
		this.inviteCode = inviteCode;
		this.fileCode = fileCode;
		this.guestCode = guestCode;
		this.inviteLink = inviteLink;
		this.inviteState="ACTIVE";
	}
	public int getInviteCode() {
		return inviteCode;
	}
	public void setInviteCode(int inviteCode) {
		this.inviteCode = inviteCode;
	}
	public int getFileCode() {
		return fileCode;
	}
	public void setFileCode(int fileCode) {
		this.fileCode = fileCode;
	}
	public int getGuestCode() {
		return guestCode;
	}
	public void setGuestCode(int guestCode) {
		this.guestCode = guestCode;
	}
	public String getInviteLink() {
		return inviteLink;
	}
	public void setInviteLink(String inviteLink) {
		this.inviteLink = inviteLink;
	}
	public String getInviteState() {
		return inviteState;
	}
	public void setInviteState(String inviteState) {
		this.inviteState = inviteState;
	}
	@Override
	public String toString() {
		return "InviteDTO [inviteCode=" + inviteCode + ", fileCode=" + fileCode
				+ ", guestCode=" + guestCode + ", inviteLink=" + inviteLink
				+ ", inviteState=" + inviteState + "]";
	}
	
	
	
}
