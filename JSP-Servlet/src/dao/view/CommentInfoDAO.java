package dao.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis.MyBatis;

import org.apache.ibatis.session.SqlSession;

import dto.view.CommentInfoDTO;

public class CommentInfoDAO {
	public CommentInfoDAO(){
		
	}
	public List<CommentInfoDTO> selectCommentInfo(int fileCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("commentInfo.selectCommentInfo", fileCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se!=null)
				se.close();
		}
		return null;
	}
	public List<CommentInfoDTO> selectCommentInfo(int fileCode, int slidePageNumber){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("fileCode", fileCode);
		map.put("slidePageNumber", slidePageNumber);
		try{
			return se.selectList("commentInfo.selectCommentInfoByPageNumber", map);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se!=null)
				se.close();
		}
		return null;
	}
	public List<CommentInfoDTO> selectAll(){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("commentInfo.selectAll");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se!=null)
				se.close();
		}
		return null;	
	}
}
