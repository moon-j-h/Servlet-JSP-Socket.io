package dbmanager;

import model.MemberInfo;
import dao.tb.MemberDAO;
import dto.tb.MemberDTO;
/**
 * 
 * @author ¹®Á¤Çö
 *
 */
public class MemberDBManager {
	private MemberDAO memberDAO;
	public MemberDBManager(){
		this.memberDAO = new MemberDAO();
	}
	public MemberDBManager(MemberDAO memberDAO){
		this.memberDAO = memberDAO;
	}
	public boolean insertMember(MemberInfo memberInfo){
		MemberDTO dto = new MemberDTO(0, memberInfo.getMemberId(), memberInfo.getMemberPassword(), memberInfo.getMemberName());
		int res = this.memberDAO.insertMember(dto);
		if(res == 1)
			return true;
		else
			return false;
	}
	public MemberInfo login(String id, String pw){
		MemberDTO dto = this.memberDAO.selectActiveMember(id, pw);
		if(dto!=null){
			return new MemberInfo(Integer.toString(dto.getMemberCode()), dto.getMemberId(), "", dto.getMemberName());
		}else
			return null;
	}
	public boolean updatePw(String id, String newPw){
		int code = this.memberDAO.selectActiveMemberCode(id);
		if(code != 0){
			this.memberDAO.updatePassword(code, newPw);
			return true;
		}else
			return false;
	}
	public int selectMemberCode(String id){
		return this.memberDAO.selectActiveMemberCode(id);
	}
	public MemberDAO getMemberDAO() {
		return memberDAO;
	}
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
}
