package dao.tb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis.MyBatis;

import org.apache.ibatis.session.SqlSession;

import dto.tb.FileDTO;

public class FileDAO {
	public FileDAO(){
		
	}
	/**
	 * 파일정보를 관리하는 테이블에 파일정보를 추가한다.
	 * 만약, 등록 날짜를 오늘 날짜로 자동 저장하고 싶다면 FileDTO를 생성할 때 날짜를 받지 않는 인자를 생성하면 된다.
	 * @param fileDTO 파일 정보를 캡슐화한 클래스
	 * @return 성공 - 1<br/>실패 - 0
	 */
	public int insertFile(FileDTO fileDTO){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.insert("file.insertFile", fileDTO);
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
	
	public int updateFileAddress(int fileCode, String fileAddress){
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("fileCode", Integer.toString(fileCode));
		hashMap.put("fileAddress", fileAddress);
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.update("file.updateFileAddressOrName", hashMap);
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
	public int updateFileName(int fileCode, String fileName){
		Map<String, String> ha = new HashMap<String, String>();
		ha.put("fileCode", Integer.toString(fileCode));
		ha.put("fileName", fileName);
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.update("file.updateFileAddressOrName", ha);
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
	
	/**
	 * 테이블에 존재하는 모든 파일의 정보를 가져온다.
	 * @return 파일 목록
	 */
	public List<FileDTO> selectAll(){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.selectList("file.selectAll");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return null;
	}
	/**
	 * 특정 파일에 대한 정보를 가져온다.
	 * @param fileCode 파일 코드
	 * @return 파일에 대한 정보
	 */
	public FileDTO selectFile(int fileCode){
		SqlSession session = MyBatis.getSqlSessionFactory().openSession();
		try{
			return session.selectOne("file.selectFile", fileCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return null;
	}
	public List<String> selectCodes(){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("file.selectCodes");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se !=null)
				se.close();
		}
		return null;
	}
	public List<FileDTO> selectFiles(int hostCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectList("file.selectFiles", hostCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se!=null)
				se.close();
		}
		return null;
	}
	
	public int selectFileCode(int hostCode, String fileAddress, String fileName){
		Map<String, String> hash = new HashMap<String, String>();
		hash.put("hostCode", Integer.toString(hostCode));
		hash.put("fileAddress", fileAddress);
		hash.put("fileName", fileName);
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectOne("file.selectFileCode", hash);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se!=null)
				se.close();
		}
		return 0;
	}
	public String selectFileAddress(int fileCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.selectOne("file.selectFileAddress", fileCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(se!=null)
				se.close();
		}
		return null;
	}
	public int deleteFile(int fileCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.delete("file.deleteFile", fileCode);
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
	public int deleteFiles(int hostCode){
		SqlSession se = MyBatis.getSqlSessionFactory().openSession();
		try{
			return se.delete("file.deleteFiles", hostCode);
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
}
