package manager;

import model.MemberInfo;
import dbmanager.MemberDBManager;
/**
 * 
 * @author ¹®Á¤Çö
 *
 */
public class MemberManager {
	public MemberManager(){
		
	}
	public boolean register(MemberInfo memberInfo){
		MemberDBManager db = new MemberDBManager();
		return db.insertMember(memberInfo);
	}
	public MemberInfo login(String id, String pw){
		MemberDBManager db = new MemberDBManager();
		return db.login(id, pw);
	}
	public boolean changePw(String id, String newPw){
		MemberDBManager db = new MemberDBManager();
		return db.updatePw(id, newPw);
	}
	
}
