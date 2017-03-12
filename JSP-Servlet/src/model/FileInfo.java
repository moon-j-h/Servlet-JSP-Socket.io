package model;

import java.io.Serializable;

/**
 * 
 * @author ¹®Á¤Çö
 *
 */
public class FileInfo  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3099873090678264601L;
	private String fileCode;
	private String fileAddress;
	private String fileName;
	private String fileForm;
	private double fileSize;
	public FileInfo(String fileCode, String fileAddress, String fileName,
			String fileForm, double fileSize) {
		this.fileCode = fileCode;
		this.fileAddress = fileAddress;
		this.fileName = fileName;
		this.fileForm = fileForm;
		this.fileSize = fileSize;
	}
	
	public FileInfo(String fileCode) {
		this.fileCode = fileCode;
		this.fileAddress = "";
		this.fileName = "";
		this.fileForm = "";
		this.fileSize = 0;
	}

	public FileInfo(String fileCode, String fileName, String fileForm,
			double fileSize) {
		this.fileCode = fileCode;
		this.fileAddress = "";
		this.fileName = fileName;
		this.fileForm = fileForm;
		this.fileSize = fileSize;
	}
	public FileInfo() {
		this.fileCode = "";
		this.fileAddress = "";
		this.fileName = "";
		this.fileForm = "";
		this.fileSize = 0;
	}
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
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
	public String getFileForm() {
		return fileForm;
	}
	public void setFileForm(String fileForm) {
		this.fileForm = fileForm;
	}
	public double getFileSize() {
		return fileSize;
	}
	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}
	@Override
	public String toString() {
		return "FileInfo [fileCode=" + fileCode + ", fileAddress="
				+ fileAddress + ", fileName=" + fileName + ", fileForm="
				+ fileForm + ", fileSize=" + fileSize + "]";
	}
	
	
}
