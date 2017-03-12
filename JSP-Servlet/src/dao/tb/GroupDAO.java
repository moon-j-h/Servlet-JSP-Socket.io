package dao.tb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis.MyBatis;

import org.apache.ibatis.session.SqlSession;

import dto.tb.GroupDTO;

public class GroupDAO {
	public GroupDAO(){
		
	}
	public int insertGroup(GroupDTO groupDTO){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.insert("group.insertGroup", groupDTO);
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
	
	public int updateGroupName(int groupCode, String groupName){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		Map<String, String> ha = new HashMap<String, String>();
		ha.put("groupCode", Integer.toString(groupCode));
		ha.put("groupName", groupName);
		try{
			return se.update("group.updateGroupName", ha);
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
	
	public List<GroupDTO> selectAll(){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("group.selectAll");
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
			return se.selectList("group.selectCodes");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se!=null)
				se.close();
		}
		return null;
	}
	public GroupDTO selectGroup(int groupCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectOne("group.selectGroup", groupCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			se.close();
		}
		return null;
	}
	public List<GroupDTO> selectGroups(int hostCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("group.selectGroups", hostCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se!=null)
				se.close();
		}
		return null;
	}
	public int selectGroupCode(int hostCode, String groupName){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		Map<String, String> ha = new HashMap<String,String>();
		ha.put("hostCode", Integer.toString(hostCode));
		ha.put("groupName", groupName);
		try{
			return se.selectOne("group.selectGroupCode", ha);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se!=null)
				se.close();
		}
		return 0;
	}
	public List<Integer> selectGroupCodes(int hostCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("group.selectGroupCodes", hostCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	
	public int deleteGroup(int groupCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.delete("group.deleteGroup", groupCode);
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
	public int deleteGroups(int hostCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.delete("group.deleteGroups", hostCode);
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
