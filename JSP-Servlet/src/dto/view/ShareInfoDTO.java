package dto.view;

public class ShareInfoDTO {
	private int joinerCode;
	private String hostId;
	private String hostName;
	private int fileCode;
	private String shareDate;
	public ShareInfoDTO(int joinerCode, String hostId, String hostName,
			int fileCode, String shareDate) {
		this.joinerCode = joinerCode;
		this.hostId = hostId;
		this.hostName = hostName;
		this.fileCode = fileCode;
		this.shareDate = shareDate;
	}
	public ShareInfoDTO() {
		this.joinerCode=0;
		this.hostId="";
		this.hostName="";
		this.fileCode=0;
		this.shareDate="";
	}
	public int getJoinerCode() {
		return joinerCode;
	}
	public void setJoinerCode(int joinerCode) {
		this.joinerCode = joinerCode;
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
	public int getFileCode() {
		return fileCode;
	}
	public void setFileCode(int fileCode) {
		this.fileCode = fileCode;
	}
	public String getShareDate() {
		return shareDate;
	}
	public void setShareDate(String shareDate) {
		this.shareDate = shareDate;
	}
	@Override
	public String toString() {
		return "ShareInfoDTO [joinerCode=" + joinerCode + ", hostId=" + hostId
				+ ", hostName=" + hostName + ", fileCode=" + fileCode
				+ ", shareDate=" + shareDate + "]";
	}
	
}
