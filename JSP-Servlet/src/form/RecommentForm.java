package form;
/**
 * 
 * @author ¹®Á¤Çö
 *
 */
public class RecommentForm {
	private String parentCommentCode;
	private String pageNum;
	private String commentContent;
	public RecommentForm(String parentCommentCode, String pageNum,
			String commentContent) {
		this.parentCommentCode = parentCommentCode;
		this.pageNum = pageNum;
		this.commentContent = commentContent;
	}
	
	public RecommentForm() {
		this.parentCommentCode = "";
		this.pageNum = "";
		this.commentContent = "";
	}
	
	public String getParentCommentCode() {
		return parentCommentCode;
	}
	public void setParentCommentCode(String parentCommentCode) {
		this.parentCommentCode = parentCommentCode;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	@Override
	public String toString() {
		return "RecommentForm [parentCommentCode=" + parentCommentCode
				+ ", pageNum=" + pageNum + ", commentContent=" + commentContent
				+ "]";
	}
	
}
