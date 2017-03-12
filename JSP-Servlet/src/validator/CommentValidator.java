package validator;

import form.CommentForm;
import form.RecommentForm;
/**
 * 
 * @author ¹®Á¤Çö
 *
 */
public class CommentValidator {
	public CommentValidator(){};
	public boolean validateCommentForm(CommentForm commentForm){
		if(this.validatePageNum(commentForm.getPageNum()) && this.validateCommentContent(commentForm.getCommentContent()))
			return true;
		return false;
	}
	public boolean validateCommentForm(RecommentForm recommnetForm){
		if(this.validateParentCommentCode(recommnetForm.getParentCommentCode()) && this.validatePageNum(recommnetForm.getPageNum()) && this.validateCommentContent(recommnetForm.getCommentContent()))
			return true;
		return false;
	}
	private boolean validatePageNum(String pageNum){
		String num = pageNum.trim();
		if(num.equals(""))
			return false;
		else{
			try{
				Integer.parseInt(num);
			}catch(NumberFormatException nfe){
				return false;
			}
		}
		return true;
	}
	private boolean validateCommentContent(String commentContent){
		String content = commentContent.trim();
		if(content.equals(""))
			return false;
		else{
			if(content.length()>500)
				return false;
		}
		return true;
	}
	private boolean validateParentCommentCode(String parentCommentCode){
		String parent = parentCommentCode.trim();
		if(parent.equals(""))
			return false;
		else{
			try{
				Integer.parseInt(parent);
			}catch(NumberFormatException nfe){
				return false;
			}
		}
		return true;
	}
}
