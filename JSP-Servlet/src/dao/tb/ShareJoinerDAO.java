package dao.tb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis.MyBatis;

import org.apache.ibatis.session.SqlSession;

import dto.tb.ShareJoinerDTO;

/**
 * 파일을 공유한 회원들의 정보를 저장한 테이블에 접근하기 위한 DAO 클래스
 * @author 문정현
 *
 */
public class ShareJoinerDAO {
	public ShareJoinerDAO(){
		
	}
	
	public int insertShareJoiner(ShareJoinerDTO shareJoinerDTO){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.insert("shareJoiner.insertShareJoiner", shareJoinerDTO);
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
	
	public int updateJoinerCode(int fileCode, int oldJoinerCode, int newJoinerCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("fileCode", fileCode);
		map.put("oldJoinerCode", oldJoinerCode);
		map.put("newJoinerCode", newJoinerCode);
		try{
			return se.update("shareJoiner.updateJoinerCode", map);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se!=null){
				se.commit();
				se.close();
			}
		}
		return 0;
	}
	
	public List<ShareJoinerDTO> selectAll(){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("shareJoiner.selectAll");
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
			return se.selectList("shareJoiner.selectCodes");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public ShareJoinerDTO selectShareJoiner(int shareCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectOne("shareJoiner.selectShareJoiner1", shareCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public ShareJoinerDTO selectShareJoiner(int fileCode, int joinerCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("fileCode", fileCode);
		map.put("joinerCode", joinerCode);
		try{
			return se.selectOne("shareJoiner.selectShareJoiner2", map);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public List<ShareJoinerDTO> selectShareJoinersByFileCode(int fileCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("shareJoiner.selectShareJoiners1", fileCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public List<ShareJoinerDTO> selectShareJoinersByJoinerCode(int joinerCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("shareJoiner.selectShareJoiners2", joinerCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public List<ShareJoinerDTO> selectShareCode(int fileCode, int joinerCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("fileCode", fileCode);
		map.put("joinerCode", joinerCode);
		try{
			return se.selectList("shareJoiner.selectShareJoinerCode", map);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	
	public int deleteShareJoiner(int shareCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.delete("shareJoiner.deleteShareJoiner1", shareCode);
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
	public int deleteShareJoiner(int fileCode, int joinerCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		Map<String, Integer> map =new HashMap<String, Integer>();
		map.put("fileCode", fileCode);
		map.put("joinerCode", joinerCode);
		try{
			return se.delete("shareJoiner.deleteShareJoiner2", map);
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
	public int deleteShareJoinersByFileCode(int fileCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.delete("shareJoiner.deleteShareJoinersByFileCode", fileCode);
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
	public int deleteShareJoinersByJoinerCode(int joinerCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.delete("shareJoiner.deleteShareJoinersByJoinerCode", joinerCode);
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
