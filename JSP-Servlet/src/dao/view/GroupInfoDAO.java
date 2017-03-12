package dao.view;

import java.util.List;

import mybatis.MyBatis;

import org.apache.ibatis.session.SqlSession;

import dto.view.GroupInfoDTO;
/**
 * 그룹관리 페이지 용 view
 * @author 문정현
 *
 */
public class GroupInfoDAO {
	public GroupInfoDAO(){
		
	}
	public List<GroupInfoDTO> selectGroupInfo(int hostCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("groupInfo.selectGroupInfo", hostCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se!=null)
				se.close();
		}
		return null;
	}
	public List<GroupInfoDTO> selectAll(){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("groupInfo.selectAll");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
}
