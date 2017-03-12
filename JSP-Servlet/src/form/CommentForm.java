package form;
/**
 * 
 * @author ¹®Á¤Çö
 *
 */
public class CommentForm {
	private String pageNum;
	private String commentContent;
	public CommentForm(String pageNum, String commentContent) {
		this.pageNum = pageNum;
		this.commentContent = commentContent;
	}
	public CommentForm() {
		this.pageNum = "";
		this.commentContent = "";
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
		return "CommentForm [pageNum=" + pageNum + ", commentContent="
				+ commentContent + "]";
	}
	
}
