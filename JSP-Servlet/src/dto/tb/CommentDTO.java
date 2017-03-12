package dto.tb;

public class CommentDTO {
	private int commentCode;
	private int fileCode;
	private int slidePageNumber;
	private int writerCode;
	private String content;
	private String writeDate;
	private int superCommentCode;
	public CommentDTO(int commentCode, int fileCode, int slidePageNumber,
			int writerCode, String content, String writeDate,
			int superCommentCode) {
		this.commentCode = commentCode;
		this.fileCode = fileCode;
		this.slidePageNumber = slidePageNumber;
		this.writerCode = writerCode;
		this.content = content;
		this.writeDate = writeDate;
		this.superCommentCode = superCommentCode;
	}
	public CommentDTO() {
		this.commentCode=0;
		this.fileCode=0;
		this.slidePageNumber=0;
		this.writerCode=0;
		this.content="";
		this.writeDate="";
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
	public int getWriterCode() {
		return writerCode;
	}
	public void setWriterCode(int writerCode) {
		this.writerCode = writerCode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public int getSuperCommentCode() {
		return superCommentCode;
	}
	public void setSuperCommentCode(int superCommentCode) {
		this.superCommentCode = superCommentCode;
	}
	@Override
	public String toString() {
		return "CommentDTO [commentCode=" + commentCode + ", fileCode="
				+ fileCode + ", slidePageNumber=" + slidePageNumber
				+ ", writerCode=" + writerCode + ", content=" + content
				+ ", writeDate=" + writeDate + ", superCommentCode="
				+ superCommentCode + "]";
	}
	
}
