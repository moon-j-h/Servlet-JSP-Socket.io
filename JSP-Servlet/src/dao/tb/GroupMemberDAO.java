package dao.tb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis.MyBatis;

import org.apache.ibatis.session.SqlSession;

import dto.tb.GroupMemberDTO;

public class GroupMemberDAO {
	public GroupMemberDAO(){
		
	}
	
	public int insertGroupMember(GroupMemberDTO groupMemberDTO){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.insert("groupMember.insertGroupMember", groupMemberDTO);
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
	
	public int updateMemberCode(int groupCode, int oldMemberCode, int newMemberCode){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("groupCode", groupCode);
		map.put("oldMemberCode", oldMemberCode);
		map.put("newMemberCode", newMemberCode);
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.update("groupMember.updateMemberCode", map);
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
	
	public List<GroupMemberDTO> selectAll(){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("groupMember.selectAll");
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
			return se.selectList("groupMember.selectCodes");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public GroupMemberDTO selectGroupMember(int groupMemberCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectOne("groupMember.selectGroupMember", groupMemberCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public List<GroupMemberDTO> selectGroupMembers(int groupCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("groupMember.selectGroupMembers", groupCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public int selectGroupMemberCode(int groupCode, int memberCode){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("groupCode", groupCode);
		map.put("memberCode", memberCode);
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectOne("groupMember.selectGroupMemberCode", map);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return 0;
	}
	
	public int deleteGroupMember(int groupMemberCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.delete("groupMember.deleteGroupMember1", groupMemberCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se !=null){
				se.commit();
				se.close();
			}
		}
		return 0;
	}
	public int deleteGroupMember(int groupCode, int memberCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("groupCode", groupCode);
		map.put("memberCode", memberCode);
		try{
			return se.delete("groupMember.deleteGroupMember2", map);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se !=null){
				se.commit();
				se.close();
			}
		}
		return 0;
	}
	public int deleteGroupMembersByGroupCode(int groupCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.delete("groupMember.deleteGroupMembersByGroupCode", groupCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se !=null){
				se.commit();
				se.close();
			}
		}
		return 0;
	}
	public int deleteGroupMembersByMemberCode(int MemberCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.delete("groupMember.deleteGroupMembersByMemberCode", MemberCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se !=null){
				se.commit();
				se.close();
			}
		}
		return 0;
	}
}
