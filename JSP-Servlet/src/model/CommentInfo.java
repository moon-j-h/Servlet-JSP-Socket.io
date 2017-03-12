package model;

import java.io.Serializable;

/**
 * 
 * @author ¹®Á¤Çö
 *
 */
public class CommentInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1697506671749644226L;
	private String parentCommentCode;
	private String commentCode;
	private String writerId;
	private String writerName;
	private String commentContent;
	private String writeDate;
	private String fileCode;
	private int pageNum;
	
	
	public CommentInfo(String parentCommentCode, String commentCode,
			String writerId, String writerName, String commentContent,
			String writeDate, String fileCode, int pageNum) {
		this.parentCommentCode = parentCommentCode;
		this.commentCode = commentCode;
		this.writerId = writerId;
		this.writerName = writerName;
		this.commentContent = commentContent;
		this.writeDate = writeDate;
		this.fileCode = fileCode;
		this.pageNum = pageNum;
	}
	
	public CommentInfo(String commentCode, String writerId, String writerName,
			String commentContent, String writeDate, String fileCode,
			int pageNum) {
		this.commentCode = commentCode;
		this.writerId = writerId;
		this.writerName = writerName;
		this.commentContent = commentContent;
		this.writeDate = writeDate;
		this.fileCode = fileCode;
		this.pageNum = pageNum;
	}

	public CommentInfo(String commentCode, String writerId,
			String commentContent, String writeDate, String fileCode,
			int pageNum) {
		this.commentCode = commentCode;
		this.writerId = writerId;
		this.writerName = "";
		this.commentContent = commentContent;
		this.writeDate = writeDate;
		this.fileCode = fileCode;
		this.pageNum = pageNum;
	}

	public CommentInfo() {
		this.parentCommentCode = "";
		this.commentCode = "";
		this.writerId = "";
		this.commentContent = "";
		this.writeDate = "";
		this.fileCode = "";
		this.pageNum = 0;
	}
	public String getParentCommentCode() {
		return parentCommentCode;
	}
	public void setParentCommentCode(String parentCommentCode) {
		this.parentCommentCode = parentCommentCode;
	}
	public String getCommentCode() {
		return commentCode;
	}
	public void setCommentCode(String commentCode) {
		this.commentCode = commentCode;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	@Override
	public String toString() {
		return "CommentInfo [parentCommentCode=" + parentCommentCode
				+ ", commentCode=" + commentCode + ", writerId=" + writerId
				+ ", writerName=" + writerName + ", commentContent="
				+ commentContent + ", writeDate=" + writeDate + ", fileCode="
				+ fileCode + ", pageNum=" + pageNum + "]";
	}
	
	
}
