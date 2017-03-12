package dto.view;

public class InviteInfoDTO {
	private int guestCode;
	private String hostId;
	private String hostName;
	private int inviteCode;
	private String inviteLink;
	private String inviteDate;
	private String inviteState;
	public InviteInfoDTO(int guestCode, String hostId, String hostName,
			int inviteCode, String inviteLink, String inviteDate, String inviteState) {
		this.guestCode = guestCode;
		this.hostId = hostId;
		this.hostName = hostName;
		this.inviteCode = inviteCode;
		this.inviteLink = inviteLink;
		this.inviteDate = inviteDate;
		this.inviteState = inviteState;
	}
	public InviteInfoDTO() {
		this.guestCode=0;
		this.hostId="";
		this.hostName="";
		this.inviteCode=0;
		this.inviteLink="";
		this.inviteDate="";
		this.inviteState="";
	}
	public int getGuestCode() {
		return guestCode;
	}
	public void setGuestCode(int guestCode) {
		this.guestCode = guestCode;
	}
	public String getHostId() {
		return hostId;
	}
	public void setHostId(String hostId) {
		this.hostId = hostId;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public int getInviteCode() {
		return inviteCode;
	}
	public void setInviteCode(int inviteCode) {
		this.inviteCode = inviteCode;
	}
	public String getInviteLink() {
		return inviteLink;
	}
	public void setInviteLink(String inviteLink) {
		this.inviteLink = inviteLink;
	}
	public String getInviteDate() {
		return inviteDate;
	}
	public void setInviteDate(String inviteDate) {
		this.inviteDate = inviteDate;
	}
	public String getInviteState() {
		return inviteState;
	}
	public void setInviteState(String inviteState) {
		this.inviteState = inviteState;
	}
	@Override
	public String toString() {
		return "InviteInfoDTO [guestCode=" + guestCode + ", hostId=" + hostId
				+ ", hostName=" + hostName + ", inviteCode=" + inviteCode
				+ ", inviteLink=" + inviteLink + ", inviteDate=" + inviteDate
				+ ", inviteState=" + inviteState + "]";
	}
	
	
}
