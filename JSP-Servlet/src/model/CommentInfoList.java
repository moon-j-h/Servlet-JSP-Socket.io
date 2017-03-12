package model;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * 
 * @author 문정현
 *
 */
public class CommentInfoList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6500936750845927023L;
	private ArrayList<CommentInfo> commentInfoList;

	public CommentInfoList(ArrayList<CommentInfo> commentInfoList) {
		this.commentInfoList = commentInfoList;
	}
	public CommentInfoList(CommentInfo commentInfo){
		this.commentInfoList = new ArrayList<CommentInfo>();
		this.commentInfoList.add(commentInfo);
	}
	public CommentInfoList(String parentCommentCode, String commentCode, String writerId, String commentContent, String writeDate, int pageNum, String fileCode){
		this.commentInfoList = new ArrayList<CommentInfo>();
		this.commentInfoList.add(new CommentInfo(parentCommentCode, commentCode, writerId, commentContent, writeDate, fileCode, pageNum));
	}
	public CommentInfoList() {
		this.commentInfoList = new ArrayList<CommentInfo>();
	}

	public ArrayList<CommentInfo> getCommentInfoList() {
		return commentInfoList;
	}

	public void setCommentInfoList(ArrayList<CommentInfo> commentInfoList) {
		this.commentInfoList = commentInfoList;
	}
	
	public void addCommentInfo(CommentInfo commentInfo){
		this.commentInfoList.add(commentInfo);
	}
	public void addCommentInfo(String parentCommentCode, String commentCode, String writerId, String writerName, String commentContent, String writeDate, int pageNum, String fileCode){
		this.commentInfoList.add(new CommentInfo(parentCommentCode, commentCode, writerId, writerName, commentContent, writeDate, fileCode, pageNum));
	}
	
	public CommentInfo searchCommentInfo(int index){
		return this.commentInfoList.get(index);
	}
	public CommentInfo searchCommentInfo(String commentCode){
		for(CommentInfo comment : this.commentInfoList){
			if(comment.getCommentCode().equals(commentCode))
				return comment;
		}
		return null;
	}
	public ArrayList<CommentInfo> searchCommentInfoById(String writerId){
		ArrayList<CommentInfo> list = new ArrayList<CommentInfo>();
		for(CommentInfo comment : this.commentInfoList){
			if(comment.getWriterId().equals(writerId))
				list.add(comment);
		}
		return list;
	}
	public ArrayList<CommentInfo> searchCommentInfoByDate(String writeDate){
		ArrayList<CommentInfo> list = new ArrayList<CommentInfo>();
		for(CommentInfo comment : this.commentInfoList){
			if(comment.getWriteDate().equals(writeDate))
				list.add(comment);
		}
		return list;
	}
	public ArrayList<CommentInfo> searchCommentInfoByFileCode(String fileCode){
		ArrayList<CommentInfo> list = new ArrayList<CommentInfo>();
		for(CommentInfo comment : this.commentInfoList){
			if(comment.getFileCode().equals(fileCode))
				list.add(comment);
		}
		return list;
	}
	public ArrayList<CommentInfo> searchCommentInfoByFileCodeAndPageNum(String fileCode, int pageNum){
		ArrayList<CommentInfo> list = new ArrayList<CommentInfo>();
		for(CommentInfo comment : this.commentInfoList){
			if(comment.getFileCode().equals(fileCode) && comment.getPageNum() == pageNum)
				list.add(comment);
		}
		return list;
	}
	public ArrayList<CommentInfo> searchCommentInfoByFileCodeAndId(String fileCode, String writerId){
		ArrayList<CommentInfo> list = new ArrayList<CommentInfo>();
		for(CommentInfo comment : this.commentInfoList){
			if(comment.getFileCode().equals(fileCode) && comment.getWriterId().equals(writerId))
				list.add(comment);
		}
		return list;
	}
	
	public int removeCommentInfo(int index){
		if(this.commentInfoList.remove(index) != null)
			return 1;
		else
			return 0;
	}
	public int removeCommentInfo(String fileCode, String writerId, int pageNum){
		int count = 0;
		for(CommentInfo comment : this.commentInfoList){
			if(comment.getFileCode().equals(fileCode) && comment.getWriterId().equals(writerId) && comment.getPageNum() == pageNum){
				this.commentInfoList.remove(comment);
				++count;
			}
		}
		return count;
	}
	public int removeCommentInfo(String fileCode, String commentCode){
		int count = 0;
		for(CommentInfo comment : this.commentInfoList){
			if(comment.getFileCode().equals(fileCode) && comment.getCommentCode().equals(commentCode)){
				this.commentInfoList.remove(comment);
				++count;
			}
		}
		return count;
	}
	public int removeCommentInfoByFileCode(String fileCode){
		int count = 0;
		for(CommentInfo comment : this.commentInfoList){
			if(comment.getFileCode().equals(fileCode)){
				this.commentInfoList.remove(comment);
				++count;
			}
		}
		return count;
	}
	public int removeCommentInfoById(String writerId){
		int count = 0;
		for(CommentInfo comment : this.commentInfoList){
			if(comment.getWriterId().equals(writerId)){
				this.commentInfoList.remove(comment);
				++count;
			}
		}
		return count;
	}
	
	public void modifyCommentContent(int index, String commentContent){
		CommentInfo info = this.commentInfoList.get(index);
		info.setCommentContent(commentContent);
		this.commentInfoList.set(index, info);
	}
	public void modifyCommentContent(String commentCode, String commentContent){
		CommentInfo info = null;
		for(int i=0; i<this.commentInfoList.size(); i++){
			info = this.commentInfoList.get(i);
			if(info.getCommentCode().equals(commentCode)){
				info.setCommentContent(commentContent);
				this.commentInfoList.set(i, info);
				break;
			}
		}
	}
	
	@Override
	public String toString() {
		return "CommentInfoList [commentInfoList=" + commentInfoList + "]";
	}
	// 추가
	public int size(){
		return this.commentInfoList.size();
	}
	public void sortComment(){
		ArrayList<CommentInfo> parent = new ArrayList<CommentInfo>();
		ArrayList<CommentInfo> children = new ArrayList<CommentInfo>();
		for(CommentInfo temp : this.commentInfoList){
			if(temp.getParentCommentCode() == null) // 부모 댓글
				parent.add(temp);
			else  // 자식 댓글
				children.add(temp);
		}
		
		ArrayList<CommentInfo> total = new ArrayList<CommentInfo>();
		for(CommentInfo temp : parent){
			total.add(temp);
			for(CommentInfo temp2 : children){
				if(temp2.getParentCommentCode().equals(temp.getCommentCode())){
					total.add(temp2);
					//children.remove(temp2);
				}
			}
		}
		this.commentInfoList = total;
	}
}
