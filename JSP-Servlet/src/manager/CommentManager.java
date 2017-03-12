package manager;

import java.util.ArrayList;

import model.CommentInfo;
import model.CommentInfoList;
import model.ShareInfo;
import dbmanager.CommentDBManager;
/**
 * 
 * @author ¹®Á¤Çö
 *
 */
public class CommentManager {
	public CommentManager(){
		
	}
	public ArrayList<ShareInfo> watchSharePage(String id){
		CommentDBManager db = new CommentDBManager();
		return  db.selectSharePage(id);
	}
	
	public CommentInfoList watchComment(String fileCode){
		CommentDBManager db = new CommentDBManager();
		return db.selectComment(fileCode);
	}
	public CommentInfoList watchComment(String fileCode, int pageNum){
		CommentDBManager db = new CommentDBManager();
		return db.selectComment(fileCode, pageNum);
	}
	
	public CommentInfoList writeComment(CommentInfo commentInfo){
		CommentDBManager db = new CommentDBManager();
		return db.insertComment(commentInfo);
	}
	
	public CommentInfoList deleteComment(String commentCode){
		CommentDBManager db = new CommentDBManager();
		return db.deleteComment(commentCode);
	}
	public CommentInfoList updateComment(String commentCode, CommentInfo commentInfo){
		CommentDBManager db = new CommentDBManager();
		return db.updateComment(commentCode, commentInfo);
	}
	
	public String getFileAddress(String fileCode){
		CommentDBManager db = new CommentDBManager();
		return db.selectFileAddress(fileCode);
	}
}
