package dao.tb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis.MyBatis;

import org.apache.ibatis.session.SqlSession;

import dto.tb.InviteDTO;
/**
 * 초대 정보를 가져오기 위한 DAO
 * @author 문정현
 *
 */
public class InviteDAO {
	public InviteDAO(){
		
	}
	public int insertInvite(InviteDTO inviteDTO){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.insert("invite.insertInvite", inviteDTO);
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
	
	public int updateInviteStateToInactive(int inviteCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.update("invite.updateInviteStateToInactive", inviteCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se!= null){
				se.commit();
				se.close();
			}
		}
		return 0;
	}
	
	public List<InviteDTO> selectAll(){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("invite.selectAll");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public List<InviteDTO> selectActivieInvites(){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("invite.selectActiveInvites");
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
			return se.selectList("invite.selectCodes");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public InviteDTO selectInvite(int inviteCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectOne("invite.selectInvite", inviteCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public List<InviteDTO> selectInvites(int guestCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("invite.selectInvites", guestCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public int selectInviteCode(int fileCode, int guestCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("fileCode", fileCode);
		map.put("guestCode", guestCode);
		try{
			return se.selectOne("invite.selectInviteCode", map);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return 0;
	}
	
	public int deleteInvite(int inviteCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.delete("inviet.deleteInvite", inviteCode);
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
	public int deleteInvitesByFileCode(int fileCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.delete("inviet.deleteInvites1", fileCode);
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
	public int deleteInvitesByGuestCode(int guestCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.delete("inviet.deleteInvites2", guestCode);
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
	public int deleteInactiveInvite(int guestCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.delete("inviet.deleteInactive", guestCode);
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
