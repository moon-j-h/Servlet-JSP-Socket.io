package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.MemberManager;
import model.MemberInfo;

/**
 * 
 * @author ������
 *
 */
@WebServlet(
		name = "PwChange", 
		urlPatterns = { 
				"/pwChange1.do", 
				"/pwChange2.do", 
				"/goToPwChange.do"
		})
public class PwChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������ �̵�
		RequestDispatcher dis = request.getRequestDispatcher("page/pw_change_1.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = request.getRequestURI();
		//System.out.println(url);
		int lastIndex = url.lastIndexOf("/");
		String action = url.substring(lastIndex+1);
		HttpSession se = request.getSession();
		String id = (String)se.getAttribute("memberId");  // ���� �α����� ȸ���� ���̵�
		MemberManager mem = null;
		MemberInfo mInfo = null;
		if(action.equals("pwChange1.do")){
			System.out.println("��й�ȣ ���� step1");
			String pw = request.getParameter("pw"); // ��й�ȣ
			System.out.println("id : "+id+" , pw : "+pw);
			mem = new MemberManager();
			mInfo = mem.login(id, pw);
			if(mInfo != null){
				RequestDispatcher dis = request.getRequestDispatcher("page/pw_change_2.jsp");
				dis.forward(request, response);
			}else{
				request.setAttribute("error", "��й�ȣ�� �ٽ� �Է����ּ���.");
				RequestDispatcher dis = request.getRequestDispatcher("page/pw_change_1.jsp");
				dis.forward(request, response);
			}
		}else if(action.equals("pwChange2.do")){
			String pw = request.getParameter("password");
			System.out.println("pw : "+pw);
			mem = new MemberManager();
			if(mem.changePw(id, pw)){
				response.setContentType("text/plain;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("��й�ȣ ������ �����߽��ϴ�.");
				
			}
		}
		
	}

}
