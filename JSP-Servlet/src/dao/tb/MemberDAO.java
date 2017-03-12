package dao.tb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis.MyBatis;

import org.apache.ibatis.session.SqlSession;

import dto.tb.MemberDTO;
/**
 * 
 * @author 문정현
 *
 */
public class MemberDAO {
	//private SqlSessionFactory sessionFactory;
	public MemberDAO(){
		//this.sessionFactory = MyBatis.getSqlSessionFactory();
	}
	public int insertMember(MemberDTO memberDTO){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.insert("member.insertMember", memberDTO);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.commit();
				session.close();
			}
		}
		return 0;
	}
	
	public int updatePassword(int memberCode, String newPw){
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("memberCode", Integer.toString(memberCode));
		hashMap.put("newPw", newPw);
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.update("member.updatePassword", hashMap);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.commit();
				session.close();
			}
		}
		return 0;
	}
	
	public MemberDTO selectMember(int memberCode){
		//SqlSession session = this.sessionFactory.openSession();
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.selectOne("member.selectMember", memberCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return null;
	}
	public List<Integer> selectCodes(){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.selectList("member.selectCodes");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return null;
	}
	public List<MemberDTO> selectAll(){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.selectList("member.selectAll");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		return null;
	}
	public String selectPassword(String memberId){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.selectOne("member.selectPassword", memberId);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return null;
	}
	public int selectMemberCode(String memberId){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.selectOne("member.selectMemberCode", memberId);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return 0;
	}
	public String selectMemberName(int memberCode){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.selectOne("member.selectMemberName", memberCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return null;
	}
	public int deleteMember(int memberCode){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.delete("member.deleteMember", memberCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.commit();
				session.close();
			}
		}
		return 0;
	}
	
	//// state가 새로 추가되서 생긴 메소드들
	public int updateMemberState(int memberCode){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.update("member.updateMemberState", memberCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.commit();
				session.close();
			}
		}
		return 0;
	}
	public String selectActiveMemberPassowrd(String id){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.selectOne("member.selectActiveMemberPassword", id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		return null;
	}
	public List<MemberDTO> selectActiveMembers(){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.selectList("member.selectActiveMembers");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		return null;
	}
	public MemberDTO selectActiveMember(int memberCode){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.selectOne("member.selectActiveMember", memberCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		return null;
	}
	public int selectActiveMemberCode(String memberId){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.selectOne("member.selectActiveMemberCode", memberId);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		return 0;
	}
	public MemberDTO selectActiveMember(String memberId, String memberPassword){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberId", memberId);
		map.put("memberPassword", memberPassword);
		try{
			return session.selectOne("member.selectActiveMember2", map);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		return null;
	}
	public String selectActiveMemberName(int memberCode){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.selectOne("member.selectActiveMemberName", memberCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		return null;
	}
	public String selectMemberState(int memberCode){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.selectOne("member.selectMemberState", memberCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		return null;
	}
}
