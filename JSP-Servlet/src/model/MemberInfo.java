package model;

import java.io.Serializable;
/**
 * 
 * @author ¹®Á¤Çö
 *
 */
public class MemberInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6043865334174075416L;
	private String memberCode;
	private String memberId;
	private String memberPassword;
	private String memberName;
	public MemberInfo(String memberCode, String memberId,
			String memberPassword, String memberName) {
		this.memberCode = memberCode;
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
	}
	public MemberInfo(String memberId, String memberPassword, String memberName) {
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
	}
	public MemberInfo() {
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return "MemberInfo [memberCode=" + memberCode + ", memberId="
				+ memberId + ", memberPassword=" + memberPassword
				+ ", memberName=" + memberName + "]";
	}
	
}
