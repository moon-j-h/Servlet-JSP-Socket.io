package dto.view;

public class CommentInfoDTO {
	private int commentCode;
	private int fileCode;
	private int slidePageNumber;
	private String writerId;
	private String writerName;
	private String writeDate;
	private String commentContent;
	private int superCommentCode;
	public CommentInfoDTO(int commentCode, int fileCode, int slidePageNumber,
			String writerId, String writerName, String writeDate,
			String commentContent, int superCommentCode) {
		this.commentCode = commentCode;
		this.fileCode = fileCode;
		this.slidePageNumber = slidePageNumber;
		this.writerId = writerId;
		this.writerName = writerName;
		this.writeDate = writeDate;
		this.commentContent = commentContent;
		this.superCommentCode = superCommentCode;
	}
	public CommentInfoDTO() {
		this.commentCode=0;
		this.fileCode=0;
		this.slidePageNumber=0;
		this.writerId="";
		this.writerName="";
		this.writeDate="";
		this.commentContent="";
		this.superCommentCode=0;
	}
	public int getCommentCode() {
		return commentCode;
	}
	public void setCommentCode(int commentCode) {
		this.commentCode = commentCode;
	}
	public int getFileCode() {
		return fileCode;
	}
	public void setFileCode(int fileCode) {
		this.fileCode = fileCode;
	}
	public int getSlidePageNumber() {
		return slidePageNumber;
	}
	public void setSlidePageNumber(int slidePageNumber) {
		this.slidePageNumber = slidePageNumber;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public int getSuperCommentCode() {
		return superCommentCode;
	}
	public void setSuperCommentCode(int superCommentCode) {
		this.superCommentCode = superCommentCode;
	}
	@Override
	public String toString() {
		return "CommentInfoDTO [commentCode=" + commentCode + ", fileCode="
				+ fileCode + ", slidePageNumber=" + slidePageNumber
				+ ", writerId=" + writerId + ", writerName=" + writerName
				+ ", writeDate=" + writeDate + ", commentContent="
				+ commentContent + ", superCommentCode=" + superCommentCode
				+ "]";
	}
	
}
