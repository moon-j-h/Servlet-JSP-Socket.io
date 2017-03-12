package dto.tb;

public class FileDTO {
	private int fileCode;
	private int hostCode;
	private String fileAddress;
	private String fileName;
	private String fileUploadDate;
	public FileDTO(int fileCode, int hostCode, String fileAddress,
			String fileName, String fileUploadDate) {
		this.fileCode = fileCode;
		this.hostCode = hostCode;
		this.fileAddress = fileAddress;
		this.fileName = fileName;
		this.fileUploadDate = fileUploadDate;
	}
	
	public FileDTO(int fileCode, int hostCode, String fileAddress,
			String fileName) {
		this.fileCode = fileCode;
		this.hostCode = hostCode;
		this.fileAddress = fileAddress;
		this.fileName = fileName;
	}

	public FileDTO() {
		this.fileCode=0;
		this.hostCode=0;
		this.fileAddress="";
		this.fileName="";
		this.fileUploadDate="";
	}
	public int getFileCode() {
		return fileCode;
	}
	public void setFileCode(int fileCode) {
		this.fileCode = fileCode;
	}
	public int getHostCode() {
		return hostCode;
	}
	public void setHostCode(int hostCode) {
		this.hostCode = hostCode;
	}
	public String getFileAddress() {
		return fileAddress;
	}
	public void setFileAddress(String fileAddress) {
		this.fileAddress = fileAddress;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUploadDate() {
		return fileUploadDate;
	}
	public void setFileUploadDate(String fileUploadDate) {
		this.fileUploadDate = fileUploadDate;
	}
	@Override
	public String toString() {
		return "FileDTO [fileCode=" + fileCode + ", hostCode=" + hostCode
				+ ", fileAddress=" + fileAddress + ", fileName=" + fileName
				+ ", fileUploadDate=" + fileUploadDate + "]";
	}
	
}
