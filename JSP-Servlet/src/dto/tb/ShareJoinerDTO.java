package dto.tb;

public class ShareJoinerDTO {
	private int shareCode;
	private int fileCode;
	private int joinerCode;
	public ShareJoinerDTO(int shareCode, int fileCode, int joinerCode) {
		this.shareCode = shareCode;
		this.fileCode = fileCode;
		this.joinerCode = joinerCode;
	}
	public ShareJoinerDTO() {
		this.shareCode=0;
		this.fileCode=0;
		this.joinerCode = 0;
	}
	public int getShareCode() {
		return shareCode;
	}
	public void setShareCode(int shareCode) {
		this.shareCode = shareCode;
	}
	public int getFileCode() {
		return fileCode;
	}
	public void setFileCode(int fileCode) {
		this.fileCode = fileCode;
	}
	public int getJoinerCode() {
		return joinerCode;
	}
	public void setJoinerCode(int joinerCode) {
		this.joinerCode = joinerCode;
	}
	@Override
	public String toString() {
		return "ShareJoinerDTO [shareCode=" + shareCode + ", fileCode="
				+ fileCode + ", joinerCode=" + joinerCode + "]";
	}
	
	
}
