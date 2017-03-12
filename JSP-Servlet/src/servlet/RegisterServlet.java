package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.MemberManager;
import model.MemberInfo;
import validator.MemberValidator;
import form.RegisterForm;

/**
 * 
 * @author 문정현
 *
 */
@WebServlet(name = "Register", urlPatterns = { "/register.do" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		register(request, response);
	}
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("name : "+name+" email : "+email+" password : "+password);
		RegisterForm form = new RegisterForm(name, email, password);
		MemberValidator va = new MemberValidator();
		// 유효성 검사
		if(!va.validateRegisterForm(form))
			return;
		MemberInfo info = new MemberInfo(email, password, name); 
		MemberManager ma = new MemberManager();
		if(!ma.register(info))
			return; // 회원 가입 실패
		RequestDispatcher dis = request.getRequestDispatcher("page/login.jsp");
		dis.forward(request, response);
	}

}
