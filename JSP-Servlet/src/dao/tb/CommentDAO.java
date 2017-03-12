package dao.tb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis.MyBatis;

import org.apache.ibatis.session.SqlSession;

import dto.tb.CommentDTO;

public class CommentDAO {
	public CommentDAO(){
		
	}
	
	public int insertComment(CommentDTO commentDTO){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.insert("comment.insertComment", commentDTO);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null){
				se.commit();
				se.close();
			}
		}
		return 0;
	}
	
	public int updateContent(int commentCode, String content){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		Map<String, String> map = new HashMap<String, String>();
		map.put("commentCode", Integer.toString(commentCode));
		map.put("content", content);
		try{
			return se.update("comment.updateContent", map);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null){
				se.commit();
				se.close();
			}
		}
		return 0;
	}
	
	public List<CommentDTO> selectAll(){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("comment.selectAll");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public List<Integer> selectCodes(){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("comment.selectCodes");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public CommentDTO selectComment(int commentCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectOne("comment.selectComment", commentCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public List<CommentDTO> selectComments(int fileCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("comment.selectComments", fileCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public List<CommentDTO> selectCommentCode(int fileCode, int slidePageNumber, int writerCode, String content, String writeDate){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		Map<String, String> map = new HashMap<String, String>();
		map.put("fileCode", Integer.toString(fileCode));
		map.put("slidePageNumber", Integer.toString(slidePageNumber));
		map.put("writerCode", Integer.toString(writerCode));
		map.put("content", content);
		map.put("writeDate", writeDate);
		try{
			return se.selectList("comment.selectCommentCode", map);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	
	public int deleteComment(int commentCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.delete("comment.deleteComment", commentCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null){
				se.commit();
				se.close();
			}
		}
		return 0;
	}
	public int deleteComments(int fileCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.delete("comment.deleteComments", fileCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null){
				se.commit();
				se.close();
			}
		}
		return 0;
	}
}
