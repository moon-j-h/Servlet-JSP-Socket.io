package dao.view;

import java.util.List;

import mybatis.MyBatis;

import org.apache.ibatis.session.SqlSession;

import dto.view.InviteInfoDTO;

public class InviteInfoDAO {
	public InviteInfoDAO(){
		
	}
	public List<InviteInfoDTO> selectInviteInfo(int guestCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("inviteInfo.selectInviteInfo", guestCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public List<InviteInfoDTO> selectAll(){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("inviteInfo.selectAll");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
}
