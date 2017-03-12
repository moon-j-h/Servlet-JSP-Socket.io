package validator;

import form.LoginForm;
import form.RegisterForm;
/**
 * 
 * @author ¹®Á¤Çö
 *
 */
public class MemberValidator {
	public MemberValidator(){
		
	}
	public boolean validateLoginForm(LoginForm loginForm){
		if(this.validateId(loginForm.getId()) && this.validatePw(loginForm.getPw()))
			return true;
		return false;
	}
	public boolean validateRegisterForm(RegisterForm registerForm){
		if(this.validateId(registerForm.getId()) && this.validatePw(registerForm.getPw()) && this.validateName(registerForm.getName()))
			return true;
		return false;
	}
	public boolean validateId(String id){
		String temp = id.trim();
		int atpos = temp.indexOf("@");
		int dotpos = temp.indexOf(".");
		if(temp.equals("") || atpos<1 || dotpos < atpos+2 || dotpos+2 >= temp.length())
			return false;
		return true;
	}
	public boolean validatePw(String pw){
		String temp = pw.trim();
		if(temp.equals("") || temp.length() < 8 || temp.length() > 12)
			return false;
		return true;
		
	}
	public boolean validateName(String name){
		String temp = name.trim();
		if(temp.equals(""))
			return false;
		return true;
	}
}
