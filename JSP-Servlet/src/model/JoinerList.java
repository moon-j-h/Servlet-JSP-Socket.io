package model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * @author ¹®Á¤Çö
 *
 */
public class JoinerList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 13987836535150622L;
	private ArrayList<String> joinerIdList;
	private ArrayList<String> joinerNameList;
	public JoinerList(ArrayList<String> joinerIdList,
			ArrayList<String> joinerNameList) {
		this.joinerIdList = joinerIdList;
		this.joinerNameList = joinerNameList;
	}
	public JoinerList() {
		this.joinerIdList = new ArrayList<String>();
		this.joinerNameList = new ArrayList<String>();
	}
	public JoinerList(String memberId, String memberName) {
		this.joinerIdList = new ArrayList<String>();
		this.joinerNameList = new ArrayList<String>();
		this.joinerIdList.add(memberId);
		this.joinerNameList.add(memberName);
	}
	public ArrayList<String> getJoinerIdList() {
		return joinerIdList;
	}
	public void setJoinerIdList(ArrayList<String> joinerIdList) {
		this.joinerIdList = joinerIdList;
	}
	public ArrayList<String> getJoinerNameList() {
		return joinerNameList;
	}
	public void setJoinerNameList(ArrayList<String> joinerNameList) {
		this.joinerNameList = joinerNameList;
	}
	@Override
	public String toString() {
		return "JoinerList [joinerIdList=" + joinerIdList + ", joinerNameList="
				+ joinerNameList + "]";
	}
	
	public void addJoiner(String id, String name){
		this.joinerIdList.add(id);
		this.joinerNameList.add(name);
	}
	
	public void removeJoiner(String id, String name){
		this.joinerIdList.remove(id);
		this.joinerNameList.remove(name);
	}
	public boolean isJoiner(String joinerId){
		for(String id : this.joinerIdList){
			if(id.equals(joinerId))
				return true;
		}
		return false;
	}
}
