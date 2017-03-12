package dao.view;

import java.util.List;

import mybatis.MyBatis;

import org.apache.ibatis.session.SqlSession;

import dto.view.ShareInfoDTO;

public class ShareInfoDAO {
	public ShareInfoDAO(){
		
	}
	public List<ShareInfoDTO> selectShareInfo(int joinerCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("shareInfo.selectShareInfo", joinerCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
	public List<ShareInfoDTO> selectAll(){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("shareInfo.selectAll");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se != null)
				se.close();
		}
		return null;
	}
}
